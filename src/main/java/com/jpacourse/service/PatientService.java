package com.jpacourse.service;

import com.jpacourse.dto.PatientTO;
import com.jpacourse.dto.PatientVisitTO;

import java.util.List;

public interface PatientService {
    PatientTO findById(final Long id);
    List<PatientVisitTO> findPatientsVisitById(Long id);
    void deleteById(final Long id);
}