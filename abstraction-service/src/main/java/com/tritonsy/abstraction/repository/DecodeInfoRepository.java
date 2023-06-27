package com.tritonsy.abstraction.repository;

import com.tritonsy.abstraction.model.DecodeInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DecodeInfoRepository extends JpaRepository<DecodeInfo, UUID> {

}
