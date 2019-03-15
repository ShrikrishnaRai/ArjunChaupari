/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archjunchaupari.DAO.User;

import archjunchaupari.DAO.Login.LoginDaoIMPL;
import archjunchaupari.Model.User.UserDto;
import archjunchaupari.Utils.RestUrl;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import javax.swing.JOptionPane;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

/**
 *
 * @author shree
 */
public class UserDaoIMPL implements UserDao {

    @Override
    public void saveUser(UserDto userDto) {
        try {
            CloseableHttpClient client = HttpClients.createDefault();
            HttpPost httpPost = new HttpPost(RestUrl.REGISTER_USER);
            Gson gson = new Gson();
            String json = gson.toJson(userDto);
            StringEntity entity = new StringEntity(json);
            httpPost.setEntity(entity);
            httpPost.setHeader("Accept", "application/json");
            httpPost.setHeader("Content-type", "application/json");
            httpPost.addHeader("Authorization", "JWT " + LoginDaoIMPL.token);
            CloseableHttpResponse response = client.execute(httpPost);
            JOptionPane.showMessageDialog(null, response);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == 201 || statusCode == 204 || statusCode == 200) {
                JOptionPane.showMessageDialog(null, "User Information Saved");
            }
            client.close();
        } catch (UnsupportedEncodingException ex) {
            JOptionPane.showMessageDialog(null, ex);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

}
