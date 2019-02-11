/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archjunchaupari.Services.Staff;

import archjunchaupari.Model.Staff.StaffDto;
import archjunchaupari.Staff.StaffDAO.StaffDao;
import archjunchaupari.Staff.StaffDAO.StaffDaoIMPL;
import java.util.List;

/**
 *
 * @author cri
 */
public class StaffService implements StaffDaoService {

    private final StaffDao staffDaoIMPL;

    public StaffService() {
        staffDaoIMPL = new StaffDaoIMPL();
    }

    @Override
    public void saveStaff(StaffDto staffDto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<StaffDto> getStaffList() {
        return staffDaoIMPL.getStaffList();
    }

}
