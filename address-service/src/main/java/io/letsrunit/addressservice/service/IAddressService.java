package io.letsrunit.addressservice.service;

import io.letsrunit.addressservice.entity.Address;

public interface IAddressService {

    Address saveAddress(Address address);

    Address getAddressByStudentId(Long id);
}
