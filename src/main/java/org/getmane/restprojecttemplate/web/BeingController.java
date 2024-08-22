package org.getmane.restprojecttemplate.web;

import lombok.RequiredArgsConstructor;
import org.getmane.restprojecttemplate.domain.Being;
import org.getmane.restprojecttemplate.service.BeingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/beings", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class BeingController {

    private final BeingService beingService;

    @GetMapping
    public ResponseEntity<List<Being>> findAll() {
        List<Being> beings = beingService.findAll();

        if (beings.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(beings);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Being> findById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(beingService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Being> create(@RequestBody Being being) {
        return ResponseEntity.status(HttpStatus.CREATED).body(beingService.save(being));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Being> updateById(@PathVariable Long id, @RequestBody Being being) {
        return ResponseEntity.status(HttpStatus.OK).body(beingService.updateById(id, being));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Being> deleteById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(beingService.deleteById(id));
    }
}
