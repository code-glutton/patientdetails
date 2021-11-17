package com.interview.patientdetails.service;

import com.interview.patientdetails.model.Patient;
import com.interview.patientdetails.repository.PatientRepository;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@CacheConfig(cacheNames = "patient-cache")
public class PatientService {
    private PatientRepository patientRepo;

    public PatientService(PatientRepository patientRepo) {
        this.patientRepo = patientRepo;
    }

    public void savePatient(Patient patient){
        patientRepo.save(patient);
    }

    @Cacheable
    public Patient getPatientId(Long id){
        Optional<Patient> findPatientOpt = patientRepo.findById(id);
        Patient patient = findPatientOpt.get();
        return patient;
    }

    public void updateVisits(Long id){
        Optional<Patient> findPatientOpt = patientRepo.findById(id);
        Patient patient = findPatientOpt.get();
        patient.setVisits(patient.getVisits()+1);
        patientRepo.save(patient);
    }

    public int getPatientVisit(Long id){
        Optional<Patient> findPatientOpt = patientRepo.findById(id);
        Patient patient = findPatientOpt.get();
        return patient.getVisits();
    }

    public List<Patient> getAgeRange(int lower, int upper){
        return patientRepo.findByAgeBetween(lower, upper);
    }
}
