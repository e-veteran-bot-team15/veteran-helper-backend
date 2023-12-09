package com.hackathon.veteranhelper.repository;

import com.hackathon.veteranhelper.entity.MenuItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface MenuItemRepository extends JpaRepository<MenuItemEntity, UUID> {

    @Query("select e from MenuItemEntity e where e.parentId.id = :menuItemId")
    List<MenuItemEntity> getChildrenFor(@Param("menuItemId") UUID menuItemId);
}
