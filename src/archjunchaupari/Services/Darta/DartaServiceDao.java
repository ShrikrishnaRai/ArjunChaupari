/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archjunchaupari.Services.Darta;

import archjunchaupari.Model.Darta.DartaDto;
import java.util.List;

/**
 *
 * @author cri
 */
public interface DartaServiceDao {

    void saveDarta(DartaDto dartaDto);

    List<DartaDto> getDarta();
}
