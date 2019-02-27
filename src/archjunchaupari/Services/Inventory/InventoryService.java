/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archjunchaupari.Services.Inventory;

import archjunchaupari.DAO.Inventory.InventoryDAO;
import archjunchaupari.DAO.Inventory.InventoryDaoIMPL;
import archjunchaupari.Model.Inventory.ExInventoryDto;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author cri
 */
public class InventoryService implements InventoryDaoService {

    InventoryDAO inventoryDao = new InventoryDaoIMPL();
    InventoryDaoIMPL in = new InventoryDaoIMPL();

    @Override
    public void saveInventory(ExInventoryDto inventoryDto) {
        in.saveInventory(inventoryDto);
    }

    @Override
    public List<ExInventoryDto> getInventory() {
        //return inventoryDao.getInventory();
        return in.getInventory();
    }

    public void check() {
        JOptionPane.showMessageDialog(null, "Hello");
    }

    @Override
    public void deleteInventory(int id) {
        in.deleteInventory(id);
    }

    @Override
    public List<ExInventoryDto> getSearchInventory(String inventory) {
        return in.getSearchedInventory(inventory);
    }

    @Override
    public void updateInventory(ExInventoryDto inventoryDto) {
        in.updateInventory(inventoryDto);
    }
}
