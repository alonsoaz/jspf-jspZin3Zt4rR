package dao;

import bd.clsBD;

public class daoCine {
    clsBD _clsBD = new clsBD("CineStar");
    
    public String[][] getVerCines() {
        _clsBD.SentenciaSQL( "call usp_getVerCines" );
        return _clsBD.getRegistros();
    }
    
}
