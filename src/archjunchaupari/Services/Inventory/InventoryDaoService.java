/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archjunchaupari.Services.Inventory;

import archjunchaupari.Model.Inventory.ExInventoryDto;
import java.util.List;

/**
 *
 * @author cri
 */
public interface InventoryDaoService {

    void saveInventory(ExInventoryDto inventoryDto);

    List<ExInventoryDto> getInventory();
    
    void deleteInventory(int id);
    
    List<ExInventoryDto> getSearchInventory(String inventory);

}
