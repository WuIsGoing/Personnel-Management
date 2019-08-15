package com.wwy.service;

import com.wwy.pojo.Absence;
import com.wwy.pojo.Employees;
import com.wwy.pojo.Salary;

import java.util.List;


public interface StaffService {
    //请假申请
    int absenceRequest(Employees employee, Absence absence);

    //查看自己的请假信息
    Absence showMyAbsence(Employees employee);

    //查看自己的工资记录
    List<Salary> showMysalary(int eid);

}
