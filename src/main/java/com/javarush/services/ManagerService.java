package com.javarush.services;



import com.javarush.entitie.Film;
import com.javarush.entitie.Language;
import com.javarush.entitie.Rating;
import com.javarush.repository.FilmRepository;
import com.javarush.session_provider.PropertiesSessionProvider;
import com.javarush.session_provider.SessionProvider;

import java.util.Optional;

public class ManagerService {
    SessionProvider sessionProvider=new PropertiesSessionProvider();









    public  Film getFilm(int Id){
	FilmRepository filmRepository=new FilmRepository(sessionProvider) ;
	return filmRepository.findById(Id);
    }
}
