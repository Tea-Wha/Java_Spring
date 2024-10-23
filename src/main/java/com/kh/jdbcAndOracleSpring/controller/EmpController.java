package com.kh.jdbcAndOracleSpring.controller;

import com.kh.jdbcAndOracleSpring.dao.EmpDAO;
import com.kh.jdbcAndOracleSpring.vo.EmpVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/emp") // http://localhost:8112/emp
public class EmpController {
    private final EmpDAO empDAO;

    public EmpController(EmpDAO empDAO) {
        this.empDAO = empDAO;
    } // 의존성 주입 -> 외부에서 만든 객체를 가져다 쓰는 것
    @GetMapping("/select") // http://localhost:8112/emp/select
    public String selectViewEmp(Model model){
        List<EmpVO> emps = empDAO.empSelect();
        model.addAttribute("employees", emps);
        return "thymeleaf/empSelect";
    }
    @GetMapping("/insert") // 회원가입?
    public String insertViewEmp(Model model){
        model.addAttribute("employees", new EmpVO());
        return "thymeleaf/empInsert";
    } // Controller는 코딩 하면 안됨
    @PostMapping("/insert")
    public String insertDBemp(@ModelAttribute("employees") EmpVO empVO, Model model){
        boolean isSuccess = empDAO.empInsert(empVO);
        model.addAttribute("isSuccess", isSuccess);
        return "thymeleaf/empResult";
    }
    @GetMapping("/delete")
    public String deleteViewEmp(Model model){
        model.addAttribute("employees", new EmpVO());
        return "thymeleaf/empDelete";
    }
    @PostMapping("/delete")
    public String deleteDBemp(@ModelAttribute("employees") EmpVO empVO, Model model){
        boolean isSuccess = empDAO.empDelete(empVO);
        model.addAttribute("isSuccess", isSuccess);
        return "thymeleaf/empDelResult";
    }
}
