package com.example.frealsb.Services.Interface;

import com.example.frealsb.Entities.FriendRequest;
import com.example.frealsb.Entities.User;

import java.util.List;

public interface IFriendRequestService {
    public FriendRequest sendRequest(String userId, FriendRequest request);
    public FriendRequest acceptRequest(String requestId);
    public FriendRequest declineRequest(String requestId);
    public List<FriendRequest> getPendingRequests(String requestId);
}
