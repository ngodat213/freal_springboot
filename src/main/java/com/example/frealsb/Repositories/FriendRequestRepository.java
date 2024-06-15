package com.example.frealsb.Repositories;

import com.example.frealsb.Entities.FriendRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FriendRequestRepository extends JpaRepository<FriendRequest, String> {
    List<FriendRequest> findAllByReceiverAndStatus(String receiver, String status);
}
