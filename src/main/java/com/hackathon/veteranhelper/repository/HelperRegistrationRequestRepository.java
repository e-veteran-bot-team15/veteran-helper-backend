package com.hackathon.veteranhelper.repository;

import com.hackathon.veteranhelper.entity.HelperRegistrationRequestEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
@Transactional
public interface HelperRegistrationRequestRepository extends JpaRepository<HelperRegistrationRequestEntity, Long> {

    @Modifying
    @Query(value = "delete from HelperRegistrationRequestEntity e where e.creationTimestamp < :date")
    void deleteAllOlderThen(@Param("date") LocalDateTime date);
}
