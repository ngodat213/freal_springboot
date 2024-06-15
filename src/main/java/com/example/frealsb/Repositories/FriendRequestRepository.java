package com.example.frealsb.Repositories;

import com.example.frealsb.Entities.FriendRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FriendRequestRepository extends JpaRepository<FriendRequest, String> {
    @Query("SELECT fr FROM FriendRequest fr WHERE fr.receiver.id = ?1 AND fr.status = ?2")
    List<FriendRequest> findAllByReceiverAndStatus(String id, String status);
}
