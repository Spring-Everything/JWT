package com.example.JWT.Controller;

import com.example.JWT.DTO.JWTDTO;
import com.example.JWT.DTO.UserDTO;
import com.example.JWT.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    //회원 가입
    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {
        UserDTO createdUser = userService.createUser(userDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

    //로그인
    @PostMapping("/login")
    public ResponseEntity<JWTDTO> login(@RequestBody UserDTO userDTO) {
        JWTDTO login = userService.login(userDTO.getUid(), userDTO.getPassword());
        return ResponseEntity.ok(login);
    }

    //유저 조회
    @GetMapping("/{uid}")
    public ResponseEntity<UserDTO> getUserByUid(@PathVariable String uid) {
        UserDTO user = userService.getUserByUid(uid);
        return ResponseEntity.ok(user);
    }

    //아이디 중복 확인
    @GetMapping("/check-uid")
    public ResponseEntity<Boolean> isUidDuplicate(@RequestBody String uid) {
        boolean isDuplicate = userService.isUidDuplicate(uid);
        return ResponseEntity.ok(isDuplicate);
    }

    //닉네임 중복 확인
    @GetMapping("/check-nickname")
    public ResponseEntity<Boolean> isNicknameDuplicate(@RequestBody String nickname) {
        boolean isDuplicate = userService.isNicknameDuplicate(nickname);
        return ResponseEntity.ok(isDuplicate);
    }

    //회원 정보 수정
    @PutMapping("/{uid}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable String uid, @RequestBody UserDTO userDTO) {
        UserDTO updatedUser = userService.updateUser(uid, userDTO);
        return ResponseEntity.ok(updatedUser);
    }

    //회원 탈퇴
    @DeleteMapping("/{uid}")
    public ResponseEntity<Void> deleteUser(@PathVariable String uid) {
        userService.deleteUser(uid);
        return ResponseEntity.noContent().build();
    }
}
