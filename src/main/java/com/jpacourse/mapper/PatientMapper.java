package com.jpacourse.mapper;

import com.jpacourse.dto.PatientTO;

import java.util.List;
import java.util.stream.Collectors;

public class PatientMapper {

    public static PatientTO mapToTO(PatientEntity entity) {
        if (entity == null) return null;

        PatientTO to = new PatientTO();
        to.setId(entity.getId());
        to.setFirstName(entity.getFirstName());
        to.setLastName(entity.getLastName());
        to.setTelephoneNumber(entity.getTelephoneNumber());
        to.setEmail(entity.getEmail());
        to.setPatientNumber(entity.getPatientNumber());
        to.setDateOfBirth(entity.getDateOfBirth());
        to.setWeight(entity.getWeight());

        // mapowanie wizyt do VisitShortTO
        if (entity.getVisits() != null) {
            List<VisitShortTO> visitTOS = entity.getVisits().stream().map(visit -> {
                VisitShortTO visitTO = new VisitShortTO();
                visitTO.setTime(visit.getTime());
                visitTO.setDoctorFirstName(visit.getDoctor().getFirstName());
                visitTO.setDoctorLastName(visit.getDoctor().getLastName());
                visitTO.setTreatmentTypes(
                        visit.getTreatments().stream()
                                .map(MedicalTreatmentEntity::getType)
                                .collect(Collectors.toList())
                );
                return visitTO;
            }).collect(Collectors.toList());

            to.setVisits(visitTOS);
        }

        return to;
    }
}

