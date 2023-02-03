package com.example.rest.assembler;

import com.example.db.entity.AbstractBaseEntity;
import com.example.rest.dto.BaseRestModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public abstract class BaseRestModelAssembler<E extends AbstractBaseEntity, M extends BaseRestModel<M>>
        implements RepresentationModelAssembler<E, M> {

    public abstract M toModel(E entity);

    public List<M> toModelList(Collection<E> entities) {
        return entities.stream().map(this::toModel).collect(Collectors.toList());
    }

}
