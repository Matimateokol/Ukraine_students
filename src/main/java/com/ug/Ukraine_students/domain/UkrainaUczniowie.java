package com.ug.Ukraine_students.domain;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;

@Entity
@Getter
@Setter
@Table(name = "Ukraina_Uczniowie", schema = "dbo")
@NamedStoredProcedureQuery(
        name="pokaz_szkoly_all",
        procedureName="pokaz_szkoly_all",
        resultClasses = { UkrainaUczniowie.class },
        parameters={
                @StoredProcedureParameter(name="idTerytWojewodztwo", type=Integer.class, mode=ParameterMode.IN),
                @StoredProcedureParameter(name="idTerytPowiat", type=Integer.class, mode=ParameterMode.IN),
                @StoredProcedureParameter(name="idPublicznosc", type=Integer.class, mode=ParameterMode.IN),
                @StoredProcedureParameter(name="idTypPodmiotu", type=Integer.class, mode=ParameterMode.IN)
        }
)
public class UkrainaUczniowie implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "idTerytWojewodztwo")
    private int idTerytWojewodztwo;
    @Column(name = "Wojewodztwo")
    private String wojewodztwo;
    @Column(name = "idTerytPowiat")
    private int idTerytPowiat;
    @Column(name = "Powiat")
    private String powiat;
    @Column(name = "idPublicznosc")
    private int idPublicznosc;
    @Column(name = "Publicznosc")
    private String publicznosc;
    @Column(name = "idTypPodmiotu")
    private int idTypPodmiotu;
    @Column(name = "TypPodmiotu")
    private String typPodmiotu;
    @Column(name = "LiczbaSzkol")
    private int liczbaSzkol;
    @Column(name = "Ukraincy")
    private int ukraincy;
    @Column(name = "NaukaPolskiego")
    private int naukaPolskiego;

}
