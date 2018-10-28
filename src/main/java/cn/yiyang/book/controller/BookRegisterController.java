package cn.yiyang.book.controller;

import cn.yiyang.book.entity.BookRegisterEntity;
import cn.yiyang.book.service.BookRegisterService;
import cn.yiyang.common.utils.*;
import cn.yiyang.common.utils.JUtils.beanConvert.BeanMapConvert;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;


/**
 * 三峡大学校友会信息登记表
 *
 * @author wangyiyang
 * @email 1023097289@qq.com
 * @date 2018-10-23 12:55:28
 */
@RestController
@CrossOrigin
@RequestMapping("book/bookregister")
public class BookRegisterController {

    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private BookRegisterService bookRegisterService;
    @Autowired
    private RedisUtil redisUtil;
    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestBody Map<String, Object> params){
        PageUtils page = bookRegisterService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{bookId}")
    public R info(@PathVariable("bookId") String bookId){
			BookRegisterEntity bookRegister = bookRegisterService.selectById(bookId);

        return R.ok().put("bookRegister", bookRegister);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody BookRegisterEntity bookRegister){
			bookRegisterService.insert(bookRegister);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody BookRegisterEntity bookRegister){
			bookRegisterService.updateById(bookRegister);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody String[] bookIds){
			bookRegisterService.deleteBatchIds(Arrays.asList(bookIds));

        return R.ok();
    }

    /**
     * @Author Administrator
     * @Description 获取管理员的个人信息
     * @Date 16:18 2018/10/11
     * @Param
     * @return
     **/
    @PostMapping("/loginBooker")
    @ResponseBody
    public ResultBean loginBooker(@RequestBody Map<String, String> userInfo) {
        String username = userInfo.get("username");
        String password = userInfo.get("password");

        //登录成功返回给前端的数据
        Map<String, Object> res = Maps.newHashMap();
        ArrayList<String> roles = Lists.newArrayList();
        roles.add("editor");
        res.put("roles", roles);
        res.put("introduction", "管理人员");
        res.put("avatar", "https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        res.put("name", "余霖");

        if ("admin".equals(username) && "1111111".equals(password)) {
            return ResultBean.success(res);
        } else {
            return ResultBean.error("账号或密码错误");
        }
    }
    /**
     * @Author wangyiyang
     * @Description 根据手机号判断用户是否已提交
     * @Date 12:56 2018/10/24
     * @Param 
     * @return 
     **/
    @ApiOperation(value = "根据手机号判断用户是否已提交")
    @ApiImplicitParam(name = "bookRegisterEntity", value = "只包含bookPhone的实体")
    @PostMapping("/getBookerByBookPhone")
    @ResponseBody
    public ResultBean getBookerByBookPhone(@RequestBody BookRegisterEntity bookRegisterEntity) {
        BookRegisterEntity booker = bookRegisterService.getBookerByBookPhone(bookRegisterEntity);
        if(booker != null) {
            return ResultBean.error();
        } else {
            return ResultBean.success();
        }
    }
    /**
     * @Author wangyiyang
     * @Description 用户获取验证码
     * @Date 14:08 2018/10/24
     * @Param 
     * @return 
     **/
    @ApiOperation(value = "用户获取短信验证码接口")
    @ApiImplicitParam(name = "bookPhone", value = "用户手机号")
    @PostMapping("/getMsgCodeByBookPhone")
    public ResultBean getMsgCodeByBookPhone(@RequestBody String bookPhone) {
        return bookRegisterService.getMsgCodeByBookPhone(bookPhone);
    }

    /**
     * @Author wangyiyang
     * @Description 新增用户
     * @Date 13:02 2018/10/23
     * @Param 
     * @return 
     **/
    @ApiOperation(value = "新增用户")
    @ApiImplicitParam(name = "map", value = "用户实体")
    @PostMapping("/addBooker")
    public ResultBean addBooker(@RequestBody Map<String, String> map) {
        String phone = map.get("bookPhone");
        String codeTrue = (String) redisUtil.get(phone);
        String code = map.get("bookMsgCode");
        BookRegisterEntity bean = new BookRegisterEntity();
        if(code.equals(codeTrue)) {
            bean = (BookRegisterEntity) BeanMapConvert.map2Bean(map, bean);
            Integer integer = bookRegisterService.addBooker(bean);
            redisUtil.del(phone);
            if(integer > 0) {
                return ResultBean.success(integer);
            } else {
                return ResultBean.error("服务器错误，请稍后重试");
            }
        } else {
            return ResultBean.error("验证码错误");
        }
    }

    @ApiOperation(value = "数据导出接口")
    @GetMapping("/exportBookerExcel")
    public void exportBookerExcel(HttpServletResponse response) throws Exception {
        String filename = "同学录.xls";
        //设置下载头信息
        response.setContentType("application/ms-excel;charset=UTF-8");
        response.setHeader("Content-Disposition", "attachment;filename="+new String(filename.getBytes(),"iso-8859-1"));
        ServletOutputStream out = response.getOutputStream();
        EntityWrapper<BookRegisterEntity> entityWrapper = new EntityWrapper<>();
        List<BookRegisterEntity> list = bookRegisterService.selectList(entityWrapper);
        List<Map<String, Object>> newArrayList = Lists.newArrayList();
        list.forEach(v -> {
            Map<String, Object> map = Maps.newHashMap();
            Map<String, Object> object = BeanMapConvert.bean2MapObject(v);
            for (String s : object.keySet()) {
                if(object.get(s) != null) {
                    map.put(s, object.get(s));
                }
            }
            newArrayList.add(map);
        });
        LinkedHashMap<String, String> hashMap = Maps.newLinkedHashMap();
        hashMap.put("bookName", "姓名");
        hashMap.put("bookAge", "年龄");
        hashMap.put("bookPhone", "手机号码");
        hashMap.put("bookStartTime", "入学时间");
        hashMap.put("bookDep", "所在院系");
        hashMap.put("bookMajor", "所学专业");
        hashMap.put("bookClass", "所在班级");
        hashMap.put("bookEndTime", "毕业时间");
        hashMap.put("bookCity", "现所在城市");
        hashMap.put("bookWorkUnit", "现工作单位");
        hashMap.put("bookWorkTitle", "现职务/职称");
        hashMap.put("bookEmail", "邮箱");
        hashMap.put("bookWeixin", "微信号");
        hashMap.put("bookSex", "性别");
        ExcelUtils.pojo2Excel(newArrayList, out, hashMap, "同学录收集");
    }

}
