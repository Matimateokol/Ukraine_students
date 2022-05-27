package com.ug.Ukraine_students.repository;

import com.ug.Ukraine_students.domain.UkrainaUczniowie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UkrainaUczniowieRepository extends JpaRepository<UkrainaUczniowie, Long> {
    Optional<UkrainaUczniowie> findById(Long id);
    List<UkrainaUczniowie> findAll();

    @Query(value = "exec pokaz_powiat ?;", nativeQuery = true)
    List<UkrainaUczniowie> findAllByPowiat(int idTerytPowiat);

    @Query(value = "exec pokaz_szkoly_all ?, ?, ?, ?;", nativeQuery = true)
    List<UkrainaUczniowie> findAllByParams(Integer idTerytWojewodztwo, Integer idTerytPowiat, Integer idPublicznosc, Integer idTypPodmiotu);

    @Procedure(name = "pokaz_szkoly_all")
    List<UkrainaUczniowie> findAllPaginated(
            @Param("idTerytWojewodztwo") Integer idTerytWojewodztwo,
            @Param("idTerytPowiat") Integer idTerytPowiat,
            @Param("idPublicznosc") Integer idPublicznosc,
            @Param("idTypPodmiotu") Integer idTypPodmiotu
    );

    @Query(value = "exec lista_wojewodztwo ;", nativeQuery = true)
    List<UkrainaUczniowie> findListedByWojewodztwo();
    @Query(value = "exec pokaz_wojewodztwo ?;", nativeQuery = true)
    List<UkrainaUczniowie> findPowiatByWojewodztwo(int idTerytWojewodztwo);
    @Query(value = "exec lista_publicznosc ;", nativeQuery = true)
    List<UkrainaUczniowie> findListedByPublicznosc();
    @Query(value = "exec lista_typ ;", nativeQuery = true)
    List<UkrainaUczniowie> findAllByTyp();

}
