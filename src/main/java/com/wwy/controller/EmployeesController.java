package com.wwy.controller;

import com.wwy.pojo.Employees;
import com.wwy.pojo.Menu;
import com.wwy.service.EmployeesService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class EmployeesController {
    @Resource
    private EmployeesService employeesServiceImpl;

    @RequestMapping("/login")//登录
    public String login(Employees employees, HttpSession session){
        Employees employee = employeesServiceImpl.login(employees);
        if(employee!=null){//登录成功
            //赋予角色，并设置到session中
            session.setAttribute("employee",employeesServiceImpl.putRole(employee));
            return "redirect:/main";
        }else {//登录失败
            return "index";
        }
    }
    @RequestMapping("/main")
    public String toMain(){//主页跳转
        return "main";
    }
    @RequestMapping("/showMenu")//RBAC思想，根据角色获取菜单
    @ResponseBody
    public List<Menu> getMenu(HttpSession session){
        //获取用户
        Employees employee=(Employees)session.getAttribute("employee");
        //判断是否登录
        if(employee==null){//没有登录而直接访问main，需返回Null并跳转到index
            return null;
        }else{
            return employee.getRole().getMenus();
        }
    }
    @RequestMapping("/pwChangePage")//修改密码页面,没有数据返回，需要多附加一个跳转
    public String pwdChangePage(){
        return "redirect:/static/html/pwChangePage.html";
    }

    @RequestMapping("/pwChange")//修改密码
    @ResponseBody
    public int pwdChange(HttpSession session, HttpServletRequest request){
        int result= employeesServiceImpl.passwordChange((Employees)session.getAttribute("employee"),
                (String)request.getParameter("originalPassword"),
                (String)request.getParameter("newPassword"));
        return result;
    }

    @RequestMapping("/employeeManage")
    public String employeeManage(Model model){//员工管理，返回所有员工信息
        List<Employees> employees = employeesServiceImpl.showAllEmployee();
        model.addAttribute("employees",employees);
        return "employeeManage";
    }

    @RequestMapping("/deleteEmployee")//删除员工
    public String deleteEmployee(int id){
        employeesServiceImpl.deleteEmployee(id);
        return "redirect:/employeeManage";
    }
    @RequestMapping("/addEmployee")
    @ResponseBody//添加员工
    public int addEmployee(@RequestBody Employees employees){
        return  employeesServiceImpl.addEmployee(employees);
    }

}
