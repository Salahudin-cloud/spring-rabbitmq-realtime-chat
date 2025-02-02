package com.demo.chatApp.services;

import com.demo.chatApp.dto.WebResponse;
import com.demo.chatApp.dto.auth.RegisterRequest;
import com.demo.chatApp.entity.Users;
import com.demo.chatApp.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServices {

    @Autowired
    private UserRepository userRepository;

    public WebResponse<String> registerUser(@Valid RegisterRequest registerRequest){
        Users data = new Users();
        data.setUsername(registerRequest.getUsername());
        data.setPassword(registerRequest.getPassword());


        userRepository.save(data);

        return WebResponse.<String>builder()
                .message("OK")
                .build();
    }

}
