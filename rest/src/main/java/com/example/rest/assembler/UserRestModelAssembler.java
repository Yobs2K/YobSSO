package com.example.rest.assembler;
import com.example.rest.dto.UserDto;
import com.example.db.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserRestModelAssembler extends BaseRestModelAssembler<User, UserDto> {

    public UserDto toModel(User user) {
        UserDto model = new UserDto();

        return model.setId(user.getId())
                .setEmail(user.getEmail())
                .setUsername(user.getUsername())
                .setPassword(user.getPassword())
                .setBanned(user.isBanned());
    }

}
