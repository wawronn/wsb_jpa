package com.jpacourse.persistance.dao;

import com.jpacourse.persistance.entity.PatientEntity;
import com.jpacourse.persistance.entity.VisitEntity;
import jakarta.transaction.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface PatientDao extends Dao<PatientEntity, Long> {

    @Transactional
    void addVisit(long patientId, long doctorId, LocalDateTime time, String description) throws IllegalArgumentException;

    List<PatientEntity> getPatientsByLastName(String lastName);
    List<VisitEntity> getVisitsByPatientId(Long patientId);
    List<PatientEntity> getPatientsByVisitCount(Integer numberOfVisits);
    List<PatientEntity> getPatientsBornBetween(LocalDate fromDate, LocalDate toDate);
}
