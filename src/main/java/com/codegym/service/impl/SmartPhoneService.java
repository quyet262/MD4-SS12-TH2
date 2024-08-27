package com.codegym.service.impl;

import com.codegym.model.SmartPhone;
import com.codegym.repository.ISmartPhoneRepository;
import com.codegym.service.ISmartPhoneService;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class SmartPhoneService implements ISmartPhoneService {

    private final ISmartPhoneRepository smartPhoneRepository;

    public SmartPhoneService(ISmartPhoneRepository smartPhoneRepository) {
        this.smartPhoneRepository = smartPhoneRepository;
    }


    @Override
    public Iterable<SmartPhone> findAll() {
        return smartPhoneRepository.findAll();
    }

    @Override
    public Optional<SmartPhone> findById(Long id) {
        return smartPhoneRepository.findById(id);
    }

    @Override
    public SmartPhone save(SmartPhone smartPhone) {
        return smartPhoneRepository.save(smartPhone);
    }

    @Override
    public void remove(Long id) {
    smartPhoneRepository.deleteById(id);
    }
}
