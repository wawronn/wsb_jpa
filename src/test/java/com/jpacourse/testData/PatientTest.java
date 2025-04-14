package com.jpacourse.testData;

import com.jpacourse.persistance.entity.PatientEntity;

public class PatientTest {
    public static PatientEntity addPatient() {
        PatientEntity patient = new PatientEntity();
        patient.setFirstName("Krzysztof");
        patient.setLastName("Męczywór");
        patient.setPatientNumber("9998877");
        return patient;
    }
}
