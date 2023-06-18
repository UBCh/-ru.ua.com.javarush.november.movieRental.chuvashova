package com.javarush.services;

import com.javarush.session_provider.SessionProvider;

public class CityService {

    SessionProvider sessionProvider;


    public CityService(SessionProvider sessionProvider) {
	this.sessionProvider = sessionProvider;
      }



}
