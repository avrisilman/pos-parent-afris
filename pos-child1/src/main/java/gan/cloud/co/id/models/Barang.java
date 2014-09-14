package gan.cloud.co.id.models;

import javax.persistence.*;

/**
     * Created by SUFI on 8/28/14.
 */
@Entity
@Table(name = "tn_barang")
public class Barang {

    @Id
    @Column(name = "code_barang", length = 20) //maximum huruf/angka 20
    private String codeBarang;
    @Column(name = "nama_barang", length = 50, unique = true, nullable = false)//unique (nama tidak boleh sama)
    private String namaBarang;
    @Column(name = "harga_beli", nullable = false)
    private Double hargaBeli;  //untuk angka yang ada komanya
    @Column(name = "harga_jual", nullable = false)
    private Double hargaJual;
    @Column(name = "quantity", nullable = false)
    private int quantity;

    public Barang() {
    }

    public Barang(String codeBarang, String namaBarang, Double hargaBeli, Double hargaJual, int quantity) {
        this.codeBarang = codeBarang;
        this.namaBarang = namaBarang;
        this.hargaBeli = hargaBeli;
        this.hargaJual = hargaJual;
        this.quantity = quantity;
    }

    public String getCodeBarang() {
        return codeBarang;
    }

    public void setCodeBarang(String codeBarang) {
        this.codeBarang = codeBarang;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    public Double getHargaBeli() {
        return hargaBeli;
    }

    public void setHargaBeli(Double hargaBeli) {
        this.hargaBeli = hargaBeli;
    }

    public Double getHargaJual() {
        return hargaJual;
    }

    public void setHargaJual(Double hargaJual) {
        this.hargaJual = hargaJual;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Barang{" +
                "codeBarang='" + codeBarang + '\'' +
                ", namaBarang='" + namaBarang + '\'' +
                ", hargaBeli=" + hargaBeli +
                ", hargaJual=" + hargaJual +
                ", quantity=" + quantity +
                '}';
    }
}
