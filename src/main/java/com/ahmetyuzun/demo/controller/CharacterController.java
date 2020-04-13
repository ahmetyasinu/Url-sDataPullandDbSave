package com.ahmetyuzun.demo.controller;

import com.ahmetyuzun.demo.entity.Character;
import com.ahmetyuzun.demo.service.CharacterService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Karakter ile ilgili bilgileri elde etmeye yarayan endpointlerin bulundugu controller.
 */
@RestController
public class CharacterController {
    private final CharacterService characterService;

    /**
     * CharacterController icin constructor.
     * Time complexity : O(1)
     * @param characterService objesi
     */
    public CharacterController(CharacterService characterService) {
        this.characterService = characterService;
    }

    /**
     * Karakter tablosundan tum verileri ceker.
     * Time complexity : O(n)
     * @param sortingType istenilmesi halinde siralama araci.
     * @return tabloda kayitli butun veriler.
     */
    @GetMapping(path = "/character")
    public List<Character> findAll(@RequestParam(required = false, defaultValue = "") String sortingType) {
        return this.characterService.findAll(sortingType);
    }

    /**
     * Karakter tablosundan id ye gore verileri ceker
     * Time complexity : O(1)
     * @param id tabloda ki id sutunu
     * @return character
     */
    @GetMapping(path = "/character/{id}")
    public Character findById(@PathVariable Integer id) {
        return this.characterService.findById(id);
    }


}
