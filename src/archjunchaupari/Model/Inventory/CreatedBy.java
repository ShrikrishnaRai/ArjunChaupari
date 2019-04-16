/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archjunchaupari.Model.Inventory;

/**
 *
 * @author shree
 */
public class CreatedBy {

    private int id;
    private String full_name;
    private String email;

    public CreatedBy() {
    }

    public CreatedBy(int id, String full_name, String email) {
        this.id = id;
        this.full_name = full_name;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
