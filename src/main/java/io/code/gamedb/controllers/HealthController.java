package io.code.gamedb.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
public class HealthController {

    @GetMapping(value = "/health")
    public ResponseEntity<?> applicationStatus() {
        return new ResponseEntity<>(Collections.singletonMap("status","everything is alright!!"),HttpStatus.OK);
    }

}
