package com.binar.binarchallenge4.service;

import com.binar.binarchallenge4.repository.MerchantRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MerchantService {
    @Autowired
    private MerchantRepository merchantRepository;

    @Autowired
    private Validator validator;
}
