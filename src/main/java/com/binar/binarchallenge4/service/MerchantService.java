package com.binar.binarchallenge4.service;

import com.binar.binarchallenge4.entity.Merchant;
import com.binar.binarchallenge4.model.RegisterMerchantRequest;
import com.binar.binarchallenge4.repository.MerchantRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class MerchantService {

    private static final Logger logger = LoggerFactory.getLogger(MerchantService.class);

    @Autowired
    private MerchantRepository merchantRepository;

    @Autowired
    private Validator validator;

    @Transactional
    public void register(RegisterMerchantRequest request) {
        Set<ConstraintViolation<RegisterMerchantRequest>> constraintViolations = validator.validate(request);
        if (constraintViolations.size() != 0) {
            throw new ConstraintViolationException(constraintViolations);
        }
        Merchant merchant = new Merchant();
        merchant.setName(request.getName());
        merchant.setLocation(request.getLocation());
        merchant.setOpen(request.isOpen());
        merchantRepository.save(merchant);
        logger.info("Merchant registered")
    }
}
