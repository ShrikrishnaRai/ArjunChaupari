/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archjunchaupari.Model.PatraChalani;

/**
 *
 * @author cri
 */
public class PatraChalaniDto {

    private int id;
    private String chalani_date;
    private String chalani_number;
    private String letter_quantity;
    private String letter_date;
    private String subject;
    private String to_office;
    private String ticket;
    private String remarks;

    public PatraChalaniDto(int id, String chalani_date, String chalani_number, String letter_quantity, String letter_date, String subject, String to_office, String ticket, String remarks) {
        this.id = id;
        this.chalani_date = chalani_date;
        this.chalani_number = chalani_number;
        this.letter_quantity = letter_quantity;
        this.letter_date = letter_date;
        this.subject = subject;
        this.to_office = to_office;
        this.ticket = ticket;
        this.remarks = remarks;
    }

    public PatraChalaniDto() {
    }
    
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getChalani_date() {
        return chalani_date;
    }

    public void setChalani_date(String chalani_date) {
        this.chalani_date = chalani_date;
    }

    public String getChalani_number() {
        return chalani_number;
    }

    public void setChalani_number(String chalani_number) {
        this.chalani_number = chalani_number;
    }

    public String getLetter_quantity() {
        return letter_quantity;
    }

    public void setLetter_quantity(String letter_quantity) {
        this.letter_quantity = letter_quantity;
    }

    public String getLetter_date() {
        return letter_date;
    }

    public void setLetter_date(String letter_date) {
        this.letter_date = letter_date;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTo_office() {
        return to_office;
    }

    public void setTo_office(String to_office) {
        this.to_office = to_office;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

}
