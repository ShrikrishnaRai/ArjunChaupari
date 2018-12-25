/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archjunchaupari.Login.LoginDAO;

import archjunchaupari.Utils.RestUrl;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;

/**
 *
 * @author cri
 */
public class LoginDaoIMPL implements LoginDAO {

    @Override
    public boolean login(String email, String password) throws ClientProtocolException, IOException {
        HttpClient client = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost(RestUrl.ACCESS_TOKEN);
        List<NameValuePair> login = new ArrayList<>();
        login.add(new BasicNameValuePair("email", "" + email));
        login.add(new BasicNameValuePair("password", "" + password));
        post.setEntity(new UrlEncodedFormEntity(login));
        HttpResponse response = client.execute(post);
        int statusCode = response.getStatusLine().getStatusCode();
        BufferedReader br_Dco = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        StringBuilder result = new StringBuilder();
        String line = "";
        while ((line = br_Dco.readLine()) != null) {
            result.append(line);
        }
        if (statusCode == 200) {
            return true;
        } else {
            return false;
        }

    }

}
