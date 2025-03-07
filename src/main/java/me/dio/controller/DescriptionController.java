package me.dio.controller;

import me.dio.model.Description;
import me.dio.service.DescriptionService;
import me.dio.service.impl.DescriptionImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;

@RestController
@RequestMapping("/description")

public class DescriptionController {

    @Autowired
    DescriptionImpl descriptionService;

    @PostMapping("/create-description")
    public ResponseEntity<Description> createDescription(@RequestBody Description description){
        var descriptionCreated = descriptionService.createDescription(description);
        return ResponseEntity.ok(descriptionCreated);
    }

    @PutMapping("/update-description")
    public ResponseEntity<Description> updateDescription(@RequestBody Description description){
        descriptionService.updateDescription(description);
        return ResponseEntity.ok(description);
    }

    @GetMapping("/description/{id}")
    public ResponseEntity<Description> getDescription(@PathVariable Long id){
        var description = descriptionService.findDescriptionById(id);
        return ResponseEntity.ok(description);
    }

    @DeleteMapping("/description/{id}")
    public ResponseEntity<Description> deleteDescription(@PathVariable Long id){
        descriptionService.deleteDescription(id);
        return ResponseEntity.ok().build();
    }

}
