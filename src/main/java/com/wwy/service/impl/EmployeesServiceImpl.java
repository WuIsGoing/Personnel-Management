package com.wwy.service.impl;

import com.wwy.mapper.EmployeesMapper;
import com.wwy.mapper.RoleMapper;
import com.wwy.pojo.Employees;
import com.wwy.service.EmployeesService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class EmployeesServiceImpl implements EmployeesService {
    @Resource
    private EmployeesMapper employeesMapper;

    @Resource
    private RoleMapper roleMapper;

    @Override//登录
    public Employees login(Employees employees) {
        return employeesMapper.selByAccount(employees);
    }

    @Override//赋予角色/菜单
    public Employees putRole(Employees employees){
        //能否自动注入？
        employees.setRole(roleMapper.selByRid(employees));
        return employees;
    }

    @Override//修改密码
    public int passwordChange(Employees employee, String originalPassword, String newPassword) {
        return employeesMapper.UpdPassword(employee, originalPassword, newPassword);
    }

    @Override
    public List<Employees> showAllEmployee() {
        return employeesMapper.selAllEmployee();
    }

    @Override
    public int addEmployee(Employees employees) {
        return employeesMapper.insEmployee(employees);
    }

    @Override
    public int deleteEmployee(int id) {
        return employeesMapper.delEmployee(id);
    }
}
