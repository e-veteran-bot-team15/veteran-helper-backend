package com.hackathon.veteranhelper.repository;

import com.hackathon.veteranhelper.entity.HelperRegistrationRequestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HelperRegistrationRequestRepository extends JpaRepository<HelperRegistrationRequestEntity, Long> {

}
