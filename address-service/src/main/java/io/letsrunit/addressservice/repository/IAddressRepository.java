package io.letsrunit.addressservice.repository;

import io.letsrunit.addressservice.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IAddressRepository extends JpaRepository<Address, Long> {
    Optional<Address> findByStudentId(Long id);
}
