package com.jpacourse.rest;


import com.jpacourse.dto.PatientTO;
import com.jpacourse.dto.PatientVisitTO;
import com.jpacourse.rest.exception.EntityNotFoundException;
import com.jpacourse.service.PatientService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("/patient/{id}")
    public PatientTO findById(@PathVariable Long id) {
        final PatientTO patient = patientService.findById(id);
        if(patient != null) {
            return patient;
        } else {
            throw new EntityNotFoundException(id);
        }
    }

    @GetMapping("/patient/{id}/completed-visits")
    public List<PatientVisitTO> findPatientsVisitById(@PathVariable Long id) {
        final List<PatientVisitTO> patientVisits = patientService.findPatientsVisitById(id);
        if (!patientVisits.isEmpty()) {
            return patientVisits;
        } else {
            throw new EntityNotFoundException(id);
        }
    }

}
