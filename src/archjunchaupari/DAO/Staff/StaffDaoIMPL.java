/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archjunchaupari.DAO.Staff;

import archjunchaupari.DAO.Inventory.InventoryDaoIMPL;
import archjunchaupari.DAO.Login.LoginDaoIMPL;
import archjunchaupari.Model.Darta.DartaDto;
import archjunchaupari.Model.Inventory.ExInventoryDto;
import archjunchaupari.Model.PatraChalani.PatraChalaniDto;
import archjunchaupari.Model.Staff.StaffDto;
import archjunchaupari.Utils.RestUrl;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
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
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;

/**
 *
 * @author cri
 */
public class StaffDaoIMPL implements StaffDao {

    @Override
    public void saveStaff(StaffDto staffDto) {
        try {
            CloseableHttpClient client = HttpClients.createDefault();
            HttpPost httpPost = new HttpPost(RestUrl.SAVE_STAFF);
            Gson gson = new Gson();
            String json = gson.toJson(staffDto);
            JOptionPane.showMessageDialog(null, json);
            StringEntity entity = new StringEntity(json);
            httpPost.setEntity(entity);
            httpPost.setHeader("Accept", "application/json");
            httpPost.setHeader("Content-type", "application/json");
            httpPost.addHeader("Authorization", "JWT " + LoginDaoIMPL.token);
            CloseableHttpResponse response = client.execute(httpPost);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == 201 || statusCode == 204 || statusCode == 200) {
                JOptionPane.showMessageDialog(null, "Staff Information Saved");
            }
            client.close();
        } catch (UnsupportedEncodingException ex) {
            JOptionPane.showMessageDialog(null, ex);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    @Override
    public List<StaffDto> getStaffList() {
        List<StaffDto> staffList = new ArrayList<>();
        try {
            HttpClient client = HttpClientBuilder.create().build();
            HttpGet request = new HttpGet(RestUrl.GET_STAFF);
            request.setHeader("Accept", "application/json");
            request.setHeader("Content-type", "application/json");
            request.addHeader("Authorization", "JWT " + LoginDaoIMPL.token);
            HttpResponse response = client.execute(request);
            BufferedReader bufReader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            int statusCode = response.getStatusLine().getStatusCode();
            Gson gson = new Gson();
            Type staffDto = new TypeToken<ArrayList<StaffDto>>() {
            }.getType();
            staffList = new Gson().fromJson(bufReader, staffDto);
        } catch (IOException ex) {
            Logger.getLogger(InventoryDaoIMPL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return staffList;
    }

    @Override
    public void deleteStaff(int id) {
        try {
            CloseableHttpClient client = HttpClients.createDefault();
            HttpDelete httpDelete = new HttpDelete(RestUrl.DELETE_STAFF + id + "/");
            httpDelete.setHeader("Accept", "application/json");
            httpDelete.setHeader("Content-type", "application/json");
            httpDelete.addHeader("Authorization", "JWT " + LoginDaoIMPL.token);
            CloseableHttpResponse response = client.execute(httpDelete);
            client.close();
            int statusCode = response.getStatusLine().getStatusCode();
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
    public void updateStaff(StaffDto staffDto) {
        try {
            CloseableHttpClient client = HttpClients.createDefault();
            Gson gson = new Gson();
            String json = gson.toJson(staffDto);
            StringEntity entity = new StringEntity(json);
            HttpPut httpPut = new HttpPut(RestUrl.UPDATE_INVENTORY + staffDto.getId() + "/");
            httpPut.setEntity(entity);
            httpPut.setHeader("Accept", "application/json");
            httpPut.setHeader("Content-type", "application/json");
            httpPut.addHeader("Authorization", "JWT " + LoginDaoIMPL.token);
            CloseableHttpResponse response = client.execute(httpPut);
            client.close();
            int statusCode;
            statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == 204 || statusCode == 200 || statusCode == 201) {
                JOptionPane.showMessageDialog(null, "Updated");
            } else {
                JOptionPane.showMessageDialog(null, "" + response);
            }
        } catch (IOException ex) {
            Logger.getLogger(StaffDaoIMPL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
