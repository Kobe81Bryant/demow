package com.example.demow.mapper;

import com.example.demow.entity.TbMessage;
import com.example.demow.entity.TbMessageExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbMessageMapper {
    /**
     *
     * @mbggenerated 2019-04-16
     */
    int countByExample(TbMessageExample example);

    /**
     *
     * @mbggenerated 2019-04-16
     */
    int deleteByExample(TbMessageExample example);

    /**
     *
     * @mbggenerated 2019-04-16
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbggenerated 2019-04-16
     */
    int insert(TbMessage record);

    /**
     *
     * @mbggenerated 2019-04-16
     */
    int insertSelective(TbMessage record);

    /**
     *
     * @mbggenerated 2019-04-16
     */
    List<TbMessage> selectByExample(TbMessageExample example);

    /**
     *
     * @mbggenerated 2019-04-16
     */
    TbMessage selectByPrimaryKey(Integer id);

    /**
     *
     * @mbggenerated 2019-04-16
     */
    int updateByExampleSelective(@Param("record") TbMessage record, @Param("example") TbMessageExample example);

    /**
     *
     * @mbggenerated 2019-04-16
     */
    int updateByExample(@Param("record") TbMessage record, @Param("example") TbMessageExample example);

    /**
     *
     * @mbggenerated 2019-04-16
     */
    int updateByPrimaryKeySelective(TbMessage record);

    /**
     *
     * @mbggenerated 2019-04-16
     */
    int updateByPrimaryKey(TbMessage record);
}