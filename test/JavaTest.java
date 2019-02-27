
import archjunchaupari.DAO.Inventory.InventoryDaoIMPL;
import archjunchaupari.Model.Darta.DartaDto;
import archjunchaupari.Model.Inventory.ExInventoryDto;
import archjunchaupari.Utils.RestUrl;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author cri
 */
public class JavaTest {

//    @Test
//    public void check() {
//        List<DartaDto> dartaList = new ArrayList<>();
//        try {
//            HttpClient client = HttpClientBuilder.create().build();
//            HttpGet request = new HttpGet(RestUrl.GET_DARTA);
//            HttpResponse response = client.execute(request);
//            BufferedReader bufReader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
//            int statusCode = response.getStatusLine().getStatusCode();
//            Gson gson = new Gson();
//            Type dartaDto = new TypeToken<ArrayList<DartaDto>>() {
//            }.getType();
//            dartaList = new Gson().fromJson(bufReader, dartaDto);
//            for (int i = 0; i < dartaList.size(); i++) {
//                System.out.println(dartaList.get(i).getDarta_date());
//            }
//        } catch (IOException ex) {
//            Logger.getLogger(InventoryDaoIMPL.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//    
//    @Test
//    public void checkInventory(){
//        
//    }
//    @Test
//    public void gitCheck() {
//        String url = "https://api.github.com/users";
//        List<Users> dartaList = new ArrayList<>();
//        try {
//            HttpClient client = HttpClientBuilder.create().build();
//            HttpGet request = new HttpGet(url);
//            HttpResponse response = client.execute(request);
//            BufferedReader bufReader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
//            int statusCode = response.getStatusLine().getStatusCode();
//            Gson gson = new Gson();
//            Type dartaDto = new TypeToken<ArrayList<Users>>() {
//            }.getType();
//            dartaList = new Gson().fromJson(bufReader, dartaDto);
//            for (int i = 0; i < dartaList.size(); i++) {
//                System.out.println(dartaList.get(i).getEvents_url());
//            }
//        } catch (IOException ex) {
//            Logger.getLogger(InventoryDaoIMPL.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//    }
    @Test
    public void inventoryCheck() {
        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VyX2lkIjoxLCJ1c2VybmFtZSI6InVzZXJAdXNlci5jb20iLCJleHAiOjE1NTAwNDM1ODIsImVtYWlsIjoidXNlckB1c2VyLmNvbSJ9.b_RDI2gKec9o-TNLOnwXg5_W5zyfm2oGAB9IKOWYEPo";
        List<ExInventoryDto> inventoryDtoList = new ArrayList<>();
        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(RestUrl.GET_INVENTORY);
        request.setHeader("Accept", "application/json");
        request.setHeader("Content-type", "application/json");
        request.addHeader("Authorization", "JWT " + token);
        /* httpDelete.setHeader("Accept", "application/json");
            httpDelete.setHeader("Content-type", "application/json");
            httpDelete.addHeader("Authorization", "JWT " + LoginDaoIMPL.token);*/
        try {
            HttpResponse response = client.execute(request);
            BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            int statusCode = response.getStatusLine().getStatusCode();
            Gson gson = new Gson();
            Type inv = new TypeToken<ArrayList<ExInventoryDto>>() {
            }.getType();
            inventoryDtoList = new Gson().fromJson(reader, inv);
            for (int i = 0; i < inventoryDtoList.size(); i++) {
                System.out.println(inventoryDtoList.get(i).getName());
            }
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
}
