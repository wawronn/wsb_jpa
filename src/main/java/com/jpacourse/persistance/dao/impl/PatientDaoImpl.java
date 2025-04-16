package com.jpacourse.persistance.dao.impl;

import com.jpacourse.persistance.dao.PatientDao;
import com.jpacourse.persistance.entity.DoctorEntity;
import com.jpacourse.persistance.entity.PatientEntity;
import com.jpacourse.persistance.entity.VisitEntity;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public class PatientDaoImpl extends AbstractDao<PatientEntity, Long> implements PatientDao {
    @Override
    public void addVisit(long patientId, long doctorId, LocalDateTime time, String description) throws IllegalArgumentException {

        PatientEntity patient = findOne(patientId);
        if (patient == null) {
            throw new IllegalArgumentException("Patient not found");
        }

        DoctorEntity doctor =  entityManager.find(DoctorEntity.class, doctorId);
        if (doctor == null) {
            throw new IllegalArgumentException("Doctor not found");
        }

        VisitEntity visit = new VisitEntity();
        visit.setTime(time);
        visit.setDescription(description);

        patient.addVisit(visit);
        doctor.addVisit(visit);

        entityManager.merge(patient);
    }

    @Override
    public List<PatientEntity> getPatientsByLastName(String lastName) {
        return entityManager.createQuery(" select patient from PatientEntity patient " +
                " where patient.lastName = :param1 ", PatientEntity.class)
                .setParameter("param1", lastName).getResultList();
    }
}
