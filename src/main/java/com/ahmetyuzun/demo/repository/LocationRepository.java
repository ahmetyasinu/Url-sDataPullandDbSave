package com.ahmetyuzun.demo.repository;

import com.ahmetyuzun.demo.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * LocationService icin interface.
 */
@Repository
public interface LocationRepository extends JpaRepository<Location, Integer> {

    Location findByName(String name);
}
