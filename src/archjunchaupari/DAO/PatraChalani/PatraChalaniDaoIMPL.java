/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archjunchaupari.DAO.PatraChalani;

import archjunchaupari.DAO.Inventory.InventoryDaoIMPL;
import archjunchaupari.DAO.Login.LoginDaoIMPL;
import archjunchaupari.Model.Darta.DartaDto;
import archjunchaupari.Model.PatraChalani.PatraChalaniDto;
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
public class PatraChalaniDaoIMPL implements PatraChalaniDao {

    int statusCode;

    @Override
    public void savePatraChalani(PatraChalaniDto patraChalaniDto) {
        try {
            CloseableHttpClient client = HttpClients.createDefault();
            HttpPost httpPost = new HttpPost(RestUrl.SAVE_PATRA_CHALANI);
            Gson gson = new Gson();
            String json = gson.toJson(patraChalaniDto);
            StringEntity entity = new StringEntity(json);
            httpPost.setEntity(entity);
            httpPost.setHeader("Accept", "application/json");
            httpPost.setHeader("Content-type", "application/json");
            httpPost.addHeader("Authorization", "JWT " + LoginDaoIMPL.token);
            CloseableHttpResponse response = client.execute(httpPost);
            client.close();
            statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == 201 || statusCode == 401 || statusCode == 200 || statusCode == 204) {
                JOptionPane.showMessageDialog(null, "Patra Chalani Information Saved");
            }
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(PatraChalaniDaoIMPL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PatraChalaniDaoIMPL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<PatraChalaniDto> getPatraChalaniList() {
        List<PatraChalaniDto> patraList = new ArrayList<>();
        try {
            HttpClient client = HttpClientBuilder.create().build();
            HttpGet request = new HttpGet(RestUrl.GET_PATRA_CHALANI);
            request.setHeader("Accept", "application/json");
            request.setHeader("Content-type", "application/json");
            request.addHeader("Authorization", "JWT " + LoginDaoIMPL.token);
            HttpResponse response = client.execute(request);
            BufferedReader bufReader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            int statusCode = response.getStatusLine().getStatusCode();
            Gson gson = new Gson();
            Type PatraChalaniDto = new TypeToken<ArrayList<PatraChalaniDto>>() {
            }.getType();
            patraList = new Gson().fromJson(bufReader, PatraChalaniDto);
        } catch (IOException ex) {
            Logger.getLogger(InventoryDaoIMPL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return patraList;
    }

    @Override
    public void deletePatraChalani(int id) {
        try {
            CloseableHttpClient client = HttpClients.createDefault();
            HttpDelete httpDelete = new HttpDelete(RestUrl.DELTE_CHALANI + id + "/");
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
    public void updatePatraChalani(PatraChalaniDto patraChalaniDto) {
        try {
            CloseableHttpClient client = HttpClients.createDefault();
            Gson gson = new Gson();
            String json = gson.toJson(patraChalaniDto);
            StringEntity entity = new StringEntity(json);
            HttpPut httpPut = new HttpPut(RestUrl.UPDATE_CHALANI + patraChalaniDto.getId() + "/");
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
