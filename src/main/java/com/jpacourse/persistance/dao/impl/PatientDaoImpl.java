package com.jpacourse.persistance.dao.impl;

import com.jpacourse.persistance.dao.PatientDao;
import com.jpacourse.persistance.entity.DoctorEntity;
import com.jpacourse.persistance.entity.PatientEntity;
import com.jpacourse.persistance.entity.VisitEntity;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
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

    @Override
    public List<VisitEntity> getVisitsByPatientId(Long patientId) {
        return entityManager.createQuery("select visit from VisitEntity visit " +
                " where visit.patient.id = :param1 ", VisitEntity.class)
                .setParameter("param1", patientId ).getResultList();
    }

    @Override
    public List<PatientEntity> getPatientsByVisitCount(Integer numberOfVisits) {
        return entityManager.createQuery(
                " select patient from PatientEntity patient " +
                    " join patient.visits visit " +
                    " group by patient " +
                    " having count(visit) > :param1 ", PatientEntity.class)
                .setParameter("param1", numberOfVisits)
                .getResultList();
    }

    @Override
    public List<PatientEntity> getPatientsBornBetween(LocalDate fromDate, LocalDate toDate) {
        return entityManager.createQuery(
         "select patient FROM PatientEntity patient " +
            "where patient.dateOfBirth between :fromDate and :toDate", PatientEntity.class)
            .setParameter("fromDate", fromDate)
            .setParameter("toDate", toDate)
            .getResultList();
    }

}
