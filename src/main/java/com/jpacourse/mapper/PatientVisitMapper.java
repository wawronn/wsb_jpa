package com.jpacourse.mapper;

import com.jpacourse.dto.PatientVisitTO;
import com.jpacourse.persistance.entity.MedicalTreatmentEntity;
import com.jpacourse.persistance.entity.VisitEntity;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public final class PatientVisitMapper {

    public static PatientVisitTO mapToTO(final VisitEntity visitEntity) {
        if (visitEntity == null) {
            return null;
        }

        final PatientVisitTO patientVisitTO = new PatientVisitTO();
        patientVisitTO.setTime(visitEntity.getTime());
        patientVisitTO.setDoctorFirstName(visitEntity.getDoctor().getFirstName());
        patientVisitTO.setDoctorLastName(visitEntity.getDoctor().getLastName());
        patientVisitTO.setTreatmentTypes(visitEntity.getTreatments().stream().map(MedicalTreatmentEntity::getType).toList());

        return patientVisitTO;
    }

    public static List<PatientVisitTO> mapToTOs(final Collection<VisitEntity> visits) {
        if (visits == null) {
            return List.of();
        }

        return visits.stream()
                .map(PatientVisitMapper::mapToTO)
                .collect(Collectors.toList());
    }
}