package com.example.JWT.DTO;

import com.example.JWT.Entity.UserEntity;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class UserDTO {
    private Long id;
    private String uid;
    private String password;
    private String nickname;

    public static UserDTO entityToDto(UserEntity userEntity) {
        return new UserDTO(
                userEntity.getId(),
                userEntity.getUid(),
                userEntity.getPassword(),
                userEntity.getNickname()
        );
    }

    public UserEntity dtoToEntity() {
        return new UserEntity(id, uid, password, nickname);
    }
}
