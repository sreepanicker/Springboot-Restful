/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.sreepanicker.Addressbook.service;

import io.sreepanicker.Addressbook.model.Address;
import io.sreepanicker.Addressbook.persistance.DAOAddressComponent;
import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Main controller for Address book application.
 *
 * @author sreejithu panicker
 */
@RestController
public class AddressBook {
    //DAO for accessing the database service
    private final DAOAddressComponent addressComponent;

    public AddressBook(DAOAddressComponent addressComponent) {
        this.addressComponent = addressComponent;
    }

    @RequestMapping(value = "/v1/address", method = RequestMethod.GET)
    public List<Address> getAddressList() throws NotFoundException {
        List<Address> address = addressComponent.getAddressBookList();
        if (address.size() < 0) {
            throw new NotFoundException("No records found");
        }
        return address;
    }

    @RequestMapping(value = "/v1/address/{id}", method = RequestMethod.GET)
    public void getAddressById(@PathVariable("id") int id) {
        //return Address;
    }

    @RequestMapping(value = "/v1/address", method = RequestMethod.POST)
    public void createAddress(@RequestBody Address address) {
        addressComponent.insertAddress(address);

    }

    @RequestMapping(value = "/v1/address/{id}", method = RequestMethod.DELETE)
    public void removeAddressById(@PathVariable("id") int id) {
        addressComponent.deleteAddress(id);
    }

    @RequestMapping(value = "/v1/address/{id}", method = RequestMethod.PUT)
    public void updateAddressById(@PathVariable("id") int id) {
        //return Address;
    }

}
