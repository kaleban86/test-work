package com.technology.testwork.controller;

import com.technology.testwork.dto.CreateLanguageDto;
import com.technology.testwork.dto.LanguageDto;
import com.technology.testwork.models.Language;
import com.technology.testwork.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/language")
public class LanguageController {


    @Autowired
    LanguageService languageService;


    @GetMapping
    public List<LanguageDto> getAll() {
        return languageService.getAll();
    }

    @PostMapping
    public CreateLanguageDto create(@RequestBody LanguageDto languageDto) {
        return languageService.create(languageDto);
    }


    @PutMapping("/{name}")
    public CreateLanguageDto update(
            @PathVariable("name") String name,
            @RequestBody LanguageDto languageDto) {
        languageDto.setName(name);
        return languageService.update(languageDto);
    }


    @GetMapping("{name}")
    public Language findByName(@PathVariable("name") String name) {
        return languageService.findByName(name);
    }

    @DeleteMapping("/{name}")
    public CreateLanguageDto delete(@PathVariable("name") String name) {
        return languageService.delete(name);

    }
}
