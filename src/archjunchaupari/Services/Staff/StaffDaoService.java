/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archjunchaupari.Services.Staff;

import archjunchaupari.Model.Inventory.ExInventoryDto;
import archjunchaupari.Model.Staff.StaffDto;
import java.util.List;

/**
 *
 * @author cri
 */
public interface StaffDaoService {

    void saveStaff(StaffDto staffDto);

    List<StaffDto> getStaffList();

    void deleteStaff(int id);

    void updateStaff(StaffDto staffDto);

    List<StaffDto> getStaffSearchList(String name);

    List<ExInventoryDto> getSearchInventory(String name);
}
