package com.example.addressbookspringboot.controller;

import com.example.addressbookspringboot.dto.AddressBookDTO;
import com.example.addressbookspringboot.dto.ResponseDTO;
import com.example.addressbookspringboot.model.AddressBook;
import com.example.addressbookspringboot.service.iAddressBookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
public class AddressBookController {
        @Autowired
        iAddressBookService service;
        List <AddressBook> empDatalist = new ArrayList<>();

        @RequestMapping(value = {"","/", "/get"})
        public ResponseEntity<ResponseDTO> getAddressBookData() {
            empDatalist = service.getAddressBookData();
            ResponseDTO respOTO = new ResponseDTO("Get Call Successful", empDatalist);
            return new ResponseEntity<ResponseDTO>(respOTO, HttpStatus.OK);
        }
        @GetMapping("/get/{empId}")
        public ResponseEntity<ResponseDTO> getAddressBookData(@PathVariable("empId") int empID) {
            AddressBook empData= null;
            empData = service.getAddressBookDataById(empID);
            ResponseDTO respDTO= new ResponseDTO("Get Call For ID Successful", empData);
            return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
        }

        @PostMapping("/add")
        public ResponseEntity<ResponseDTO> createAddressBookData(
                @Valid @RequestBody AddressBookDTO empDTO) {
            AddressBook empData = null;
            empData = service.createAddressBookData(empDTO);
            ResponseDTO respOTO= new ResponseDTO("Created AddressBook  Data Successfully", empData);
            return new ResponseEntity<ResponseDTO>(respOTO, HttpStatus.OK);
        }

    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseDTO> updateAddressBookData(@PathVariable int id,@Valid @RequestBody AddressBookDTO addrDTO) {
        ResponseDTO respDTO= new ResponseDTO("Updated AddressBook Details Successfully",service.updateAddressBookData(id,addrDTO));
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

        @DeleteMapping("/delete/{empId}")
        public ResponseEntity <ResponseDTO> deleteAddressBookData(@PathVariable("empId") int empId) {
            service.deleteAddressBookData(empId);
            ResponseDTO respDTO= new ResponseDTO("Deleted Successfully", "Deleted id: "+empId);
            return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
        }
     @GetMapping("/city/{city}")
     public ResponseEntity<ResponseDTO> getCityAddressBookData(@PathVariable("city") String city) {
         List<AddressBook> empDatalist = service.findByCity(city);
        ResponseDTO respOTO= new ResponseDTO("Get Call For ID Successful", empDatalist);
        return new ResponseEntity<ResponseDTO>(respOTO, HttpStatus.OK);
    }

    @GetMapping("/state/{state}")
    public ResponseEntity<ResponseDTO> getStateAddressBookData(@PathVariable("state") String state) {
        List<AddressBook> empDatalist = service.findByState(state);
        ResponseDTO respOTO= new ResponseDTO("Get Call For ID Successful", empDatalist);
        return new ResponseEntity<ResponseDTO>(respOTO, HttpStatus.OK);
    }

    }
