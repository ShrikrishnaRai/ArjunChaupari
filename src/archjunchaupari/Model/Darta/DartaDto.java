/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archjunchaupari.Model.Darta;

import javafx.scene.image.Image;

/**
 *
 * @author cri
 */
//Patra Darta Model
public class DartaDto {

    private int id;
    private String created_date;
    private boolean is_deleted;
    private String darta_number;
    private String darta_date;
    private String letter_quantity;
    private String to_office;
    private String subject;
    private String image;
    private String responsible_person_full_name;
    private String signed_date;
    private String remarks;
    private int created_by;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isIs_deleted() {
        return is_deleted;
    }

    public String getCreated_date() {
        return created_date;
    }

    public void setCreated_date(String created_date) {
        this.created_date = created_date;
    }

    public int getCreated_by() {
        return created_by;
    }

    public void setCreated_by(int created_by) {
        this.created_by = created_by;
    }

    public void setIs_deleted(boolean is_deleted) {
        this.is_deleted = is_deleted;
    }

    public String getDarta_number() {
        return darta_number;
    }

    public void setDarta_number(String darta_number) {
        this.darta_number = darta_number;
    }

    public String getDarta_date() {
        return darta_date;
    }

    public void setDarta_date(String darta_date) {
        this.darta_date = darta_date;
    }

    public String getLetter_quantity() {
        return letter_quantity;
    }

    public void setLetter_quantity(String letter_quantity) {
        this.letter_quantity = letter_quantity;
    }

    public String getTo_office() {
        return to_office;
    }

    public void setTo_office(String to_office) {
        this.to_office = to_office;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getResponsible_person_full_name() {
        return responsible_person_full_name;
    }

    public void setResponsible_person_full_name(String responsible_person_full_name) {
        this.responsible_person_full_name = responsible_person_full_name;
    }

    public String getSigned_date() {
        return signed_date;
    }

    public void setSigned_date(String signed_date) {
        this.signed_date = signed_date;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

}
