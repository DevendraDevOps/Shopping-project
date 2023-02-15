package com.google.starter.repository;

import com.google.starter.entity.FacebookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacebookRepository extends JpaRepository<FacebookEntity, Long> {
    FacebookEntity findByPasswordAndEmailAddressOrMobile(String password,
                                                         String emailAddress,
                                                         Long mobile);
}
