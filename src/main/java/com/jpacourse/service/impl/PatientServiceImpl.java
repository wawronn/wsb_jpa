package com.jpacourse.service.impl;

import com.jpacourse.dto.PatientTO;
import com.jpacourse.dto.PatientVisitTO;
import com.jpacourse.mapper.PatientMapper;
import com.jpacourse.mapper.PatientVisitMapper;
import com.jpacourse.persistance.dao.PatientDao;
import com.jpacourse.persistance.entity.PatientEntity;
import com.jpacourse.rest.exception.EntityNotFoundException;
import com.jpacourse.service.PatientService;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PatientServiceImpl implements PatientService {

    private final PatientDao patientDao;

    @Autowired
    public PatientServiceImpl(PatientDao patientDao) { this.patientDao = patientDao; }

    @Override
    public PatientTO findById(Long id) {
        final PatientEntity entity = patientDao.findOne(id);
        if ( entity != null ) {
            return PatientMapper.mapToTO(entity);
        } else {
            throw new EntityNotFoundException(id);
        }
    }

    @Override
    public List<PatientVisitTO> findPatientsVisitById(Long id) {
        final PatientEntity entity = patientDao.findOne(id);
        if ( entity != null ) {
            return entity.getVisits().stream().filter(
            visit -> visit.getTime().isBefore(LocalDateTime.now()))
                    .map(PatientVisitMapper::mapToTO).toList();
        } else {
            throw new EntityNotFoundException(id);
        }
    }

    @Override
    public void deleteById(Long id) {
        try {
            patientDao.delete(id);
        } catch ( EntityNotFoundException e ) {
            throw new EntityNotFoundException(id);
        }
    }
}