package com.example.demo.data.entity.listener;

import com.example.demo.data.entity.ListenerEntity;
import jakarta.persistence.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// JpaAuditing 동적 원리 체크
public class CustomerListener {
    private final Logger LOGGER = LoggerFactory.getLogger(CustomerListener.class);

    @PostLoad
    public void postLoad(ListenerEntity entity) {
        LOGGER.info("[postLoad] 호출");
    }

    @PrePersist
    public void prePersist(ListenerEntity entity) {
        LOGGER.info("[prePersist] 호출");
    }

    @PostPersist
    public void postPersist(ListenerEntity entity) {
        LOGGER.info("[postPersist] 호출");
    }

    @PreUpdate
    public void preUpdate(ListenerEntity entity) {
        LOGGER.info("[preUpdate] 호출");
    }

    @PostUpdate
    public void postUpdate(ListenerEntity entity) {
        LOGGER.info("[postUpdate] 호출");
    }

    @PreRemove
    public void preRemove(ListenerEntity entity) {
        LOGGER.info("[preRemove] 호출");
    }

    @PostRemove
    public void postRemove(ListenerEntity entity) {
        LOGGER.info("[postRemove] 호출");
    }
}
