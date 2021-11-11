package com.interview.patientdetails.repository;

import com.interview.patientdetails.model.Patient;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Cacheable("patient")
public interface PatientRepository extends JpaRepository<Patient,Long> {
List<Patient> findByAgeBetween(int lower, int upper);
}
