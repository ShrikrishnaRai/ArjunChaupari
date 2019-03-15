/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archjunchaupari.Model.User;

/**
 *
 * @author shree
 */
public class UserDto {

    private int id;
    private String email;
    private String name;
    private String date_of_birth;
    private String gender;
    private String address;
    private String designation;
    private String joined_date;
    private String role;
    private String password;

    public UserDto() {
    }

    public UserDto(int id, String email, String name, String date_of_birth, String gender, String address, String designation, String joined_date, String role, String password) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.date_of_birth = date_of_birth;
        this.gender = gender;
        this.address = address;
        this.designation = designation;
        this.joined_date = joined_date;
        this.role = role;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(String date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getJoined_date() {
        return joined_date;
    }

    public void setJoined_date(String joined_date) {
        this.joined_date = joined_date;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}
