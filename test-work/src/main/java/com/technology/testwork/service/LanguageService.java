package com.technology.testwork.service;

import com.technology.testwork.dto.CreateLanguageDto;
import com.technology.testwork.dto.LanguageDto;
import com.technology.testwork.models.Language;
import com.technology.testwork.repository.LanguageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class LanguageService {


    @Autowired
    LanguageRepo languageRepo;


    public List<LanguageDto> getAll() {

        List<Language> list = languageRepo.findAll();

        List<LanguageDto> languageDtos = new ArrayList<>();

        for (Language item : list) {

            LanguageDto languageDto = new LanguageDto();

            languageDto.setName(item.getName());
            languageDto.setRating(item.getRating());
            languageDto.setDescription(item.getDescription());
            languageDtos.add(languageDto);
        }


        return languageDtos;
    }


    public CreateLanguageDto create(LanguageDto languageDto) {
        Language language = new Language();
        language.setRating(languageDto.getRating());
        language.setDescription(languageDto.getDescription());
        language.setName(languageDto.getName());

        languageRepo.save(language);

        CreateLanguageDto createLanguageDto = new CreateLanguageDto();

        createLanguageDto.setBody(languageDto);
        createLanguageDto.setState("ok");

        return createLanguageDto;
    }


    public CreateLanguageDto delete(String name) {
        languageRepo.deleteAllByName(name);
        CreateLanguageDto createLanguageDto = new CreateLanguageDto();
        createLanguageDto.setState("ok");
        return createLanguageDto;
    }


    public CreateLanguageDto update(LanguageDto languageDto) {


        languageRepo.updateByName(languageDto.getName(), languageDto.getDescription(), languageDto.getRating());

        CreateLanguageDto createLanguageDto = new CreateLanguageDto();

        createLanguageDto.setBody(languageDto);
        createLanguageDto.setState("ok");

        return createLanguageDto;

    }


    public Language findByName(String name) {

        return languageRepo.findByName(name);
    }


}
