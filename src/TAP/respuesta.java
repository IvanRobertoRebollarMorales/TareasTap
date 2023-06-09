/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Daniel Ochoa
 */
public class respuesta {

    private int iID;
    private String sSistem;
    private String sProgra;
    private String sDisen;
    private String sAdmon;
    private int iHoras;

    public respuesta(int iID, String sSistem, String sProgra, String sDisen, String sAdmon, int iHoras) {
        this.iID = iID;
        this.sSistem = sSistem;
        this.sProgra = sProgra;
        this.sDisen = sDisen;
        this.sAdmon = sAdmon;
        this.iHoras = iHoras;
    }

    public int getiID() {
        return iID;
    }

    public String getsSistem() {
        return sSistem;
    }

    public String getsProgra() {
        return sProgra;
    }

    public String getsDisen() {
        return sDisen;
    }

    public String getsAdmon() {
        return sAdmon;
    }

    public int getiHoras() {
        return iHoras;
    }

}
