/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.sreepanicker.Addressbook.service;

/**
 *
 * @author sreejithu panicker
 */
public class NotFoundException extends Exception {
    public NotFoundException(String msg){
        super(msg);
    }
}
