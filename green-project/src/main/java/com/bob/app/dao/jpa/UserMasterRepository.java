package com.bob.app.dao.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bob.app.bean.UserMaster;

import java.util.Optional;

@Repository
public interface UserMasterRepository extends JpaRepository<UserMaster, Long> {
    Optional<UserMaster> findByEcNumber(String ecNumber);
    
    @Modifying
    @Transactional
    @Query("UPDATE UserMaster user SET user.deleted = true WHERE user.id = :id")
    void softDeleteById(@Param("id") Long id);
}
