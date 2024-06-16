package com.example.frealsb.Services.Interface;

import com.example.frealsb.Entities.FriendRequest;

import java.util.List;

public interface IFriendRequestService {
    FriendRequest sendRequest(String userId, FriendRequest request);
    FriendRequest acceptRequest(String requestId);
    FriendRequest declineRequest(String requestId);
    List<FriendRequest> getPendingRequests(String requestId);
}
