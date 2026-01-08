package com.example.drift.soap.endpoint;

import com.example.drift.soap.model.User;
import com.example.drift.soap.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import javax.xml.namespace.QName;
import java.util.List;

@Endpoint
public class UserEndpoint {

    private static final String NAMESPACE_URI = "http://example.com/drift/users";

    @Autowired
    private UserService userService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetUserRequest")
    @ResponsePayload
    public UserResponse getUser(@RequestPayload GetUserRequest request) {
        User user = userService.getUserById(request.getId());
        return buildUserResponse(user);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetAllUsersRequest")
    @ResponsePayload
    public GetAllUsersResponse getAllUsers(@RequestPayload GetAllUsersRequest request) {
        List<User> users = userService.getAllUsers();
        GetAllUsersResponse response = new GetAllUsersResponse();
        for (User user : users) {
            response.addUser(convertToUserResponse(user));
        }
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "CreateUserRequest")
    @ResponsePayload
    public UserResponse createUser(@RequestPayload CreateUserRequest request) {
        User user = userService.createUser(
                request.getName(),
                request.getEmail(),
                request.getPhone());
        return buildUserResponse(user);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "UpdateUserRequest")
    @ResponsePayload
    public UserResponse updateUser(@RequestPayload UpdateUserRequest request) {
        User user = userService.updateUser(
                request.getId(),
                request.getName(),
                request.getEmail(),
                request.getPhone());
        return buildUserResponse(user);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "DeleteUserRequest")
    @ResponsePayload
    public DeleteUserResponse deleteUser(@RequestPayload DeleteUserRequest request) {
        boolean deleted = userService.deleteUser(request.getId());
        DeleteUserResponse response = new DeleteUserResponse();
        response.setSuccess(deleted);
        response.setMessage(deleted ? "User deleted successfully" : "User not found");
        return response;
    }

    private UserResponse buildUserResponse(User user) {
        if (user == null) {
            return new UserResponse(null, null, null, null);
        }
        return convertToUserResponse(user);
    }

    private UserResponse convertToUserResponse(User user) {
        return new UserResponse(user.getId(), user.getName(), user.getEmail(), user.getPhone());
    }

    // Inner classes for request/response objects
    public static class GetUserRequest {
        private Long id;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }
    }

    public static class UserResponse {
        private Long id;
        private String name;
        private String email;
        private String phone;

        public UserResponse() {
        }

        public UserResponse(Long id, String name, String email, String phone) {
            this.id = id;
            this.name = name;
            this.email = email;
            this.phone = phone;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }
    }

    public static class GetAllUsersRequest {
    }

    public static class GetAllUsersResponse {
        private List<UserResponse> users = new java.util.ArrayList<>();

        public void addUser(UserResponse user) {
            users.add(user);
        }

        public List<UserResponse> getUsers() {
            return users;
        }

        public void setUsers(List<UserResponse> users) {
            this.users = users;
        }
    }

    public static class CreateUserRequest {
        private String name;
        private String email;
        private String phone;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }
    }

    public static class UpdateUserRequest {
        private Long id;
        private String name;
        private String email;
        private String phone;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }
    }

    public static class DeleteUserRequest {
        private Long id;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }
    }

    public static class DeleteUserResponse {
        private boolean success;
        private String message;

        public boolean isSuccess() {
            return success;
        }

        public void setSuccess(boolean success) {
            this.success = success;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}
