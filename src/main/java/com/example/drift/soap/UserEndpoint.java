package com.example.drift.soap;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class UserEndpoint {

    private static final String NAMESPACE_URI = "http://example.com/drift/soap";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetUserRequest")
    @ResponsePayload
    public UserResponse getUser(@RequestPayload UserRequest request) {
        // Mock data - replace with database call
        int userId = request.getUserId();

        if (userId == 1) {
            return new UserResponse(1, "John Doe", "john@example.com", "ACTIVE");
        } else if (userId == 2) {
            return new UserResponse(2, "Jane Smith", "jane@example.com", "ACTIVE");
        } else {
            return new UserResponse(userId, "Unknown User", "unknown@example.com", "INACTIVE");
        }
    }
}
