/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archjunchaupari.Services.PatraChalani;

import archjunchaupari.Model.PatraChalani.PatraChalaniDto;
import archjunchaupari.PatraChalani.PatraChalaniDao.PatraChalaniDao;
import archjunchaupari.PatraChalani.PatraChalaniDao.PatraChalaniDaoIMPL;
import java.util.List;

/**
 *
 * @author cri
 */
public class PatraChalaniService implements PatraChalaniDaoService {
//
//    PatraChalaniDao patraChalaniDao;
//
//    public PatraChalaniService() {
//        patraChalaniDao = new PatraChalaniDaoIMPL();
//    }

    PatraChalaniDaoIMPL patraChalaniDao = new PatraChalaniDaoIMPL();

    @Override
    public List<PatraChalaniDto> getPatraChalaniList() {
        return patraChalaniDao.getPatraChalaniList();
    }

    @Override
    public void savePatraChalani(PatraChalaniDto patraChalaniDto) {
        patraChalaniDao.savePatraChalani(patraChalaniDto);
    }

}
