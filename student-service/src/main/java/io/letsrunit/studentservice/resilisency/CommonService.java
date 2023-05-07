package io.letsrunit.studentservice.resilisency;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.letsrunit.studentservice.feignclient.Address;
import io.letsrunit.studentservice.feignclient.FeignClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CommonService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CommonService.class);

    private final FeignClient feignClient;

    public CommonService(FeignClient feignClient) {
        this.feignClient = feignClient;
    }


    @CircuitBreaker(name = "addressService", fallbackMethod = "getAddressByStudentIdFallback")
    public Address getAddressByStudentId(long id) {
        ResponseEntity<Address> addressResponse = feignClient.getAddressByStudentId(id);
        return addressResponse.getBody();
    }

    public Address getAddressByStudentIdFallback(long id, Throwable throwable) {
        LOGGER.info("Error in address service "+ throwable.getMessage());
        return new Address();
    }
}
