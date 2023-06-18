package com.javarush.services;


import com.javarush.entity.Film;
import com.javarush.repository.FilmRepository;
import com.javarush.session_provider.SessionProvider;

public class ManagerService {
    SessionProvider sessionProvider;


    public ManagerService(SessionProvider sessionProvider) {
	this.sessionProvider = sessionProvider;
    }


    public Film getFilm(int Id) {
	FilmRepository filmRepository = new FilmRepository(sessionProvider);
	return filmRepository.findById(Id);
    }
}
