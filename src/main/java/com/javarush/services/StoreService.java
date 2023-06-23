package com.javarush.services;

import com.javarush.entity.Store;
import com.javarush.repository.EntityRepository;
import lombok.SneakyThrows;

public class StoreService {

    EntityRepository<Store> storeRepository;


    public StoreService(EntityRepository<Store> storeRepository) {
	this.storeRepository = storeRepository;
    }


    @SneakyThrows
    public Store getStoreByIdStaff(Integer idStaff) {
	return storeRepository.findByContent(String.valueOf(idStaff));
    }


    public Store getStoreById(Integer storeId) {

	return storeRepository.findById(storeId);
    }
}
