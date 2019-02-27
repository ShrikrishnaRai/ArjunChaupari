/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archjunchaupari.DAO.BranchAdmin;

import archjunchaupari.Model.Inventory.ExInventoryDto;

/**
 *
 * @author shree
 */
public interface BranchAdminDao {

    void allowInventory(ExInventoryDto inventoryDto);
}
