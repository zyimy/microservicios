package com.microservicios.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservicios.entity.*;

@Repository
public interface UserRepository extends JpaRepository<Users,Integer> {

}
