package jjfactory.template.crud.dto;

import jjfactory.template.crud.domain.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class UserDto {
    private Long id;
    private String name;
    private String username;
    private String email;
    private String password;

    public User toEntity(){
        return User.builder()
                .name(name)
                .username(username)
                .email(email)
                .password(password)
                .build();
    }
}
