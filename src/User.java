public class User {
    private String nama;
    private String email;
    private String alamat;
    private String noTelepon;

    public User(String nama) {
        this.nama = nama;
        this.email = email;
        this.alamat = alamat;
        this.noTelepon = noTelepon;
    }

    // Getter dan Setter

    public User() {
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNoTelepon() {
        return noTelepon;
    }

    public void setNoTelepon(String noTelepon) {
        this.noTelepon = noTelepon;
    }
}
