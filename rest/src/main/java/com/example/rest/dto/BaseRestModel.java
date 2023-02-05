package com.example.rest.dto;

import org.springframework.hateoas.RepresentationModel;

public abstract class BaseRestModel<M extends RepresentationModel<? extends M>> extends RepresentationModel<M> {

    private Long id;

    public Long getId() {
        return id;
    }

    public M setId(Long id) {
        this.id = id;
        return (M)this;
    }

}
