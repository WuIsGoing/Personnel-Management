package com.wwy.service.impl;

import com.wwy.mapper.AbsenceMapper;
import com.wwy.mapper.AttendanceMapper;
import com.wwy.mapper.DepartmentMapper;
import com.wwy.mapper.SalaryMapper;
import com.wwy.pojo.Absence;
import com.wwy.pojo.Attendance;
import com.wwy.pojo.Department;
import com.wwy.pojo.Salary;
import com.wwy.service.ManagerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ManagerServiceImpl implements ManagerService {
    @Resource
    private AbsenceMapper absenceMapper;
    @Resource
    private SalaryMapper salaryMapper;
    @Resource
    private AttendanceMapper attendanceMapper;
    @Resource
    private DepartmentMapper departmentMapper;

    @Override
    public int checkAbance( Absence absence) {
        return absenceMapper.updReAIsP(absence);
    }

    @Override
    public int deleteAbance(int eid) {
        return absenceMapper.delAbsence(eid);
    }

    @Override
    public List<Salary> showAllSalary() {
        return salaryMapper.selSalaryByMonth();
    }

    @Override
    public int delSalary(int eid, String time) {
        return salaryMapper.delByEidAndTime(eid,time);
    }

    @Override
    public int changeSalary(float salary, int eid) {
        return salaryMapper.updSalaryByEid(salary,eid);
    }

    @Override
    public int addSalary(Salary salary) {
        return salaryMapper.insSalary(salary);
    }

    @Override
    public List<Attendance> showAllAttendance() {
        return attendanceMapper.selAllAttendance();
    }

    @Override
    public int changeAttendance(int eid, int days) {
        return attendanceMapper.updDaysByEid(eid, days);
    }

    @Override
    public List<Department> showDepartment() {
        Map<String,Object> map=new HashMap<>();
        map.put("pid",0);
        return departmentMapper.selAllDepartment(map);
    }

    @Override
    public List<Department> showDepartmentByPid(int id) {
        List<Department> departments = departmentMapper.selDepartmentById(id);
        return departments;
    }

    @Override
    public int addDepartment(Department department) {
        return departmentMapper.insDeapartment(department);
    }

    @Override
    public int changeDepartmentName(int id, String newName) {
        return departmentMapper.updDepartmentName(id, newName);
    }

    @Override
    public int removeDepartment(int id) {
        return departmentMapper.delById(id);
    }

    @Override
    public List<Absence> showAllAbsence() {
        return absenceMapper.selAllAbsence();
    }
}
