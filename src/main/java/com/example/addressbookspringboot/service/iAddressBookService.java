package com.example.addressbookspringboot.service;

import com.example.addressbookspringboot.dto.AddressBookDTO;
import com.example.addressbookspringboot.model.AddressBook;



import java.util.List;

public interface iAddressBookService {
    List<AddressBook> getAddressBookData();
    AddressBook getAddressBookDataById(int empId);

    AddressBook createAddressBookData(AddressBookDTO employeeDTO);

    AddressBook updateAddressBookData(int empId, AddressBookDTO employeeDTO);
    String deleteAddressBookData(int empID);

    List<AddressBook> findByCity(String city);


    List<AddressBook> findByState(String city);

    List<AddressBook> sortByCityName();

    List<AddressBook> sortByStateName();
}

