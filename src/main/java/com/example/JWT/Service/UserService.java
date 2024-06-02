package com.example.JWT.Service;

import com.example.JWT.DTO.JWTDTO;
import com.example.JWT.DTO.UserDTO;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Date;

public interface UserService {
    UserDTO createUser(UserDTO userDTO);
    UserDTO getUserByUid(String uid);
    boolean isUidDuplicate(String uid);
    boolean isNicknameDuplicate(String nickname);
    JWTDTO login(String uid, String password);
    UserDTO updateUser(String uid, UserDTO userDTO, UserDetails userDetails);
    void deleteUser(String uid, UserDetails userDetails);
    Long refreshToken(UserDetails userDetails);
    Long getTokenRemainingTime(UserDetails userDetails);
}
