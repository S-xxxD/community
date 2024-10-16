package com.xxxd.community.controller;

import com.xxxd.community.service.AlphaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

@Controller
@RequestMapping("/alpha")
public class AlphaController {

    @Autowired
    private AlphaService alphaService;

    @RequestMapping("/hello")
    @ResponseBody
    public String sayHello(){
        return "Hello Spring Boot.";
    }

    @RequestMapping("/date")
    @ResponseBody
    public String getDate(){
        return alphaService.find();
    }

    @RequestMapping("/http")
    public void http(HttpServletRequest request, HttpServletResponse response) {
        // 获取请求数据
        System.out.println(request.getMethod());
        System.out.println(request.getServletPath());
        Enumeration<String> headers = request.getHeaderNames();
        while (headers.hasMoreElements()) {
            String header = headers.nextElement();
            String value = request.getHeader(header);
            System.out.println(header + ":" + value);
        }
        //返回响应数据
    }

    // GET请求
    // 查询所有学生 当前多少页一页多少个数据
    @RequestMapping(path = "/students", method = RequestMethod.GET)
    @ResponseBody
    public String getStudents(
            // 浏览器如果没有传来参数，设置默认参数
            @RequestParam(name = "current", required = false, defaultValue = "1") int current,
            @RequestParam(name = "limit", required = false, defaultValue = "20") int limit){
        System.out.println(current);
        System.out.println(limit);
        return "some students";
    }

    @RequestMapping(path = "/student/{id}", method = RequestMethod.GET)
    @ResponseBody
    // 将参数放到路径中
    public String getStudent(@PathVariable("id") int id){
        System.out.println(id);
        return "a students";
    }

    // POST请求
    @RequestMapping(path = "/student", method = RequestMethod.POST)
    @ResponseBody
    // 参数和表单一直就能将参数传递
    public String saveStudents(String name, int age){
        System.out.println(name);
        System.out.println(age);
        return "success";
    }

    // 向浏览器响应动态HTMl数据
    @RequestMapping(path = "/teacher", method = RequestMethod.GET)
    // 不加@ResponseBody 默认返回HTML
    public ModelAndView getTeacher(){
        ModelAndView mav = new ModelAndView();
        mav.addObject("name","张三");
        mav.addObject("age", "20");
        // 设置模版路径和名字
        mav.setViewName("/demo/view");
        return mav;
    }

    @RequestMapping(path = "/school", method = RequestMethod.GET)
    public String getSchool(Model model){
        model.addAttribute("name","OUC");
        model.addAttribute("age","100");
        return "/demo/view";
    }

    // 响应sjon数据(异步请求)
    // java对象 —> JSON字符串 —> JS对象
    @RequestMapping(path = "/emp", method = RequestMethod.GET)
    @ResponseBody
    // 通过注解自动将Map转为JSon字符串返回浏览器
    public Map<String, Object> getEmp(){
        Map<String, Object> emp = new HashMap<String, Object>();
        emp.put("name", "张三");
        emp.put("age", "20");
        emp.put("salary", "100");
        return emp;
    }

    @RequestMapping(path = "/emps", method = RequestMethod.GET)
    @ResponseBody
    // 通过注解自动将Map转为JSon字符串返回浏览器
    public List<Map<String, Object>> getEmps(){
        List<Map<String, Object>> list = new ArrayList<>();
        Map<String, Object> emp = new HashMap<>();
        emp.put("name", "张三");
        emp.put("age", "20");
        emp.put("salary", "100");
        list.add(emp);

        emp = new HashMap<>();
        emp.put("name", "李四");
        emp.put("age", "21");
        emp.put("salary", "1000");
        list.add(emp);

        emp = new HashMap<>();
        emp.put("name", "王五");
        emp.put("age", "22");
        emp.put("salary", "10000");
        list.add(emp);
        return list;
    }
}
