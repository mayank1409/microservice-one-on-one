package io.letsrunit.addressservice.controller;

import io.letsrunit.addressservice.entity.Address;
import io.letsrunit.addressservice.service.IAddressService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/students")
public class AddressController {

    private final IAddressService addressService;

    public AddressController(IAddressService addressService) {
        this.addressService = addressService;
    }

    @PostMapping("/{id}/addresses")
    public ResponseEntity<Address> createAddress(@PathVariable long id, @RequestBody Address address) {
        address.setStudentId(id);
        return new ResponseEntity<>(addressService.saveAddress(address), HttpStatus.CREATED);
    }

    @GetMapping("/{id}/addresses")
    public ResponseEntity<Address> getAddressByStudentId(@PathVariable long id) {
        return new ResponseEntity<>(addressService.getAddressByStudentId(id), HttpStatus.OK);
    }

}
