package com.ravinder.student.app.service;

import com.ravinder.student.app.feignClients.AddressFeignClient;
import com.ravinder.student.app.response.AddressResponse;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommonService {

    Logger LOG = LoggerFactory.getLogger(CommonService.class);

    long count = 1;

    @Autowired
    AddressFeignClient addressFeignClient;

    @CircuitBreaker(name = "addressService", fallbackMethod = "fallbackAddressId")
    public AddressResponse getAddressById(long addressId){
        LOG.info("Count " + count);
        count++;
        AddressResponse addressResponse = addressFeignClient.getById(addressId);
        return addressResponse;
    }

    public AddressResponse fallbackAddressId(long addressId, Throwable th){
        LOG.info(th.getMessage());
        return new AddressResponse();
    }
}
