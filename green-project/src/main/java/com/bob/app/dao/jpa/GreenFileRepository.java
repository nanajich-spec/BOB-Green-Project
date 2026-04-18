package com.bob.app.dao.jpa;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bob.app.bean.GreenFile;


public interface GreenFileRepository extends JpaRepository<GreenFile, Long>
{
	Optional<GreenFile> findByAccountNumber(String accountNumber);
}
