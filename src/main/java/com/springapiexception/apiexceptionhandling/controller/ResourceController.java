package com.springapiexception.apiexceptionhandling.controller;
import com.springapiexception.apiexceptionhandling.entities.Resource;
import com.springapiexception.apiexceptionhandling.exception.InvalidInputException;
import com.springapiexception.apiexceptionhandling.exception.ResourceNotFoundException;
import com.springapiexception.apiexceptionhandling.repository.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/resources")
public class ResourceController 
{

    @Autowired
    private ResourceRepository resourceRepository;

    @GetMapping("/{id}")
    public ResponseEntity<Resource> getResourceById(@PathVariable Long id) 
    {
        Resource resource = resourceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Resource not found with id: " + id));
        return ResponseEntity.ok().body(resource);
    }

    @PostMapping("/")
    public ResponseEntity<Resource> createResource(@RequestBody Resource resource)
    {
        if (resource.getName() == null || resource.getName().isEmpty())
        {
            throw new InvalidInputException("Resource name cannot be null or empty");
        }
        Resource createdResource = resourceRepository.save(resource);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdResource);
    }
}
