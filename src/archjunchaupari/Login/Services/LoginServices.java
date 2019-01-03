/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archjunchaupari.Login.Services;

import archjunchaupari.Login.LoginDAO.LoginDaoIMPL;
import java.io.IOException;
import org.apache.http.client.ClientProtocolException;

/**
 *
 * @author cri
 */
public class LoginServices implements LoginDaoService {

    LoginDaoIMPL loginDaoIMPL_ic = new LoginDaoIMPL();
    
    @Override
    public boolean login(String email, String password) throws ClientProtocolException, IOException {
        if (loginDaoIMPL_ic.login(email, password)) {
            return true;
        } else {
            return false;
        }
    }

}
