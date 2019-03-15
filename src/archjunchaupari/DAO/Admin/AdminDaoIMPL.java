/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archjunchaupari.DAO.Admin;

import archjunchaupari.DAO.Inventory.InventoryDaoIMPL;
import archjunchaupari.DAO.Login.LoginDaoIMPL;
import archjunchaupari.Model.Inventory.ExInventoryDto;
import archjunchaupari.Utils.RestUrl;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

/**
 *
 * @author shree
 */
public class AdminDaoIMPL implements AdminDao {

    @Override
    public void allowInventory(ExInventoryDto inventoryDto) {
        try {
            CloseableHttpClient client = HttpClients.createDefault();
            Gson gson = new Gson();
            String json = gson.toJson(inventoryDto);
            StringEntity entity = new StringEntity(json);
            HttpPut httpPut = new HttpPut(RestUrl.ALLOW_INVENTORY + inventoryDto.getId() + "/");
            httpPut.setEntity(entity);
            httpPut.setHeader("Accept", "application/json");
            httpPut.setHeader("Content-type", "application/json");
            httpPut.addHeader("Authorization", "JWT " + LoginDaoIMPL.token);
            CloseableHttpResponse response = client.execute(httpPut);
            client.close();
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == 204 || statusCode == 200 || statusCode == 201) {
                JOptionPane.showMessageDialog(null, "Updated");
            } else {
                JOptionPane.showMessageDialog(null, "" + response);
            }
        } catch (IOException ex) {
            Logger.getLogger(InventoryDaoIMPL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void rejectInventory(ExInventoryDto inventoryDto) {

    }

}
