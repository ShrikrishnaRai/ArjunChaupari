/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archjunchaupari.Model.Login;

/**
 *
 * @author cri
 */
public class LoginDto {

    private int id;
    private String email;
    private String password;

    public LoginDto() {
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LoginDto(int id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }

}
