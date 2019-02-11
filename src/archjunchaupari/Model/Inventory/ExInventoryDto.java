/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archjunchaupari.Model.Inventory;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author cri
 */
public class ExInventoryDto {

    private int id;
    private int registration_number;
    private String created_date;
    private String name;
    // private String made_in_country;
    private String size;
    //  private String expected_life;
    private String item_source;
    private int quantity;
    private String rate;

    private String specification;
    private String section;
    private String section_number;
    private String remarks;
    private Boolean is_approved;
    private String type;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRegistration_number() {
        return registration_number;
    }

    public void setRegistration_number(int registration_number) {
        this.registration_number = registration_number;
    }

    public String getCreated_date() {
        return created_date;
    }

    public void setCreated_date(String created_date) {
        this.created_date = created_date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public String getMade_in_country() {
//        return made_in_country;
//    }
//
//    public void setMade_in_country(String made_in_country) {
//        this.made_in_country = made_in_country;
//    }
    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

//    public String getExpected_life() {
//        return expected_life;
//    }
//
//    public void setExpected_life(String expected_life) {
//        this.expected_life = expected_life;
//    }
    public String getItem_source() {
        return item_source;
    }

    public void setItem_source(String item_source) {
        this.item_source = item_source;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getSection_number() {
        return section_number;
    }

    public void setSection_number(String section_number) {
        this.section_number = section_number;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Boolean getIs_approved() {
        return is_approved;
    }

    public void setIs_approved(Boolean is_approved) {
        this.is_approved = is_approved;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
