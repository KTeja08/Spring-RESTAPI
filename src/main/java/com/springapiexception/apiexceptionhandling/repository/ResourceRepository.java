package com.springapiexception.apiexceptionhandling.repository;

import com.springapiexception.apiexceptionhandling.entities.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResourceRepository extends JpaRepository<Resource, Long> 
{
    // You can add custom query methods if needed
}