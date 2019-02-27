/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archjunchaupari.DAO.PatraChalani;

import archjunchaupari.Model.PatraChalani.PatraChalaniDto;
import java.util.List;

/**
 *
 * @author cri
 */
public interface PatraChalaniDao {

    void savePatraChalani(PatraChalaniDto patraChalaniDto);

    List<PatraChalaniDto> getPatraChalaniList();

    void deletePatraChalani(int id);
    
    void updatePatraChalani(PatraChalaniDto patraChalaniDto);
}
