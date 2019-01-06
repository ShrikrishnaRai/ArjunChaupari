/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archjunchaupari.Utils.Credential;

/**
 *
 * @author cri
 */
public class CredentialDto {

    public CredentialDto() {
    }

    public CredentialDto(String token, String email, int user_id, boolean is_super_admin, boolean is_branch_admin) {
        this.token = token;
        this.email = email;
        this.user_id = user_id;
        this.is_super_admin = is_super_admin;
        this.is_branch_admin = is_branch_admin;
    }

    private String token;
    private String email;
    private int user_id;
    private boolean is_super_admin;
    private boolean is_branch_admin;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public boolean isIs_super_admin() {
        return is_super_admin;
    }

    public void setIs_super_admin(boolean is_super_admin) {
        this.is_super_admin = is_super_admin;
    }

    public boolean isIs_branch_admin() {
        return is_branch_admin;
    }

    public void setIs_branch_admin(boolean is_branch_admin) {
        this.is_branch_admin = is_branch_admin;
    }

}
