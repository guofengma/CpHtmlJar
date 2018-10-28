package cn.yiyang.book.service.impl;

import cn.yiyang.common.utils.*;
import com.baomidou.mybatisplus.mapper.Wrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import cn.yiyang.book.dao.BookRegisterDao;
import cn.yiyang.book.entity.BookRegisterEntity;
import cn.yiyang.book.service.BookRegisterService;
import org.springframework.transaction.annotation.Transactional;


@Service("bookRegisterService")
@Transactional
public class BookRegisterServiceImpl extends ServiceImpl<BookRegisterDao, BookRegisterEntity> implements BookRegisterService {

    @Autowired
    private BookRegisterDao bookRegisterDao;

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        EntityWrapper ew=new EntityWrapper();
        ew.setEntity(new BookRegisterEntity());
        Page<BookRegisterEntity> page = null;
        String bookName = (String) params.get("bookName");
        if( bookName!= null && bookName != "") {
            ew.where("book_name = {0}", bookName);
        }
        page = this.selectPage(
                new Query<BookRegisterEntity>(params).getPage(),
                ew
        );
        return new PageUtils(page);
    }


    @Override
    public Integer addBooker(BookRegisterEntity bookRegisterEntity) {
        String bookId = IdGen.uuid();
        bookRegisterEntity.setBookId(bookId);
        Integer integer = bookRegisterDao.insert(bookRegisterEntity);
        return integer;
    }

    @Override
    public BookRegisterEntity getBookerByBookPhone(BookRegisterEntity bookRegisterEntity) {
        BookRegisterEntity entity = bookRegisterDao.selectOne(bookRegisterEntity);
        return entity;
    }

    @Override
    public ResultBean getMsgCodeByBookPhone(String bookPhone) {
        String code = IdGen.getCode(4);
        try {
            MessageUtils.sendSms(bookPhone, "您的验证码是: " + code);
            redisUtil.set(bookPhone, code);
            String codeTemp = (String) redisUtil.get(bookPhone);
            return ResultBean.success();
        }catch (Exception  e) {
            e.getMessage();
            return ResultBean.error();
        }
    }

}
