package com.example.frealsb.Modules.FriendRequest.Service;

import com.example.frealsb.Modules.FriendRequest.Model.FriendRequest;

import java.util.List;

public interface IFriendRequestService {
    FriendRequest sendRequest(String userId, FriendRequest request);
    FriendRequest acceptRequest(String requestId);
    FriendRequest declineRequest(String requestId);
    List<FriendRequest> getPendingRequests(String requestId);
}
