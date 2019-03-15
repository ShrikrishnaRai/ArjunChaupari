/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archjunchaupari.Services.Admin;

import archjunchaupari.DAO.Admin.AdminDao;
import archjunchaupari.DAO.Admin.AdminDaoIMPL;
import archjunchaupari.Model.Inventory.ExInventoryDto;
import javax.swing.JOptionPane;

/**
 *
 * @author shree
 */
public class AdminService implements AdminDaoService {

    AdminDao adminDaoIMPL;

    public AdminService() {
        adminDaoIMPL = new AdminDaoIMPL();
    }

    @Override
    public void allowInventory(ExInventoryDto inventoryDto) {
        adminDaoIMPL.allowInventory(inventoryDto);
        JOptionPane.showMessageDialog(null, "Hello World");
    }

    @Override
    public void rejectInventory(ExInventoryDto inventoryDto) {
        adminDaoIMPL.rejectInventory(inventoryDto);
    }

}
