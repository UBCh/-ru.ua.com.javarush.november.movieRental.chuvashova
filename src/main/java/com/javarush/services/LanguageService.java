package com.javarush.services;

import com.javarush.entity.Language;
import com.javarush.repository.EntityRepository;

public class LanguageService {

    EntityRepository<Language> languageRepository;


    public LanguageService(EntityRepository<Language> languageRepository) {
	this.languageRepository = languageRepository;
    }


    public Language getLanguage(String name) {
	return languageRepository.findByContent(name);
    }

}


