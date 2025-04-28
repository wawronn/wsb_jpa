package com.jpacourse.persistance.dao;

import com.jpacourse.persistance.entity.PatientEntity;
import com.jpacourse.persistance.entity.VisitEntity;
import com.jpacourse.service.PatientService;
import com.jpacourse.service.PatientServiceTest;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class patientQueryTest {

    @Autowired
    private PatientDao patientDao;
    
    @Test
    public void shouldFindByLastName() {

        String lastName = "Kowalski";

        List<PatientEntity> patients = patientDao.getPatientsByLastName(lastName);
        for (PatientEntity patient : patients) {
            assertEquals(lastName, patient.getLastName());
        }
        assertEquals(2, patients.size());
    }

    @Test
    void shouldReturnVisitsForPatientIdDao() {
        // test serwisu w com.jpacourse.service.PatientServiceTest
        Long patientId = 203L;
        List<VisitEntity> visits = patientDao.getVisitsByPatientId(patientId);
        for (VisitEntity visit : visits) {
            assertEquals(patientId, visit.getPatient().getId());
        }
        assertEquals(2, visits.size());
    }

    @Test
    void shouldReturnPatientsByVisitsCount() {
        Integer visitCount = 2;
        List<PatientEntity> patients = patientDao.getPatientsByVisitCount(visitCount);
        assertEquals(1, patients.size());
    }

    @Test
    void shouldReturnPatientsBornBetween() {
        LocalDate fromDate = LocalDate.of(1990, 1, 1);
        LocalDate toDate = LocalDate.of(1991, 2, 28);
        List<PatientEntity> patients = patientDao.getPatientsBornBetween(fromDate, toDate);
        assertEquals(2, patients.size());
    }
}
