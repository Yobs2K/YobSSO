package com.example.web.assembler;

import com.example.db.entity.AbstractBaseEntity;
import com.example.web.model.BaseWebModel;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public abstract class BaseWebModelAssembler<E extends AbstractBaseEntity<Long>, M extends BaseWebModel<M>> {

    public abstract M toModel(E entity);

    public List<M> toModelList(Collection<E> entities) {
        return entities.stream().map(this::toModel).collect(Collectors.toList());
    }
}
