package io.letsrunit.addressservice.service.impl;

import io.letsrunit.addressservice.entity.Address;
import io.letsrunit.addressservice.repository.IAddressRepository;
import io.letsrunit.addressservice.service.IAddressService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddressServiceImpl implements IAddressService {

    private final IAddressRepository addressRepository;

    public AddressServiceImpl(IAddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public Address saveAddress(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public Address getAddressByStudentId(Long id) {
        Optional<Address> optionalAddress = addressRepository.findByStudentId(id);

        if (optionalAddress.isEmpty()) {
            throw new RuntimeException("Invalid Identifier " + id);
        }

        return optionalAddress.get();
    }
}
