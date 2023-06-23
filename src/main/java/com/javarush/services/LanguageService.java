package com.javarush.services;

import com.javarush.entity.Language;
import com.javarush.repository.EntityRepository;
import lombok.SneakyThrows;

public class LanguageService {

    EntityRepository<Language> languageRepository;


    public LanguageService(EntityRepository<Language> languageRepository) {
	this.languageRepository = languageRepository;
    }


    @SneakyThrows
    public Language getLanguage(String name) {
	return languageRepository.findByContent(name);
    }

}


