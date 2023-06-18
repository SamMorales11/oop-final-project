public class Mobil {
    private String merk;
    private String nomorPlat;
    private String tahun;

    public Mobil(String merk, String nomorPlat, String tahun) {
        this.merk = merk;
        this.nomorPlat = nomorPlat;
        this.tahun = tahun;
    }

    // Getter dan Setter

    public String getMerk() {
        return merk;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }

    public String getNomorPlat() {
        return nomorPlat;
    }

    public void setNomorPlat(String nomorPlat) {
        this.nomorPlat = nomorPlat;
    }

    public String getTahun() {
        return tahun;
    }

    public void setTahun(String tahun) {
        this.tahun = tahun;
    }
}
