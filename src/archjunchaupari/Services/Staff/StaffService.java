/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archjunchaupari.Services.Staff;

import archjunchaupari.Model.Staff.StaffDto;
import archjunchaupari.DAO.Staff.StaffDao;
import archjunchaupari.DAO.Staff.StaffDaoIMPL;
import java.util.List;

/**
 *
 * @author cri
 */
public class StaffService implements StaffDaoService {

    private final StaffDao staffDaoIMPL;
    StaffDaoIMPL staffDaoIMPLl=new StaffDaoIMPL();

    public StaffService() {
        staffDaoIMPL = new StaffDaoIMPL();
    }

    @Override
    public void saveStaff(StaffDto staffDto) {
        staffDaoIMPLl.saveStaff(staffDto);
    }

    @Override
    public List<StaffDto> getStaffList() {
        return staffDaoIMPL.getStaffList();
    }

    @Override
    public void deleteStaff(int id) {
        staffDaoIMPL.deleteStaff(id);
    }

    @Override
    public void updateStaff(StaffDto staffDto) {
        staffDaoIMPL.updateStaff(staffDto);
    }
    
}
