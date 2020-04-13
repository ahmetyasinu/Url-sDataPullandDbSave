package com.ahmetyuzun.demo.repository;

import com.ahmetyuzun.demo.entity.Episode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 * EpisodeService icin interface.
 */
@Repository
public interface EpisodeRepository extends JpaRepository<Episode,Integer> {
}
