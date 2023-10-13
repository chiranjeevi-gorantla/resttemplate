package com.chirango.resttemplate.service;

import com.chirango.resttemplate.dto.UserResponse;
import com.chirango.resttemplate.model.Address;
import com.chirango.resttemplate.model.User;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class TestService {

    public UserResponse getUser(User user) {
        Address address = user.getAddress();

        UserResponse userResponse = new UserResponse();
        userResponse.setName(user.getName());
        userResponse.setUsername(user.getUsername());
        userResponse.setEmail(user.getEmail());
        userResponse.setZipcode(address.getZipcode());

        return userResponse;
    }
}
