package com.codegym.controller;

import com.codegym.model.SmartPhone;
import com.codegym.service.ISmartPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/smartphones")
@CrossOrigin("*")
public class SmartPhoneController {

    @Autowired
    private ISmartPhoneService smartPhoneService;


    @GetMapping
    public ResponseEntity<List<SmartPhone>> getAllSmartPhones() {
        List<SmartPhone> smartPhones = (List<SmartPhone>) smartPhoneService.findAll();
        if (smartPhones.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(smartPhones, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<SmartPhone> getSmartPhoneById(@PathVariable Long id) {
        Optional<SmartPhone> smartPhone = smartPhoneService.findById(id);
        if (!smartPhone.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(smartPhone.get(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<SmartPhone> createSmartPhone(@RequestBody SmartPhone smartPhone) {
        return new ResponseEntity<>(smartPhoneService.save(smartPhone), HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<SmartPhone> deleteSmartPhone(@PathVariable Long id) {
        Optional<SmartPhone> smartPhone = smartPhoneService.findById(id);
        if (!smartPhone.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        smartPhoneService.remove(id);
        return new ResponseEntity<>(smartPhone.get(), HttpStatus.OK);
    }

}



