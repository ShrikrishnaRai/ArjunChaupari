/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archjunchaupari.Model.Darta;

/**
 *
 * @author cri
 */
//Patra Darta Model
public class DartaDto {

    private int id;
    private String created_date;
    private String darta_number;
    private String darta_date;
    private String letter_quantity;
    private String to_office;
    private String subject;
    private String image;
    private String reponsible_person_full_name;
    private String signed_date;
    private String remarks;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCreated_date() {
        return created_date;
    }

    public void setCreated_date(String created_date) {
        this.created_date = created_date;
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

    public String getReponsible_person_full_name() {
        return reponsible_person_full_name;
    }

    public void setReponsible_person_full_name(String reponsible_person_full_name) {
        this.reponsible_person_full_name = reponsible_person_full_name;
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
