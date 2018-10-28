package cn.yiyang.book.service;

import cn.yiyang.common.utils.PageUtils;
import cn.yiyang.common.utils.ResultBean;
import com.baomidou.mybatisplus.service.IService;
import cn.yiyang.book.entity.BookRegisterEntity;

import java.util.Map;

/**
 * 三峡大学校友会信息登记表
 *
 * @author wangyiyang
 * @email 1023097289@qq.com
 * @date 2018-10-23 12:55:28
 */
public interface BookRegisterService extends IService<BookRegisterEntity> {

    PageUtils queryPage(Map<String, Object> params);

    Integer addBooker(BookRegisterEntity bookRegisterEntity);

    BookRegisterEntity getBookerByBookPhone(BookRegisterEntity bookRegisterEntity);

    ResultBean getMsgCodeByBookPhone(String bookPhone);

}

