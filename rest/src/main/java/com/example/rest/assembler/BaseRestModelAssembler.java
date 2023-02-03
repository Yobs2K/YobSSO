package com.example.rest.assembler;

import com.example.db.entity.AbstractBaseEntity;
import com.example.rest.dto.BaseRestModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;

public abstract class BaseRestModelAssembler<E extends AbstractBaseEntity, M extends BaseRestModel<M>>
        implements RepresentationModelAssembler<E, M> {

    public abstract M toModel(E entity);

}
