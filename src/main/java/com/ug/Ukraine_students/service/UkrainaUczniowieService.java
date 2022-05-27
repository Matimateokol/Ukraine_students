package com.ug.Ukraine_students.service;

import com.ug.Ukraine_students.domain.UkrainaUczniowie;
import com.ug.Ukraine_students.repository.UkrainaUczniowieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UkrainaUczniowieService implements IUkrainaUczniowieService {

    @Autowired
    UkrainaUczniowieRepository ukrainaUczniowieRepository;

    @Override
    public UkrainaUczniowie getStudentById(long id) {
        return ukrainaUczniowieRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Not found!"));
    }

    @Override
    public List<UkrainaUczniowie> getAllStudents() {
        return ukrainaUczniowieRepository.findAll();
    }

    @Override
    public List<UkrainaUczniowie> getAllFromPowiat(int idPowiat) {
        return ukrainaUczniowieRepository.findAllByPowiat(idPowiat);
    }

    @Override
    public List<UkrainaUczniowie> getAllByParams(Integer idTerytWojewodztwo, Integer idTerytPowiat, Integer idPublicznosc, Integer idTypPodmiotu) {
        Integer wojewodztwo = idTerytWojewodztwo != null ? idTerytWojewodztwo : 0;
        Integer powiat = idTerytPowiat != null ? idTerytPowiat : 0;
        Integer publicznosc = idPublicznosc != null ? idPublicznosc : 0;
        Integer podmiot = idTypPodmiotu != null ? idTypPodmiotu : 0;
        return ukrainaUczniowieRepository.findAllByParams(wojewodztwo, powiat, publicznosc, podmiot);
    }

    @Override
    public List<UkrainaUczniowie> getListedByWojewodztwo() {
        return ukrainaUczniowieRepository.findListedByWojewodztwo();
    }
    @Override
    public List<UkrainaUczniowie> getPowiatByWojewodztwo(int idTerytWojewodztwo) {
        return ukrainaUczniowieRepository.findPowiatByWojewodztwo(idTerytWojewodztwo);
    }
    @Override
    public List<UkrainaUczniowie> getListedByPublicznosc() {
        return ukrainaUczniowieRepository.findListedByPublicznosc();
    }
    @Override
    public List<UkrainaUczniowie> getAllByTyp() {
        return ukrainaUczniowieRepository.findAllByTyp();
    }

    @Override
    public List<UkrainaUczniowie> getAllStudentsPaginated(Integer pageNo, Integer pageSize) {
        Pageable paging = PageRequest.of(pageNo, pageSize);

        Page<UkrainaUczniowie> pagedResult = ukrainaUczniowieRepository.findAll(paging);

        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<UkrainaUczniowie>();
        }
    }
}
