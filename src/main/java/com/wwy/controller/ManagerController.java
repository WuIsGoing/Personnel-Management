package com.wwy.controller;

import com.wwy.pojo.Absence;
import com.wwy.pojo.Attendance;
import com.wwy.pojo.Department;
import com.wwy.pojo.Salary;
import com.wwy.service.ManagerService;
import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class ManagerController {
    @Resource
    private ManagerService managerServiceImpl;

    @RequestMapping("/absenceManage")//管理员管理请假信息，显示所有请假数据
    public String showAllAbsence(Model model){
        List<Absence> absenceList=managerServiceImpl.showAllAbsence();
        model.addAttribute("absenceList",absenceList);
        return "/absenceManage";
    }

    @RequestMapping("/absenceCheck")//管理员审核请假申请
    @ResponseBody
    public int checkAbsence(@RequestBody Absence absence){
        int result = managerServiceImpl.checkAbance(absence);
        return result;
    }

    @RequestMapping("/absenceDelete")//管理员删除请假申请
    @ResponseBody
    public int deleteAbsence(int eid){
        return managerServiceImpl.deleteAbance(eid);
//         "redirect:/absenceManage";
    }

    @RequestMapping("/salaryManage")//显示各个员工的当月工资
    public String salaryManage(Model model){
        List<Salary> salaryList=managerServiceImpl.showAllSalary();
        model.addAttribute("salaryList",salaryList);
        return "salaryManage";
    }
    @RequestMapping("/salaryDelete")//删除一条工资几率
    public String salaryDelete(int eid,String time){
        managerServiceImpl.delSalary(eid, time);
        return "redirect:/salaryManage";
    }
    @RequestMapping("/salaryChange")//修改工资
    public String salaryChange(float salary,int eid){
        managerServiceImpl.changeSalary(salary, eid);
        return "redirect:/salaryManage";
    }

    @RequestMapping("/addSalary")//添加工资信息
    @ResponseBody
    public int addSalary(@RequestBody Salary salary){
        return managerServiceImpl.addSalary(salary);
    }

    @RequestMapping("/attendance")
    public String attendance(Model model){//显示本月所有出勤信息，
        List<Attendance> attendances = managerServiceImpl.showAllAttendance();
        model.addAttribute("attendances",attendances);
        return "attendance";
    }
    @RequestMapping("/changeAttendance")//改变出勤信息
    public String changeAttendance(int eid,int days){
        managerServiceImpl.changeAttendance(eid, days);
        return "redirect:/attendance";
    }

//    @RequestMapping("/department")
//    public String department(Model model){//显示所有部门信息
//        List<Department> departmentList = managerServiceImpl.showDepartment();
//        model.addAttribute("departmentList",departmentList);
//        return "department";
//    }
    @RequestMapping("/department")
        public String toDepartment(Model model){//显示所有部门信息
        return "redirect:/static/html/department.html";
    }
    @RequestMapping("/showDepartment")
    @ResponseBody
    public List<Department> department(Model model, String id){//显示所有部门信息,z-tree
            //异步加载
        if(id==null||id==""){
            id="0";
        }
        List<Department> departments = managerServiceImpl.showDepartmentByPid(Integer.parseInt(id));
        //一次加载
//        List<Department> departments = managerServiceImpl.showDepartment();
//        model.addAttribute("departments",departments);
        return departments;
    }

    @RequestMapping("/addDepartment")//增加部门
    @ResponseBody
    public int addDepartment(@RequestBody Department department){
        return managerServiceImpl.addDepartment(department);
    }

    @RequestMapping("/changeDepartmentName")//更改部门名称
    @ResponseBody
    public int changeDepartmentName(String id,String name){
        return managerServiceImpl.changeDepartmentName(Integer.parseInt(id),name);
    }

    @RequestMapping("/removeDepartment")//删除部门
    @ResponseBody
    public int removeDepartment(String id){
        return managerServiceImpl.removeDepartment(Integer.parseInt(id));
    }
}
