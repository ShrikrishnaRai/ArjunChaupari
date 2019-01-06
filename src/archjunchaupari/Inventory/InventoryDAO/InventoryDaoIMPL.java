/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archjunchaupari.Inventory.InventoryDAO;

import archjunchaupari.FXMLDocumentController;
import archjunchaupari.Login.LoginDAO.LoginDaoIMPL;
import archjunchaupari.Model.Inventory.ExInventoryDto;
import archjunchaupari.Utils.Credential.CredentialDto;
import archjunchaupari.Utils.Credential.HCredential;
import archjunchaupari.Utils.RestUrl;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;

/**
 *
 * @author cri
 */
public class InventoryDaoIMPL implements InventoryDAO {

    List<ExInventoryDto> inventoryList = new ArrayList<>();

    LoginDaoIMPL l = new LoginDaoIMPL();
    HCredential hCredential_ic = new HCredential();
    int statusCode;

    @Override
    public void saveInventory(ExInventoryDto inventoryDto) {
        try {
            CloseableHttpClient client = HttpClients.createDefault();
            HttpPost httpPost = new HttpPost(RestUrl.SAVE_INVENTORY);
            Gson gson = new Gson();
            JOptionPane.showMessageDialog(null, "" + inventoryDto.getName());
            String json = gson.toJson(inventoryDto);
            JOptionPane.showMessageDialog(null, "String::" + json);
            StringEntity entity = new StringEntity(json);
            httpPost.setEntity(entity);
            httpPost.setHeader("Accept", "application/json");
            httpPost.setHeader("Content-type", "application/json");
            httpPost.addHeader("Authorization", "JWT " + LoginDaoIMPL.token);
            CloseableHttpResponse response = client.execute(httpPost);
            client.close();
            JOptionPane.showMessageDialog(null, "" + response);
            System.out.println("" + response);
            statusCode = response.getStatusLine().getStatusCode();
        } catch (UnsupportedEncodingException ex) {
            JOptionPane.showMessageDialog(null, "" + ex);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "" + ex);
        }
    }

    @Override
    public List<ExInventoryDto> getInventory() {
        List<ExInventoryDto> inventoryList = new ArrayList<>();
        try {
            HttpClient client = HttpClientBuilder.create().build();
            HttpGet request = new HttpGet(RestUrl.GET_INVENTORY);
            HttpResponse response = client.execute(request);
            BufferedReader bufReader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            int statusCode = response.getStatusLine().getStatusCode();
            Gson gson = new Gson();
            Type inventoryDto = new TypeToken<ArrayList<ExInventoryDto>>() {
            }.getType();
            inventoryList = new Gson().fromJson(bufReader, inventoryDto);
        } catch (IOException ex) {
            Logger.getLogger(InventoryDaoIMPL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return inventoryList;
    }

}
