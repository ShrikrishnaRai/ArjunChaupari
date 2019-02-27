/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archjunchaupari.DAO.Darta;

import archjunchaupari.DAO.Inventory.InventoryDaoIMPL;
import archjunchaupari.DAO.Login.LoginDaoIMPL;
import archjunchaupari.Model.Darta.DartaDto;
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
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;

/**
 *
 * @author cri
 */
public class DartaDaoIMPL implements DartaDAO {

    int statusCode;

    @Override
    public void saveDarta(DartaDto dartaDto) {
        try {
            CloseableHttpClient client = HttpClients.createDefault();
            HttpPost httpPost = new HttpPost(RestUrl.SAVE_DARTA);
            Gson gson = new Gson();
            String json = gson.toJson(dartaDto);
            StringEntity entity = new StringEntity(json);
            httpPost.setEntity(entity);
            httpPost.setHeader("Accept", "application/json");
            httpPost.setHeader("Content-type", "application/json");
            httpPost.addHeader("Authorization", "JWT " + LoginDaoIMPL.token);
            CloseableHttpResponse response = client.execute(httpPost);
            client.close();
            statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == 201) {
                JOptionPane.showMessageDialog(null, "Request Sent for Approval");
            } else {
                JOptionPane.showMessageDialog(null, "" + response);
            }
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(DartaDaoIMPL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DartaDaoIMPL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<DartaDto> getDartaList() {
        List<DartaDto> dartaList = new ArrayList<>();
        try {
            HttpClient client = HttpClientBuilder.create().build();
            HttpGet request = new HttpGet(RestUrl.GET_DARTA);
            request.setHeader("Accept", "application/json");
            request.setHeader("Content-type", "application/json");
            request.addHeader("Authorization", "JWT " + LoginDaoIMPL.token);
            HttpResponse response = client.execute(request);
            BufferedReader bufReader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            int statusCode = response.getStatusLine().getStatusCode();
            Gson gson = new Gson();
            Type dartaDto = new TypeToken<ArrayList<DartaDto>>() {
            }.getType();
            dartaList = new Gson().fromJson(bufReader, dartaDto);
        } catch (IOException ex) {
            Logger.getLogger(InventoryDaoIMPL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dartaList;
    }

}
