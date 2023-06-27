package com.tritonsy.abstraction.model;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;
import java.util.UUID;

/**
 * Не генерирует новый id, если id уже задан в новом объекте сущности;
 * Идея взята из https://stackoverflow.com/questions/18182826/set-id-pk-generation-value-auto-and-manual
 */
public class CustomUUIDGenerator implements IdentifierGenerator {

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) {
        if (object == null) {
            throw new HibernateException(new NullPointerException());
        }
        UUID id = ((AbstractEntity) object).getId();
        return id != null ? id : UUID.randomUUID();
    }
}
