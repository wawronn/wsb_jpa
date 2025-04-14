package com.jpacourse.dao;

import static org.junit.jupiter.api.Assertions.*;
import com.jpacourse.persistance.dao.impl.PatientDaoImpl;
import com.jpacourse.persistance.entity.DoctorEntity;
import com.jpacourse.persistance.entity.PatientEntity;
import com.jpacourse.persistance.entity.VisitEntity;
import com.jpacourse.persistance.enums.Specialization;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@SpringBootTest
@Transactional
public class PatientDaoMergeTest {

    @Autowired
    private PatientDaoImpl patientDao;

    @Autowired
    private EntityManager entityManager;

    @Test
    void shouldAddVisitSuccessfully() {
        PatientEntity patient = new PatientEntity();
        patient.setFirstName("John");
        patient.setLastName("Doe");
        patient.setPatientNumber("P123");
        entityManager.persist(patient);

        DoctorEntity doctor = new DoctorEntity();
        doctor.setFirstName("Dr");
        doctor.setLastName("Smith");

        doctor.setSpecialization(Specialization.SURGEON);
        entityManager.persist(doctor);

        LocalDateTime time = LocalDateTime.now();
        String description = "Routine Checkup";

        patientDao.addVisit(patient.getId(), doctor.getId(), time, description);

        PatientEntity retrievedPatient = entityManager.find(PatientEntity.class, patient.getId());
        assertNotNull(retrievedPatient);
        assertEquals(1, retrievedPatient.getVisits().size());

        VisitEntity visit = retrievedPatient.getVisits().iterator().next();
        assertEquals(description, visit.getDescription());
        assertEquals(time, visit.getTime());

        DoctorEntity retrievedDoctor = entityManager.find(DoctorEntity.class, doctor.getId());
        assertNotNull(retrievedDoctor);
        assertEquals(1, retrievedDoctor.getVisits().size());
    }

    @Test
    void shouldThrowExceptionWhenPatientNotFound() {

        long nonExistentPatientId = 999L;
        long doctorId = 1L;
        LocalDateTime time = LocalDateTime.now();
        String description = "Checkup";

        assertThrows(IllegalArgumentException.class, () ->
                patientDao.addVisit(nonExistentPatientId, doctorId, time, description)
        );
    }

    @Test
    void shouldThrowExceptionWhenDoctorNotFound() {

        PatientEntity patient = new PatientEntity();
        patient.setFirstName("Jane");
        patient.setLastName("Doe");
        patient.setPatientNumber("P124");
        entityManager.persist(patient);

        long nonExistentDoctorId = 999L;

        assertThrows(IllegalArgumentException.class, () ->
                patientDao.addVisit(patient.getId(), nonExistentDoctorId, LocalDateTime.now(), "Checkup")
        );
    }
}
