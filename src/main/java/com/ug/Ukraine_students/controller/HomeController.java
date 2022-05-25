package com.ug.Ukraine_students.controller;

import com.ug.Ukraine_students.domain.UkrainaUczniowie;
import com.ug.Ukraine_students.service.UkrainaUczniowieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    UkrainaUczniowieService ukrainaUczniowieService;

    //TODO: change it so that it should use data from /uczniowie/params endpoint:
    @GetMapping("/home")
    public String getHome(Model model) {
        List<UkrainaUczniowie> students = ukrainaUczniowieService.getAllStudents();
        model.addAttribute("students", students);
        return "home";
    }
}
