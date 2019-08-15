package com.wwy.mapper;

import com.wwy.pojo.Attendance;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface AttendanceMapper {
    //查找本月份的所有出勤信息,使用联合查询
    @Select("SELECT time,days,ename,eid from attendance a left join employees e on a.eid=e.id " +
            "where month(str_to_date(time,'%Y-%m'))=month(now())")
    List<Attendance> selAllAttendance();

    //更改出勤信息
    @Update("update attendance set days=#{days} where eid=#{eid}")
    int updDaysByEid(int eid,int days);
}
