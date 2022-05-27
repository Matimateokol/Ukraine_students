package com.ug.Ukraine_students.controller;

import com.ug.Ukraine_students.domain.UkrainaUczniowie;
import com.ug.Ukraine_students.service.UkrainaUczniowieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    UkrainaUczniowieService ukrainaUczniowieService;

    //TODO: change it so that it should use data from /uczniowie/params endpoint:
    @GetMapping("/home")
    public String getHome(Model model) {
        List<UkrainaUczniowie> students = ukrainaUczniowieService
                .getAllByParams(0,0,0,0);
        model.addAttribute("students", students);
        List<UkrainaUczniowie> wojewodztwa = ukrainaUczniowieService
                .getListedByWojewodztwo();
        model.addAttribute("wojewodztwa", wojewodztwa);
        List<UkrainaUczniowie> publicznosci = ukrainaUczniowieService
                .getListedByPublicznosc();
        model.addAttribute("publicznosci", publicznosci);
        List<UkrainaUczniowie> typy = ukrainaUczniowieService
                .getAllByTyp();
        model.addAttribute("typy", typy);
        List<UkrainaUczniowie> powiaty = ukrainaUczniowieService
                .getPowiatByWojewodztwo(0);
        model.addAttribute("powiaty", powiaty);
        return "home";
    }

    @GetMapping("/user")
    public String user(){
        return ("home");
    }

    @GetMapping("/welcome")
    public String welcome(){
        return ("welcome");
    }

    @RequestMapping("/")
    public String index(
            @RequestParam(required = false) Integer wojewodztwo,
            @RequestParam(required = false) Integer powiat,
            @RequestParam(required = false) Integer publicznosc,
            @RequestParam(required = false) Integer podmiot,
            Model model) {
        List<UkrainaUczniowie> studentsByParams = ukrainaUczniowieService.getAllByParams(wojewodztwo, powiat, publicznosc, podmiot);
        model.addAttribute("students", studentsByParams);
        List<UkrainaUczniowie> wojewodztwa = ukrainaUczniowieService
                .getListedByWojewodztwo();
        model.addAttribute("wojewodztwa", wojewodztwa);
        List<UkrainaUczniowie> publicznosci = ukrainaUczniowieService
                .getListedByPublicznosc();
        model.addAttribute("publicznosci", publicznosci);
        List<UkrainaUczniowie> typy = ukrainaUczniowieService
                .getAllByTyp();
        model.addAttribute("typy", typy);
        List<UkrainaUczniowie> powiaty = ukrainaUczniowieService
                .getPowiatByWojewodztwo(0);
        model.addAttribute("powiaty", powiaty);
        return "home";
    }

}
