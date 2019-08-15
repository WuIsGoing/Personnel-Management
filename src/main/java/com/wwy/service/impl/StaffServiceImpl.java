package com.wwy.service.impl;

import com.wwy.mapper.AbsenceMapper;
import com.wwy.mapper.SalaryMapper;
import com.wwy.pojo.Absence;
import com.wwy.pojo.Employees;
import com.wwy.pojo.Salary;
import com.wwy.service.StaffService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StaffServiceImpl implements StaffService {
    @Resource
    private AbsenceMapper absenceMapper;
    @Resource
    private SalaryMapper salaryMapper;

    @Override
    public int absenceRequest(Employees employee, Absence absence) {
       return absenceMapper.insAbsence(employee,absence);
    }

    @Override
    public Absence showMyAbsence(Employees employee) {
       return absenceMapper.selByEId(employee);
    }

    @Override
    public List<Salary> showMysalary(int eid) {
        return salaryMapper.selSalaryByEid(eid);
    }


}
