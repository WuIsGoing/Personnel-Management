package com.wwy.mapper;

import com.wwy.pojo.Absence;
import com.wwy.pojo.Employees;
import org.apache.ibatis.annotations.*;

import java.util.List;


public interface AbsenceMapper {
    //请假，添加请假记录：添加请假原因，验证请假记录唯一性
    @Insert("insert into absence (eid,startTime,endTime,reason)  " +
            "select #{employee.id},#{absence.startTime},#{absence.endTime},#{absence.reason} " +
            "where not exists(select eid from absence where eid=#{employee.id}) limit 1")
    int insAbsence(Employees employee, Absence absence);

    //显示自己的请假表,通过员工信息的id来查询
    @Select("select * from absence where eid=#{id}")
    Absence selByEId(Employees employee);

    //显示所有的请假记录
    @Select("select * from absence")
    List<Absence> selAllAbsence();

    //审核结果，修改表中的reply和isPermission
    @Update("update absence set isPermission=#{isPermission},reply=#{reply} where eid=#{eid}")
    int updReAIsP(Absence absence);

    //删除请假记录
    @Delete("delete from absence where eid=#{eid}")
    int delAbsence(int eid);
}
