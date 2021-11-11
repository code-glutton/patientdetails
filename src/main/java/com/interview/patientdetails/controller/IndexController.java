package com.interview.patientdetails.controller;

import com.interview.patientdetails.model.Patient;
import com.interview.patientdetails.service.PatientService;
import org.springframework.web.bind.annotation.*;
import org.json.JSONObject;

import java.util.List;

@RestController
public class IndexController {

    private PatientService patientService;

    public IndexController(PatientService patientService) {
        this.patientService = patientService;
    }

    @PostMapping("/save")
    @CrossOrigin(origins = "http://localhost:4200")
    public void savePatientInfo(@RequestBody Patient patient){
        patientService.savePatient(patient);
    }

    @GetMapping("/getPatient/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public Patient getPatient(@PathVariable Long id){
       return patientService.getPatientId(id);
    }

    @PutMapping("/patientVisitUpdate/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public void updateVisits(@PathVariable Long id){
        patientService.updateVisits(id);
    }

    @GetMapping("/patientVisitRetrieve/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public int getVisit(@PathVariable Long id){
        return patientService.getPatientVisit(id);
    }

    @PostMapping("/getPatientByAge")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Patient> getWithAge(@RequestBody String range){

        JSONObject jsonObj = new JSONObject(range);
        int lower=jsonObj.getInt("lower");
        int upper =jsonObj.getInt("upper");
        return patientService.getAgeRange(lower,upper);
    }


}
