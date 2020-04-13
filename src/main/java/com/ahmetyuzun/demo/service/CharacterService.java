package com.ahmetyuzun.demo.service;

import com.ahmetyuzun.demo.entity.Character;
import com.ahmetyuzun.demo.repository.CharacterRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 *Character Service Database imizde ki verilerin hepsini veya id ye cekmeyi ve Database imize kayıt etmeyi saglar.
 */
@Transactional
@Service
public class CharacterService {

    private final CharacterRepository characterRepository;

    /**
     * Constructor
     * Time Complexity : O(1)
     * @param characterRepository
     */
    public CharacterService(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    /**
     * Tabloda ki tum verileri ceker.
     * @param stringType istene siralama tipine gore listeler
     * @return Karakter listesi.
     */
    public List<Character> findAll(String stringType) {
        return stringType.isEmpty() ?
                this.characterRepository.findAll() :
                this.characterRepository.findAll(Sort.by(Sort.Order.asc(stringType)));
    }

    /**
     * id ye gore veri ceker.
     * @param id  sutunumuzda ki id.
     * @return karakter.
     */
    public Character findById(Integer id) {
        return this.characterRepository.findById(id).orElseThrow(() -> new RuntimeException("Böyle bir id bulunamadı."));
    }

    /**
     * karakter kaydı atilir.
     * @param character gelen karakter objesi.
     * @return save.
     */
    public Character save(Character character) {
        return this.characterRepository.save(character);
    }

}
