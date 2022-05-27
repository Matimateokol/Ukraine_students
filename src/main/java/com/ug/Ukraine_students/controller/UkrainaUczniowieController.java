package com.ug.Ukraine_students.controller;

import com.ug.Ukraine_students.domain.UkrainaUczniowie;
import com.ug.Ukraine_students.service.UkrainaUczniowieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UkrainaUczniowieController {

    @Autowired
    UkrainaUczniowieService ukrainaUczniowieService;

    @GetMapping("/uczniowie")
    public List<UkrainaUczniowie> getStudents(){
        return ukrainaUczniowieService.getAllStudents();
    }

    @GetMapping("/uczniowie/{id}")
    public UkrainaUczniowie getStudent(@PathVariable("id") Long id) {
        return ukrainaUczniowieService.getStudentById(id);
    }

    @GetMapping("/powiat/{id}")
    public List<UkrainaUczniowie> getStudentsByPowiat(@PathVariable("id") int id) {
        return ukrainaUczniowieService.getAllFromPowiat(id);
    }

    @GetMapping("/uczniowie/params")
    public List<UkrainaUczniowie> getStudentsByParams(
            @RequestParam(required = false) Integer wojewodztwo,
            @RequestParam(required = false) Integer powiat,
            @RequestParam(required = false) Integer publicznosc,
            @RequestParam(required = false) Integer podmiot) {
        return ukrainaUczniowieService.getAllByParams(wojewodztwo, powiat, publicznosc, podmiot);
    }

    @GetMapping("/lista/wojewodztwo")
    public List<UkrainaUczniowie> getListedByWojewodztwo() {
        return ukrainaUczniowieService.getListedByWojewodztwo();
    }

    @GetMapping("/lista/publicznosc")
    public List<UkrainaUczniowie> getListedByPublicznosc() {
        return ukrainaUczniowieService.getListedByPublicznosc();
    }

    @GetMapping("/lista/typ")
    public List<UkrainaUczniowie> getAllByTyp() {
        return ukrainaUczniowieService.getAllByTyp();
    }

    @GetMapping("/lista")
    public List<UkrainaUczniowie> getPowiatByWojewodztwo(
            @RequestParam(required = false) Integer wojewodztwo) {
        return ukrainaUczniowieService.getPowiatByWojewodztwo(wojewodztwo);
    }

    //Testing pagination: it works
    @GetMapping("/uczniowie/pages")
    public ResponseEntity<List<UkrainaUczniowie>> getStudentsPaginated(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize) {
        List<UkrainaUczniowie> list = ukrainaUczniowieService
                .getAllStudentsPaginated(pageNo, pageSize);

        return new ResponseEntity<List<UkrainaUczniowie>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    //it works now
    @GetMapping("/uczniowie2/pages")
    public ResponseEntity<Page> getStudentsPaginatedFromProcedure(
            @RequestParam(required = false) Integer wojewodztwo,
            @RequestParam(required = false) Integer powiat,
            @RequestParam(required = false) Integer publicznosc,
            @RequestParam(required = false) Integer podmiot,
            Pageable pageable
    ) {
        List<UkrainaUczniowie> students = ukrainaUczniowieService
                .getAllByParams(wojewodztwo, powiat, publicznosc, podmiot);
        final int start = (int)pageable.getOffset();
        final int end = Math.min((start + pageable.getPageSize()), students.size());
        final Page<UkrainaUczniowie> page = new PageImpl<>(students.subList(start, end), pageable, students.size());

        return new ResponseEntity<>(page, HttpStatus.OK);
    }
}
