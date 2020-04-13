package com.ahmetyuzun.demo.repository;

import com.ahmetyuzun.demo.entity.Character;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * CharacterService icin interface
 */
@Repository
public interface CharacterRepository extends JpaRepository<Character, Integer> {
}
