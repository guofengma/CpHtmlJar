package cn.yiyang.book.dao;

import cn.yiyang.book.entity.BookRegisterEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 三峡大学校友会信息登记表
 * 
 * @author wangyiyang
 * @email 1023097289@qq.com
 * @date 2018-10-23 12:55:28
 */
@Mapper
public interface BookRegisterDao extends BaseMapper<BookRegisterEntity> {
	
}
