/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archjunchaupari.Model.Staff;

/**
 *
 * @author cri
 */
public class StaffDto {

    /*"id": 1,
    "email": "cri_rai@outlook.com",
    "first_name": "string",
    "last_name": "string",
    "date_of_birth": "1995-01-01",
    "gender": "Male",
    "salary": "10000",
    "joined_date": "1995-01-01",
    "designation": "string"*/
//    private int id;
//    private String email;
//    private String first_name;
//    private String last_name;
//    private String date_of_birth;
//    private String gender;
//    private String salary;
//    private String joined_date;
//    private String designation;
    private String gender;
    private String joined_date;
    private String date_of_birth;
    private String last_name;
    private int id;
    private String designation;
    private String salary;
    private String first_name;
    private String email;

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

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
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

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getJoined_date() {
        return joined_date;
    }

    public void setJoined_date(String joined_date) {
        this.joined_date = joined_date;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

}
