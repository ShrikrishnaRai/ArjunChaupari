/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archjunchaupari.Inventory.InventoryDAO;

import archjunchaupari.Model.Inventory.ExInventoryDto;
import java.util.List;

/**
 *
 * @author cri
 */
public interface InventoryDAO {

    void saveInventory(ExInventoryDto inventoryDto);

    List<ExInventoryDto> getInventory();

    void deleteInventory(int id);

    void updateInventory(int id);

}
