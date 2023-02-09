package com.example.web.assembler;

import com.example.db.entity.User;
import com.example.web.model.UserWebModel;
import org.springframework.stereotype.Component;

@Component
public class UserWebModelAssembler extends BaseWebModelAssembler<User, UserWebModel> {
    @Override
    public UserWebModel toModel(User entity) {
        UserWebModel model = new UserWebModel();
        model
                .setId(entity.getId())
                .setUsername(entity.getUsername())
                .setEmail(entity.getEmail())
                .setBanned(entity.isBanned())
                .setPassword(model.getPassword());
        return model;
    }

    @Override
    public User toEntity(UserWebModel model) {
        User user = (User)new User()
                .setId(model.getId());
        user
                .setUsername(model.getUsername())
                .setEmail(model.getEmail())
                .setBanned(model.isBanned())
                .setPassword(model.getPassword());
        return user;
    }
}