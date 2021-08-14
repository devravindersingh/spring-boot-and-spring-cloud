package com.ravinder.student.app.feignClients;

import com.ravinder.student.app.response.AddressResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(url = "${address.service.url}", value = "address-feign-client", path = "/api/address")
//@FeignClient(value = "address-service", path = "/api/address") //routing from eureka-service
@FeignClient(value = "api-gateway") //routing from api-gateway
//Now this become a general FeignClient for Student-service
public interface AddressFeignClient {

    @GetMapping("/address-service/api/address/getById/{id}")
    AddressResponse getById(@PathVariable long id);
}
