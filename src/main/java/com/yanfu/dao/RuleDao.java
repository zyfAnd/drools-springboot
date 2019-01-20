package com.yanfu.dao;

import com.yanfu.model.Rules;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @Authour Zhang Yanfu
 * @Date 2019/1/20.
 * @Email 1105564280@qq.com
 * @WeChat zyfJava
 */
@Mapper
public interface RuleDao {
    @Select("SELECT * FROM drools_rule where id =#{id}")
    Rules getById(@Param("id") Integer id);
}

