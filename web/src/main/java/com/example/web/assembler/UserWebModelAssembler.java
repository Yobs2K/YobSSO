package com.example.web.assembler;

import com.example.db.entity.User;
import com.example.web.model.UserWebModel;
import org.springframework.stereotype.Component;

@Component
public class UserWebModelAssembler extends BaseWebModelAssembler<User, UserWebModel> {
    @Override
    public UserWebModel toModel(User entity) {
        return null; //TODO доделать userToModel
    }
}
