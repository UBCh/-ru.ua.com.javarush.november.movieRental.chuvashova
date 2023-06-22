package com.javarush.services;

import com.javarush.DTO.StaffDTO;
import com.javarush.entity.Staff;
import com.javarush.repository.EntityRepository;

public class StaffService {

    EntityRepository<Staff> staffRepository;


    public StaffService(EntityRepository<Staff> staffRepository) {
	this.staffRepository = staffRepository;
    }


    public Staff createNewStaff(StaffDTO staffDTODTO) {

	return null;
    }


    public Staff getStaff(Integer iDStaff) {
	return staffRepository.findById(iDStaff);

    }

}
