/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archjunchaupari.Services.User;

import archjunchaupari.DAO.User.UserDao;
import archjunchaupari.DAO.User.UserDaoIMPL;
import archjunchaupari.Model.User.UserDto;

/**
 *
 * @author shree
 */
public class UserService implements UserServiceDao {

    private UserDao userDao;

    public UserService() {
        userDao = new UserDaoIMPL();
    }

    @Override
    public void saveUser(UserDto userDto) {
        userDao.saveUser(userDto);
    }

}
