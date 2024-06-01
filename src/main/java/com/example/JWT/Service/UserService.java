package com.example.JWT.Service;

import com.example.JWT.DTO.JWTDTO;
import com.example.JWT.DTO.UserDTO;

public interface UserService {
    UserDTO createUser(UserDTO userDTO);
    UserDTO getUserByUid(String uid);
    boolean isUidDuplicate(String uid);
    boolean isNicknameDuplicate(String nickname);
    UserDTO updateUser(String uid, UserDTO userDTO);
    void deleteUser(String uid);
    JWTDTO login(String uid, String password);
}
