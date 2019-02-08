/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archjunchaupari.Darta.DartaDao;

import archjunchaupari.Model.Darta.DartaDto;
import java.util.List;

/**
 *
 * @author cri
 */
public interface DartaDAO {

    void saveDarta(DartaDto dartaDto);

    List<DartaDto> getDartaList();

}
