/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author beto-
 */
public class LicenciadoVO {
    private int idLic;
    private String nombreLic;
    private String apPaLic;
    private String apMaLic;
    private String telOfi;
    private String hrsAten;

    public int getIdLic() {
        return idLic;
    }

    public void setIdLic(int idLic) {
        this.idLic = idLic;
    }

    public String getNombreLic() {
        return nombreLic;
    }

    public void setNombreLic(String nombreLic) {
        this.nombreLic = nombreLic;
    }

    public String getApPaLic() {
        return apPaLic;
    }

    public void setApPaLic(String apPaLic) {
        this.apPaLic = apPaLic;
    }

    public String getApMaLic() {
        return apMaLic;
    }

    public void setApMaLic(String apMaLic) {
        this.apMaLic = apMaLic;
    }

    public String getTelOfi() {
        return telOfi;
    }

    public void setTelOfi(String telOfi) {
        this.telOfi = telOfi;
    }

    public String getHrsAten() {
        return hrsAten;
    }

    public void setHrsAten(String hrsAten) {
        this.hrsAten = hrsAten;
    }
}
