package com.triptrace.travel.dao.repositories;

import com.triptrace.travel.dao.entities.Subscriber;

public interface SubscriberRepository extends BaseRepository<Subscriber,Integer> {
    Subscriber findAllByEmail(String email);
}
