package com.jpacourse.persistance.dao;

import com.jpacourse.persistance.entity.PatientEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class patientQueryTest {

    @Autowired
    private PatientDao patientDao;
    
    @Test
    public void shouldFindLastName() {
        String lastName = "Kowalski";
        List<PatientEntity> patients = patientDao.getPatientsByLastName(lastName);
        for (PatientEntity patient : patients) {
            assertEquals(lastName, patient.getLastName(), "Nazwisko pacjenta nie zgadza się!");
        }
    }
}
