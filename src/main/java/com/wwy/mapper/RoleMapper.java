package com.wwy.mapper;

import com.wwy.pojo.Employees;
import com.wwy.pojo.Role;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

public interface RoleMapper {
    @Results(value = {
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "roleName",property = "roleName"),
            @Result(column = "{id=id}",property = "menus",many = @Many(select="com.wwy.mapper.MenuMapper.selByRole"))
        }
    )
    @Select("select * from role where id in(select rid from employees where ename=#{ename})")
    Role selByRid(Employees employees);
}
