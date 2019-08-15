package com.wwy.service;

import com.wwy.pojo.Absence;
import com.wwy.pojo.Attendance;
import com.wwy.pojo.Department;
import com.wwy.pojo.Salary;

import java.util.List;

public interface ManagerService {
    //查看所有员工的请假信息
    List<Absence> showAllAbsence();

    //审核请假
    int checkAbance(Absence absence);

    //删除请假申请
    int deleteAbance(int eid);

    //查看本月所有员工工资
    List<Salary> showAllSalary();

    //删除单条工资记录
    int delSalary(int eid, String time);

    //修改工资
    int changeSalary(float salary,int eid);

    //添加一条工资记录
    int addSalary(Salary salary);

    //显示所有出勤信息
    List<Attendance> showAllAttendance();

    //更改出勤天数
    int changeAttendance(int eid,int days);

    //显示部门
    List<Department> showDepartment();

    //显示部门-异步
    List<Department> showDepartmentByPid(int pid);

    //添加部门
    int addDepartment(Department department);

    //更改部门名称
    int changeDepartmentName(int id,String newName);

    //删除部门
    int removeDepartment(int id);
}
