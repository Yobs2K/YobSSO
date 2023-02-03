package com.example.rest.assembler;
import com.example.rest.dto.UserDto;
import com.example.db.entity.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class UserRestModelAssembler {

    public List<UserDto> toDtoList(Collection<User> users) {
        List<UserDto> userDtoList = new ArrayList<>();
        for (User user : users) {
            userDtoList.add(toDto(user));
        }
        return userDtoList;
    }

    public UserDto toDto(User user) {
        UserDto model = new UserDto();

        return model.setId(user.getId())
                .setEmail(user.getEmail())
                .setUsername(user.getUsername())
                .setPassword(user.getPassword())
                .setBanned(user.isBanned());
    }

}
