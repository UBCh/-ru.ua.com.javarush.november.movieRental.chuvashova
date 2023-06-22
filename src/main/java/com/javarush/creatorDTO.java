package com.javarush;

import com.javarush.DTO.AdressDTO;
import com.javarush.DTO.CustomerDTO;
import com.javarush.DTO.FilmDTO;
import com.javarush.entity.*;
import com.javarush.repository.*;
import com.javarush.services.CustomerService;
import com.javarush.services.FilmService;
import com.javarush.services.LanguageService;
import com.javarush.session_provider.PropertiesSessionProvider;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Data
@NoArgsConstructor
public class creatorDTO {


    public FilmDTO createFilmDTO() {

	LanguageService languageService = new LanguageService(new LanguageRepository(new PropertiesSessionProvider()));
	Language language = languageService.getLanguage("English");
	Integer[] idActor = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 16, 10};
	FilmDTO filmDTO = new FilmDTO("CALYPSOL-L",
		2006, language, language, (short) 0,
		BigDecimal.valueOf(0), 120, BigDecimal.valueOf(0),
		Rating.R, "Trailers,Commentaries",
		Long.valueOf(language.getId()),
		"A Touching Epistle of a Madman And a Mad Cow who must Defeat a Student in Nigeria",
		idActor, "Comedy");
	return filmDTO;
    }


    public CustomerDTO createCustomerDTO() {
	return new CustomerDTO(
		"Muucya", "Popovich",
		"jsi55iigiiigd@mail.ru", "Arecibo", 1);

    }


    public AdressDTO createAddressDTO() {
	return new AdressDTO(
		"MySakila Drive", "",
		"Alberta", "156675",
		"97599945321");
    }


    public Map createDataBuildingForRent() {
	EntityRepository<Customer> customerEntityRepository = new CustomerRepository(new PropertiesSessionProvider());
	EntityRepository<Store> storeEntityRepository = new StoreRepository(new PropertiesSessionProvider());
	CustomerService customerService = new CustomerService(customerEntityRepository, storeEntityRepository);
	EntityRepository<Film> filmEntityRepository = new FilmRepository(new PropertiesSessionProvider());
	FilmService filmService = new FilmService(filmEntityRepository);
	HashMap<String, Object> map = new HashMap<>();
	map.put("customerService", customerService);
	map.put("filmService", filmService);
	map.put("titleFilm", "CALYPSOL-L");
	map.put("idCustomer", 588);
	map.put("Deposit", 865);
	map.put("storeId", 1);
	return map;
    }

}
