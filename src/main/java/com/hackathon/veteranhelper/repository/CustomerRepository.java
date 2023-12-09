package com.hackathon.veteranhelper.repository;

import com.hackathon.veteranhelper.entity.CustomerEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
@Transactional
public interface CustomerRepository extends JpaRepository<CustomerEntity, UUID> {

    @Query("select e.currentMenuItemId from CustomerEntity e where e.chatId = :chatId")
    UUID getCurrentMenuItemForChat(@Param("chatId") Long chatId);

    @Query("update CustomerEntity e set e.currentMenuItemId = :menuItemId where e.chatId = :chatId")
    @Modifying
    void setCurrentMenuItemForChatId(@Param("menuItemId") UUID menuItemId, @Param("chatId") Long chatId);

}
