package com.example.frealsb.Services;

import com.example.frealsb.Entities.FriendRequest;
import com.example.frealsb.Repositories.FriendRequestRepository;
import com.example.frealsb.Services.Interface.IFriendRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class FriendRequestService implements IFriendRequestService {
    @Autowired
    private FriendRequestRepository friendRequestRepository;

    @Override
    public FriendRequest sendRequest(FriendRequest request) {
        request.setStatus("PENDING");
        request.setCreatedAt(LocalDateTime.now());
        return friendRequestRepository.save(request);
    }

    @Override
    public FriendRequest acceptRequest(String requestId) {
        FriendRequest request = friendRequestRepository.findById(requestId).orElseThrow();
        request.setStatus("ACCEPTED");
        return friendRequestRepository.save(request);
    }

    @Override
    public FriendRequest declineRequest(String requestId) {
        FriendRequest request = friendRequestRepository.findById(requestId).orElseThrow();
        request.setStatus("DECLINED");
        return friendRequestRepository.save(request);
    }

    @Override
    public List<FriendRequest> getPendingRequests(String userId) {
        return friendRequestRepository.findAllByReceiverAndStatus(userId, "PENDING");
    }
}
