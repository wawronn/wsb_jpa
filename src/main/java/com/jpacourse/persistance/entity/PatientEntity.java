package com.jpacourse.persistance.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

import jakarta.persistence.*;

@Entity
@Table(name = "PATIENT")
public class PatientEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String firstName;

	@Column(nullable = false)
	private String lastName;

	@Column(nullable = false)
	private String telephoneNumber;

	private String email;

	@Column(nullable = false)
	private String patientNumber;

	@Column(nullable = false)
	private LocalDate dateOfBirth;

	// relacja jednostronna od strony rodzica
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "patient", orphanRemoval = true)
	private Collection<VisitEntity> visits = new ArrayList<>();

	// Relacja jednostronna od strony rodzica (PatientEntity - One to One)
	@OneToOne
	@JoinColumn(name = "address_id") // Tutaj mapujemy adres do lekarza
	private AddressEntity address;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getTelephoneNumber() {
		return telephoneNumber;
	}

	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPatientNumber() {
		return patientNumber;
	}

	public void setPatientNumber(String patientNumber) {
		this.patientNumber = patientNumber;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Collection<VisitEntity> getVisits() {
		return visits;
	}

	public void setVisits(Collection<VisitEntity> visits) {
		this.visits = visits;
	}

	public void deleteVisit(VisitEntity visit) {
		this.visits.remove(visit);
	}

	public AddressEntity getAddress() {
		return address;
	}

	public void setAddress(AddressEntity address) {
		this.address = address;
	}

}
