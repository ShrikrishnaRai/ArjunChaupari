/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archjunchaupari.Staff.StaffDAO;

import archjunchaupari.Inventory.InventoryDAO.InventoryDaoIMPL;
import archjunchaupari.Login.LoginDAO.LoginDaoIMPL;
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
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

/**
 *
 * @author cri
 */
public class StaffDaoIMPL implements StaffDao {

    @Override
    public void saveStaff(StaffDto staffDto) {
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

}
