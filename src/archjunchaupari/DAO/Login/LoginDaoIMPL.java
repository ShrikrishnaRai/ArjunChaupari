/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archjunchaupari.DAO.Login;

import archjunchaupari.Model.Inventory.ExInventoryDto;
import archjunchaupari.Utils.Credential.CredentialDto;
import archjunchaupari.Utils.RestUrl;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
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

    Gson gson;
    List<CredentialDto> credentialList = new ArrayList<>();
    public static String token;
    public static boolean is_superuser;
    public static boolean is_super_admin;
    public static boolean is_branch_admin;
    public static boolean is_staff;
    public static String role;

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
        gson = new Gson();
        Type credentialDto = new TypeToken<ArrayList<CredentialDto>>() {
        }.getType();
        credentialList = new Gson().fromJson(br_Dco, credentialDto);
        for (int i = 0; i < credentialList.size(); i++) {
            token = credentialList.get(i).getToken();
            role = credentialList.get(i).getRole();
            if (token != null) {
                break;
            }
        }
        if (statusCode == 200 || statusCode == 201 || statusCode == 204) {
            return true;
        } else {
            return false;
        }

    }

}
