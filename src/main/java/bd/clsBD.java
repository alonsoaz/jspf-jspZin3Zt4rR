package bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class clsBD {
    String _IP="localhost", _PORT="3306", _USER="root", _PASSWORD="", _BD="", _SQL="";
    Connection cn = null;
    PreparedStatement ps = null;
    
    public clsBD( String _BD ) {
        this._BD = _BD;
        getConnection();
    }

    public clsBD( String _IP, String _PORT, String _BD ) {
        this._IP = _IP;
        this._PORT = _PORT;
        this._BD = _BD;
    }
    
    private void getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cn = DriverManager.getConnection( "jdbc:mysql://" + _IP  + ":" + _PORT  + "/" + _BD, _USER, _PASSWORD );
        } catch ( ClassNotFoundException | SQLException  ex ) {  System.out.println( ex.getMessage() ); } 

    }
    
    public void SentenciaSQL( String _SQL ) {
        this._SQL = _SQL;
    }

    public String[][] getRegistros() {
        String[][] mRegistros = null;
        
        try {
            ps = cn.prepareStatement( _SQL );
            ResultSet rs = ps.executeQuery();
            int Columnas = rs.getMetaData().getColumnCount();
            int fila = -1;
            if ( rs.last() )
                mRegistros = new String[ rs.getRow() ] [ Columnas ];
            rs.beforeFirst();
            while ( rs.next() && ++fila > -1 ) 
                for ( int i=0; i < Columnas; i++ )
                    mRegistros[ fila ][ i ] = rs.getString( i + 1 ).trim();
            
            rs.close();
        } catch ( SQLException ex ) { System.out.println( ex.getMessage() ); }
        
        return mRegistros;
    }

    public String[] getRegistro() {
        String[] aRegistro = null;
        
        try {
            ps = cn.prepareStatement( _SQL );
            ResultSet rs = ps.executeQuery();
            aRegistro = new String[ rs.getMetaData().getColumnCount() ];
            if ( rs.next() )
                for ( int i=0; i < aRegistro.length; i++ )
                    aRegistro[ i ] = rs.getString( i + 1 ).trim();
            
            rs.close();
        } catch ( SQLException ex ) { System.out.println( ex.getMessage() ); }
        
        return aRegistro;
    }
    
}
