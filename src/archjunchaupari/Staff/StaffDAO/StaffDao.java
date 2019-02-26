/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archjunchaupari.Staff.StaffDAO;

import archjunchaupari.Model.Staff.StaffDto;
import java.util.List;

/**
 *
 * @author cri
 */
public interface StaffDao {

    void saveStaff(StaffDto staffDto);

    List<StaffDto> getStaffList();
    
    void deleteStaff(int id);
}
