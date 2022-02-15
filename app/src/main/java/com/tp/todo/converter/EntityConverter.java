package com.tp.todo.converter;

import com.tp.todo.controller.dto.BaseDto;
import com.tp.todo.entity.IEntity;

public interface EntityConverter<T extends BaseDto, U extends IEntity> {
    T to(U u);
    U to(T t);
}
