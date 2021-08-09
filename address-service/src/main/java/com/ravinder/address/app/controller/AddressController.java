package com.ravinder.address.app.controller;

import com.ravinder.address.app.request.CreateAddressRequest;
import com.ravinder.address.app.response.AddressResponse;
import com.ravinder.address.app.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/address")
public class AddressController {

    @Autowired
    AddressService addressService;

    @PostMapping("/create")
    public AddressResponse createAddress (@RequestBody CreateAddressRequest createAddressRequest){
        return addressService.createAddress(createAddressRequest);
    }

    @GetMapping("/getById/{id}")
    public AddressResponse getById(@PathVariable long id){
        return addressService.getById(id);
    }
}
