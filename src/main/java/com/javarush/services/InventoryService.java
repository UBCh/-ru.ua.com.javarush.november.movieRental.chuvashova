package com.javarush.services;

import com.javarush.entity.Film;
import com.javarush.entity.Inventory;
import com.javarush.entity.Store;
import com.javarush.repository.EntityRepository;

import java.util.*;

public class InventoryService {

    EntityRepository<Inventory> inventoryRepository;


    public InventoryService(EntityRepository<Inventory> inventoryRepository) {
	this.inventoryRepository = inventoryRepository;
    }


    public Inventory createInventory(Film film, Store store) {
	Map<String, Object> map = new HashMap<>();
	map.put("film", film);
	map.put("store", store);
	inventoryRepository.create(map);
	ArrayList<Inventory> list = (ArrayList<Inventory>) inventoryRepository.findList(String.valueOf(film.getId()));
	return sorteDataCreate(list);

    }


    public List getListIdInventory(Integer idFilm) {
	ArrayList<Integer> idRental = new ArrayList<>();
	List<Inventory> listIdInventory = inventoryRepository.findList(String.valueOf(idFilm));
	for (Inventory i : listIdInventory) {
	    idRental.add(i.getId());
	}
	return idRental;
    }


    private Inventory sorteDataCreate(List<Inventory> list) {
	Collections.sort(list, Comparator.comparing(Inventory::getLast_update));
	Inventory inventory = list.get(list.size() - 1);
	return inventory;
    }

}
