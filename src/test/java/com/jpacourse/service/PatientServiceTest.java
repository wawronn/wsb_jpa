package com.jpacourse.service;

import static org.junit.jupiter.api.Assertions.*;

import com.jpacourse.dto.PatientTO;
import com.jpacourse.persistance.dao.DoctorDao;
import com.jpacourse.persistance.dao.PatientDao;
import com.jpacourse.persistance.dao.VisitDao;
import com.jpacourse.persistance.entity.DoctorEntity;
import com.jpacourse.persistance.entity.PatientEntity;
import com.jpacourse.persistance.entity.VisitEntity;
import com.jpacourse.testData.PatientTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
public class PatientServiceTest {
    @Autowired
    private PatientService patientService;

    @Autowired
    private PatientDao patientDao;

    @Autowired
    private DoctorDao doctorDao;

    @Autowired
    private VisitDao visitDao;

    @Test
    public void testDeletePatient() {

        Long patientId = 201L;
        PatientEntity patient = patientDao.findOne(patientId);

        List<Long> visitIds = patient.getVisits().stream().
                map(VisitEntity::getId)
                .toList();

        List<Long> doctorIds = patient.getVisits().stream().
                map(visit -> visit.getDoctor().getId())
                .toList();

        patientService.deleteById(patientId);

        for (Long doctorId : doctorIds) {
            DoctorEntity doctor = doctorDao.findOne(doctorId);
            assertEquals(doctor.getId(), doctorId);
        }

        for (Long visitId : visitIds) {
            assertNull(visitDao.findOne(visitId));
        }

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
