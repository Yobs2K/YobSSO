package com.example.web.model;

public abstract class BaseWebModel <M extends BaseWebModel<M>> {

    private Long id;

    public Long getId() {
        return id;
    }

    public M setId(Long id) {
        this.id = id;
        return (M)this;
    }
}
