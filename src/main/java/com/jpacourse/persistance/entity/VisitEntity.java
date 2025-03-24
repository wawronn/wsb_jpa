package com.jpacourse.persistance.entity;

import java.time.LocalDateTime;
import java.util.*;

import jakarta.persistence.*;

@Entity
@Table(name = "VISIT")
public class VisitEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String description;

	@Column(nullable = false)
	private LocalDateTime time;

	// relacja jednostronna od strony dziecka
	@ManyToOne( fetch = FetchType.LAZY)
	@JoinColumn(name = "doctor_id", referencedColumnName = "id", nullable = false)
	private DoctorEntity doctor;

	// relacja jednostronna od strony dziecka
	@OneToMany( mappedBy = "visit", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY )
	private Collection<MedicalTreatmentEntity> treatments = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}

	public DoctorEntity getDoctor() {
		return doctor;
	}

	public void setDoctor(DoctorEntity doctor) {
		this.doctor = doctor;
	}

	public void setTreatments(Collection<MedicalTreatmentEntity> treatments) {
		this.treatments = treatments;
	}

	public void addTreatment(MedicalTreatmentEntity treatment) {
		treatments.add(treatment);
	}

	public void removeTreatment(MedicalTreatmentEntity treatment) {
		treatments.remove(treatment);
	}
}
