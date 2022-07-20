package com.example.addressbookspringboot.model;

import com.example.addressbookspringboot.dto.AddressBookDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressBook {
private String firstName , lastName , address , city , state , zipCode , phoneNo;
@Id
@GeneratedValue
private int id;
public AddressBook(AddressBookDTO addressBookDTO){
    this.firstName = addressBookDTO.firstName;
    this.lastName = addressBookDTO.lastName;
    this.city = addressBookDTO.city;
    this.state = addressBookDTO.state;
    this.address = addressBookDTO.address;
    this.zipCode = addressBookDTO.zipCode;
    this.phoneNo = addressBookDTO.phoneNo;
}
    public AddressBook(int id ,AddressBookDTO addressBookDTO){
        this.id = id;
        this.firstName = addressBookDTO.firstName;
        this.lastName = addressBookDTO.lastName;
        this.city = addressBookDTO.city;
        this.state = addressBookDTO.state;
        this.address = addressBookDTO.address;
        this.zipCode = addressBookDTO.zipCode;
        this.phoneNo = addressBookDTO.phoneNo;
   }
}