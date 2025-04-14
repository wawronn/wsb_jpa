package com.jpacourse.service;

import static org.junit.jupiter.api.Assertions.*;

import com.jpacourse.dto.PatientTO;
import com.jpacourse.persistance.dao.PatientDao;
import com.jpacourse.persistance.entity.PatientEntity;
import com.jpacourse.persistance.entity.VisitEntity;
import com.jpacourse.testData.PatientTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@SpringBootTest
public class PatientServiceTest {
    @Autowired
    private PatientService patientService;

    @Autowired
    private PatientDao patientDao;

    @Transactional
    @Test
    public void testDeletePatient() {

        PatientEntity patient = PatientTest.addPatient();
        assertTrue(patient.getVisits().isEmpty());

        VisitEntity visit1 = new VisitEntity();
        visit1.setTime(LocalDateTime.now().plusDays(11));
        VisitEntity visit2 = new VisitEntity();
        visit2.setTime(LocalDateTime.now());

        patient.getVisits().add(visit1);
        patient.getVisits().add(visit2);

        patientDao.save(patient);
        patientService.deleteById(patient.getId());

        assertNull(patientDao.findOne(patient.getId()));
        assertTrue(patient.getVisits().isEmpty());
    }

    @Test
    public void testFindPatientById() {

        PatientEntity patient = PatientTest.addPatient();
        patientDao.save(patient);

        PatientTO patientTO = patientService.findById(patient.getId());

        assertEquals(patient.getFirstName(), patientTO.getFirstName());
        assertEquals(patient.getLastName(), patientTO.getLastName());
        assertEquals(patient.getEmail(), patientTO.getEmail());
        assertNotNull(patientTO.getPatientNumber());
    }
}
