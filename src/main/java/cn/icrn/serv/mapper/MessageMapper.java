package cn.icrn.serv.mapper;

import cn.icrn.serv.model.Message;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Author: yankang
 * Date: 2017/8/17
 */
@Mapper
public interface MessageMapper {

    @Select("select * from message where id = #{id}")
    Message messageMapper(@Param("id")Integer id);

}
