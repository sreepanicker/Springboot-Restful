/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.sreepanicker.Addressbook.persistance;

import io.sreepanicker.Addressbook.model.Address;
import java.sql.ResultSet;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

/**
 *
 * @author sreep
 */
@Component
public class DAOAddressComponent {
    //jdbcTemplate initialize by the framework 
    private final JdbcTemplate jbdcTemplate;

    public DAOAddressComponent(JdbcTemplate jbdcTemplate) {
        this.jbdcTemplate = jbdcTemplate;
    }

    public List<Address> getAddressBookList() {

        List<Address> list = jbdcTemplate.query("SELECT id,firstname,lastname,street,province from addressbook", (ResultSet rs, int rowNum) -> {
            Address address = new Address();
            address.setId(rs.getInt("id"));
            address.setFirstName(rs.getString("firstname"));
            address.setLastName(rs.getString("lastname"));
            address.setStreet(rs.getString("street"));
            address.setProvince(rs.getString("province"));
            return address;
        });
        return list;
    }

    public void insertAddress(Address address) {
        jbdcTemplate.update("INSERT INTO addressbook(id,firstname,lastname,street,province)values(?,?,?,?,?)",
                address.getId(), address.getFirstName(), address.getLastName(), address.getStreet(), address.getProvince());
    }

    public void deleteAddress(int id) {
        jbdcTemplate.update("DELETE FROM addressbook WHERE id =?", id);
    }

}
