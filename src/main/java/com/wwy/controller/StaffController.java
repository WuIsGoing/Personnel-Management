package com.wwy.controller;

import com.wwy.pojo.Absence;
import com.wwy.pojo.Employees;
import com.wwy.pojo.Salary;
import com.wwy.service.StaffService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class StaffController {
    @Resource
    private StaffService staffServiceImpl;

    @RequestMapping("/absenceRequest")
    @ResponseBody//员工请假申请
    public int absenceRequest(@RequestBody Absence absence,HttpSession session) throws Exception{
        Employees employee = (Employees) session.getAttribute("employee");
        return staffServiceImpl.absenceRequest(employee,absence);
    }

    @RequestMapping("/showAbsence")
    //显示自己的请假信息
    public String showAbsence(HttpSession session, Model model) {
        Absence absence = staffServiceImpl.showMyAbsence((Employees) session.getAttribute("employee"));
        model.addAttribute("absence",absence);
        return "absence";
    }

    @RequestMapping("/mySalary")//显示自己的工资
    public String mySalary(Model model,HttpSession session){
        Employees employee = (Employees) session.getAttribute("employee");
        List<Salary> salaryList = staffServiceImpl.showMysalary(employee.getId());
        model.addAttribute("salaryList",salaryList);
        return "mySalary";
    }

//    @RequestMapping("/deleteAbsence")
//    public String deleteAbsence(){
//
//    }

}
