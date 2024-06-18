package com.example.frealsb.Modules.User.Reponsitory;

import com.example.frealsb.Modules.User.Model.Otp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OtpRepository extends JpaRepository<Otp, String> {
    Optional<Otp> findByUser_Id(String userId);
}