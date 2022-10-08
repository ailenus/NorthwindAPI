package com.sparta.northwindapi.dto;

import java.io.Serializable;

public abstract class DTO implements Serializable {
    protected Integer id;

    public Integer getId() {
        return id;
    }

    public DTO setId(Integer id) {
        this.id = id;
        return this;
    }
}
