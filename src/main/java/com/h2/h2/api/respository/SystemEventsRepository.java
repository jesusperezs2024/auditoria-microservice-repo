package com.h2.h2.api.respository;

import com.h2.h2.api.model.SystemEventsModel;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SystemEventsRepository extends JpaRepository<SystemEventsModel, Integer> {
}
