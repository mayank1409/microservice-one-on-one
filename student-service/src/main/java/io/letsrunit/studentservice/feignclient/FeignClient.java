package io.letsrunit.studentservice.feignclient;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@org.springframework.cloud.openfeign.FeignClient(name = "api-gateway")
public interface FeignClient {

    @RequestMapping(method = RequestMethod.GET, value = "/address-service/api/v1/students/{id}/addresses", consumes = APPLICATION_JSON_VALUE)
    ResponseEntity<Address> getAddressByStudentId(@PathVariable long id);

}
