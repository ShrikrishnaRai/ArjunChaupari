/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archjunchaupari.Utils;

/**
 *
 * @author cri
 */
public class RestUrl {

    public static String ACCESS_TOKEN = "http://aavash.pythonanywhere.com/api/get-token/";
    public static String SAVE_INVENTORY = "http://aavash.pythonanywhere.com/api/v1/inventory/expendable-item/";
    public static String GET_INVENTORY = "http://aavash.pythonanywhere.com/api/v1/inventory/expendable-item/";
    //requires id 
    public static String DELTE_INVENTORY="http://aavash.pythonanywhere.com/api/v1/inventory/expendable-item/";
    public static String SEARCH_INVENTORY="http://aavash.pythonanywhere.com/api/v1/inventory/expendable-item/?search=";
    public static String GET_DARTA = "http://aavash.pythonanywhere.com/api/v1/inventory/patra-darta/";
    public static String GET_PATRA_CHALANI = "http://aavash.pythonanywhere.com/api/v1/inventory/patra-chalani/";
}
