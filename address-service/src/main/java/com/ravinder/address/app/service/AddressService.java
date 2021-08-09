package com.ravinder.address.app.service;

import com.ravinder.address.app.entity.Address;
import com.ravinder.address.app.repository.AddressRepository;
import com.ravinder.address.app.request.CreateAddressRequest;
import com.ravinder.address.app.response.AddressResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    @Autowired
    AddressRepository addressRepository;

    Logger LOG = LoggerFactory.getLogger(AddressService.class);

    public AddressResponse createAddress(CreateAddressRequest createAddressRequest) {

        LOG.info("creating Address");
        Address address = new Address();
        address.setCity(createAddressRequest.getStreet());
        address.setStreet(createAddressRequest.getCity());

        addressRepository.save(address);
        LOG.info("address saved ");
        return new AddressResponse(address);
    }

    public AddressResponse getById(long id) {
        LOG.info("inside getById " + id);
        Address address = addressRepository.findById(id).orElse(null);
        return new AddressResponse(address);
    }
}
