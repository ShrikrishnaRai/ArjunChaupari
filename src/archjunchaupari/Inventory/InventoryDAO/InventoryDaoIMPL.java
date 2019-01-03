/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archjunchaupari.Inventory.InventoryDAO;

import archjunchaupari.Model.Inventory.ExInventoryDto;
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
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;

/**
 *
 * @author cri
 */
public class InventoryDaoIMPL implements InventoryDAO {

    List<ExInventoryDto> inventoryList = new ArrayList<>();

    @Override
    public void saveInventory(ExInventoryDto inventoryDto) {
        try {
            HttpClient client = HttpClientBuilder.create().build();
            HttpPost post = new HttpPost(RestUrl.SAVE_INVENTORY);
            List<NameValuePair> saveInventory = new ArrayList<>();
            saveInventory.add(new BasicNameValuePair("name", "" + inventoryDto.getName()));
            saveInventory.add(new BasicNameValuePair("registration_number", "" + inventoryDto.getRegistration_number()));
            saveInventory.add(new BasicNameValuePair("quantity", "" + inventoryDto.getQuantity()));
            saveInventory.add(new BasicNameValuePair("rate", "" + inventoryDto.getRate()));
            saveInventory.add(new BasicNameValuePair("specification", "" + inventoryDto.getSpecification()));
            saveInventory.add(new BasicNameValuePair("section", "" + inventoryDto.getSection()));
            saveInventory.add(new BasicNameValuePair("section_number", "" + inventoryDto.getSection_number()));
            saveInventory.add(new BasicNameValuePair("remarks", "" + inventoryDto.getRemarks()));
            post.setEntity(new UrlEncodedFormEntity(saveInventory));
            HttpResponse response = client.execute(post);
            /*        HttpClient client = HttpClientBuilder.create().build();
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
            }*/
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
            List<ExInventoryDto> iList = new Gson().fromJson(bufReader, inventoryDto);
        } catch (IOException ex) {
            Logger.getLogger(InventoryDaoIMPL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return inventoryList;
    }

}
