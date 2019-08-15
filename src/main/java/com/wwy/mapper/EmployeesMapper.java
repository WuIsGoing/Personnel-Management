package com.wwy.mapper;

import com.wwy.pojo.Employees;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface EmployeesMapper {
    //登录，根据用户名和密码查找用户
    @Select("select * from employees where ename=#{ename} and password=#{password}")
    Employees selByAccount(Employees employees);

    @Results(value = {
            @Result(property = "#{newPassword}",column = "password",jdbcType = JdbcType.VARCHAR)
    })

    @Update("update employees set password=#{newPassword} where ename=#{employees.ename} and password=#{originalPassword}")
    int UpdPassword(@Param("employees") Employees employees, @Param("originalPassword") String originalPassword, @Param("newPassword") String newPassword);

    //返回所有的员工信息
    @Select("select * from employees where rid=2")
    List<Employees> selAllEmployee();

    //添加员工
    @Insert("insert into employees (ename,gender,age,phone,hiredate) values(#{ename},#{gender},#{age},#{phone},now())")
    int insEmployee(Employees employees);

    //删除员工
    @Delete("delete from employees where id=#{id}")
    int delEmployee(int id);
}
