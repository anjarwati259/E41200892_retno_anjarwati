package com.psi.tugas_psibaru;

public class dataPengguna {
    private String ID;
    private String NAMA;
    private String ALAMAT;
    private String TGLlahir;

    public dataPengguna() {
    }

    public dataPengguna(String ID, String NAMA, String ALAMAT, String TGLlahir) {
        this.ID = ID;
        this.NAMA = NAMA;
        this.ALAMAT = ALAMAT;
        this.TGLlahir = TGLlahir;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getNAMA() {
        return NAMA;
    }

    public void setNAMA(String NAMA) {
        this.NAMA = NAMA;
    }

    public String getALAMAT() {
        return ALAMAT;
    }

    public void setALAMAT(String ALAMAT) {
        this.ALAMAT = ALAMAT;
    }

    public String getTGLlahir() {
        return TGLlahir;
    }

    public void setTGLlahir(String TGLlahir) {
        this.TGLlahir = TGLlahir;
    }
}
