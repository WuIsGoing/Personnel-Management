package com.wwy.service;

import com.wwy.pojo.Employees;

import java.util.List;

public interface EmployeesService {
    //登录
    Employees login(Employees employees);
    //赋予角色
    Employees putRole(Employees employee);
    //修改密码
    int passwordChange(Employees employee, String originalPassword, String newPassword);

    //显示所有员工
    List<Employees> showAllEmployee();
    //添加员工
    int addEmployee(Employees employees);

    //删除员工
    int deleteEmployee(int id);
}
