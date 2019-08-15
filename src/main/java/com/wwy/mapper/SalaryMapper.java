package com.wwy.mapper;

import com.wwy.pojo.Salary;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface SalaryMapper {
    @Select("select time,salary from salary where eid=#{eid}")//员工根据eid查到自己的工资
    List<Salary> selSalaryByEid(int eid);

    //查找当月的员工工资信息，采用联合查询
    @Select("select time,salary,eid,ename from salary s left join employees e on s.eid=e.id where MONTH(time)=Month(now())")
    List<Salary> selSalaryByMonth();

    //管理员通过eid和time进行删除工资行
    @Delete("delete from salary where eid=#{eid} and time=#{time}")
    int delByEidAndTime(int eid,String time);

    //管理员修改员工工资
    @Update("update salary set salary=#{salary} where eid=#{eid}")
    int updSalaryByEid(float salary,int eid);

    //管理员添加一行工资,采用insert+select语句
    @Insert("insert into salary select Now(),#{salary},id from employees where ename=#{ename}")
    int insSalary(Salary salary);
}
