package com.javarush.services;


import com.javarush.entitie.films.Film;
import com.javarush.entitie.Rating;
import com.javarush.repository.FilmRepository;
import com.javarush.session_provider.PropertiesSessionProvider;
import com.javarush.session_provider.SessionProvider;

public class ManagerService {
    SessionProvider sessionProvider=new PropertiesSessionProvider();









    public  void addMovieToDatabase(){
	FilmRepository filmRepository=new FilmRepository(sessionProvider) ;
	Film newFilm=new Film("KISS GLORY","A Lacklusture Reflection of a Girl And a Husband who must Find a Robot in The Canadian Rockies",2006,1,5,4.99,163,11.99, Rating.NC,"Trailers,Commentaries,Behind the Scenes");
	filmRepository.save(newFilm);
    }
}
