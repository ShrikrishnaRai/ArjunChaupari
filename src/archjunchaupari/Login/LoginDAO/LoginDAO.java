/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archjunchaupari.Login.LoginDAO;

import java.io.IOException;
import org.apache.http.client.ClientProtocolException;

/**
 *
 * @author cri
 */
public interface LoginDAO {

    boolean login(String email, String password) throws ClientProtocolException, IOException;
}
