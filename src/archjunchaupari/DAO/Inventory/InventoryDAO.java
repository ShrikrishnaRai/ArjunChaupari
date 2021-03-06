/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archjunchaupari.DAO.Inventory;

import archjunchaupari.Model.Inventory.ExInventoryDto;
import java.util.List;

/**
 *
 * @author cri
 */
public interface InventoryDAO {

    void saveInventory(ExInventoryDto inventoryDto);

    List<ExInventoryDto> getInventory();
    
    List<ExInventoryDto> getInventoryType(String type);

    void deleteInventory(int id);

    void updateInventory(ExInventoryDto exInventoryDto);

}
