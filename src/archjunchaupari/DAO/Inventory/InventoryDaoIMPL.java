/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archjunchaupari.DAO.Inventory;

//import archjunchaupari.FXMLDocumentController;
import archjunchaupari.DAO.Login.LoginDaoIMPL;
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
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
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
    int statusCode;

    //saves Inventory from view
    @Override
    public void saveInventory(ExInventoryDto inventoryDto) {
        try {
            CloseableHttpClient client = HttpClients.createDefault();
            HttpPost httpPost = new HttpPost(RestUrl.SAVE_INVENTORY);
            Gson gson = new Gson();
            String json = gson.toJson(inventoryDto);
            StringEntity entity = new StringEntity(json);
            httpPost.setEntity(entity);
            httpPost.setHeader("Accept", "application/json");
            httpPost.setHeader("Content-type", "application/json");
            httpPost.addHeader("Authorization", "JWT " + LoginDaoIMPL.token);
            CloseableHttpResponse response = client.execute(httpPost);
            client.close();
            statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == 201) {
                if (LoginDaoIMPL.is_staff == true) {
                    JOptionPane.showMessageDialog(null, "Request Sent for Approval");
                }
                if (LoginDaoIMPL.is_branch_admin == true) {
                    JOptionPane.showMessageDialog(null, "Inventory Saved");
                }
                if (LoginDaoIMPL.is_super_admin == true) {
                    JOptionPane.showMessageDialog(null, "Inventory Saved");
                }
                if (LoginDaoIMPL.is_superuser == true) {
                    JOptionPane.showMessageDialog(null, "Inventory Saved");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Server Error::" + response);
            }

        } catch (UnsupportedEncodingException ex) {
            JOptionPane.showMessageDialog(null, "" + ex);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "" + ex);
        }
    }

    //Dispalys inventoy in view
    @Override
    public List<ExInventoryDto> getInventory() {
        List<ExInventoryDto> inventoryList = new ArrayList<>();
        try {
            HttpClient client = HttpClientBuilder.create().build();
            HttpGet request = new HttpGet(RestUrl.GET_INVENTORY);
            request.setHeader("Accept", "application/json");
            request.setHeader("Content-type", "application/json");
            request.addHeader("Authorization", "JWT " + LoginDaoIMPL.token);
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

    //Search inventory with inventory name
    public List<ExInventoryDto> getSearchedInventory(String inventory) {
        List<ExInventoryDto> inventoryList = new ArrayList<>();
        try {
            HttpClient client = HttpClientBuilder.create().build();
            HttpGet request = new HttpGet(RestUrl.SEARCH_INVENTORY + "/?search=" + inventory);
            request.setHeader("Accept", "application/json");
            request.setHeader("Content-type", "application/json");
            request.addHeader("Authorization", "JWT " + LoginDaoIMPL.token);
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

    @Override
    public void deleteInventory(int id) {
        try {
            CloseableHttpClient client = HttpClients.createDefault();
            HttpDelete httpDelete = new HttpDelete(RestUrl.DELTE_INVENTORY + id + "/");
            httpDelete.setHeader("Accept", "application/json");
            httpDelete.setHeader("Content-type", "application/json");
            httpDelete.addHeader("Authorization", "JWT " + LoginDaoIMPL.token);
            CloseableHttpResponse response = client.execute(httpDelete);
            client.close();
            statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == 204) {
                JOptionPane.showMessageDialog(null, "Deleted");
            } else {
                JOptionPane.showMessageDialog(null, "" + response);
                // JOptionPane.showMessageDialog(null, "Server Error");
            }
        } catch (IOException ex) {

            Logger.getLogger(InventoryDaoIMPL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void updateInventory(ExInventoryDto inventoryDto) {
        try {
            CloseableHttpClient client = HttpClients.createDefault();
            Gson gson = new Gson();
            String json = gson.toJson(inventoryDto);
            StringEntity entity = new StringEntity(json);
            HttpPut httpPut = new HttpPut(RestUrl.UPDATE_INVENTORY + inventoryDto.getId() + "/");
            httpPut.setEntity(entity);
            httpPut.setHeader("Accept", "application/json");
            httpPut.setHeader("Content-type", "application/json");
            httpPut.addHeader("Authorization", "JWT " + LoginDaoIMPL.token);
            CloseableHttpResponse response = client.execute(httpPut);
            client.close();
            statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == 204 || statusCode == 200 || statusCode == 201) {
                JOptionPane.showMessageDialog(null, "Updated");
            } else {
                JOptionPane.showMessageDialog(null, "" + response);
            }
        } catch (IOException ex) {
            Logger.getLogger(InventoryDaoIMPL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
