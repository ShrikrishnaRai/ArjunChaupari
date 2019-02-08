/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archjunchaupari.Services.Darta;

import archjunchaupari.Darta.DartaDao.DartaDAO;
import archjunchaupari.Darta.DartaDao.DartaDaoIMPL;
import archjunchaupari.Model.Darta.DartaDto;
import java.util.List;

/**
 *
 * @author cri
 */
public class DartaServices implements DartaServiceDao {

    private final DartaDAO dartaDao;

    //daratDao initialization with implementation
    public DartaServices() {
        this.dartaDao = new DartaDaoIMPL();
    }

    @Override
    public void saveDarta(DartaDto dartaDto) {
        dartaDao.saveDarta(dartaDto);
    }

    @Override
    public List<DartaDto> getDarta() {
        return dartaDao.getDartaList();
    }

}
