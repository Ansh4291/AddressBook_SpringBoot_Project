package com.example.addressbookspringboot.service;
import com.example.addressbookspringboot.dto.AddressBookDTO;
import com.example.addressbookspringboot.model.AddressBook;
import com.example.addressbookspringboot.repository.AddressBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressBookService implements iAddressBookService {
    private List<AddressBook> employeeList = new ArrayList<>();
    @Autowired
    AddressBookRepository addressBookRepository;
    
    @Override
    public List<AddressBook> getAddressBookData() {
        return addressBookRepository.findAll();
    }
    @Override
    public AddressBook  getAddressBookDataById(int empId) {
        return addressBookRepository.findById(empId).orElse(null);
    }
    @Override
    public AddressBook createAddressBookData(AddressBookDTO addressBookDTO){
        AddressBook addData = new AddressBook(addressBookDTO);
        return addressBookRepository.save(addData);

    }
    @Override
    public AddressBook updateAddressBookData(int empId, AddressBookDTO AddressBookDTO){
        AddressBook AddressBookDetails=new AddressBook(empId,AddressBookDTO);
        addressBookRepository.save(AddressBookDetails);
        return AddressBookDetails;
    }
    @Override
    public String deleteAddressBookData(int empID) {
        addressBookRepository.deleteById(empID);
        return "Data Deleted";
    }
    @Override
    public List<AddressBook> findByCity(String city){
        return addressBookRepository.findByCity(city);
    }

    @Override
    public List<AddressBook> findByState(String city){
        return addressBookRepository.findByState(city);
    }

    @Override
    public List<AddressBook> sortByCityName(){
        return addressBookRepository.sortByCity();
    }
    @Override
    public List<AddressBook> sortByStateName(){
        return addressBookRepository.sortByState();
    }
}
