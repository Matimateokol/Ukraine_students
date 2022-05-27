package com.ug.Ukraine_students.controller;

import com.ug.Ukraine_students.domain.UkrainaUczniowie;
import com.ug.Ukraine_students.service.UkrainaUczniowieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
            Pageable pageable,
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

        //copied
//        List<UkrainaUczniowie> students = ukrainaUczniowieService
//                .getAllByParams(wojewodztwo, powiat, publicznosc, podmiot);
//        final int start = (int)pageable.getOffset();
//        final int end = Math.min((start + pageable.getPageSize()), students.size());
//        final Page<UkrainaUczniowie> studentsPaginated = new PageImpl<>(students.subList(start, end), pageable, students.size());
//
//        students = studentsPaginated.getContent();
//
//        model.addAttribute("currentPage", 1);
//        model.addAttribute("totalPages", studentsPaginated.getTotalPages());
//        model.addAttribute("totalItems", studentsPaginated.getTotalElements());
//        model.addAttribute("students", students);

        return "home";
    }

    //TODO: add pagination

    @RequestMapping("/{page}")
    public String index(
            @RequestParam(required = false) Integer wojewodztwo,
            @RequestParam(required = false) Integer powiat,
            @RequestParam(required = false) Integer publicznosc,
            @RequestParam(required = false) Integer podmiot,
            @PathVariable(value = "page") Integer page,
            Pageable pageable,
            Model model) {

        List<UkrainaUczniowie> students = ukrainaUczniowieService
                .getAllByParams(wojewodztwo, powiat, publicznosc, podmiot);
        final int start = (int)pageable.getOffset();
        final int end = Math.min((start + pageable.getPageSize()), students.size());
        final Page<UkrainaUczniowie> studentsPaginated = new PageImpl<>(students.subList(start, end), pageable, students.size());

        students = studentsPaginated.getContent();

        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", studentsPaginated.getTotalPages());
        model.addAttribute("totalItems", studentsPaginated.getTotalElements());
        model.addAttribute("students", students);

        //bugged
//        List<UkrainaUczniowie> wojewodztwa = ukrainaUczniowieService
//                .getListedByWojewodztwo();
//        model.addAttribute("wojewodztwa", wojewodztwa);
//        List<UkrainaUczniowie> publicznosci = ukrainaUczniowieService
//                .getListedByPublicznosc();
//        model.addAttribute("publicznosci", publicznosci);
//        List<UkrainaUczniowie> typy = ukrainaUczniowieService
//                .getAllByTyp();
//        model.addAttribute("typy", typy);
//        List<UkrainaUczniowie> powiaty = ukrainaUczniowieService
//                .getPowiatByWojewodztwo(0);
//        model.addAttribute("powiaty", powiaty);

        return "home";
    }

}
