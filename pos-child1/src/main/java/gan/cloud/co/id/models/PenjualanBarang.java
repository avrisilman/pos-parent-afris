package gan.cloud.co.id.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by SUFI on 9/4/14.
 */
@Entity
@Table(name = "tn_penjualan_barang")
public class PenjualanBarang {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private  String id;
    //forign key ke barang dengan code_barang
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE},
            fetch = FetchType.LAZY)
    @JoinColumn(name = "code_barang", nullable = false)
    private Barang barang ;
    //forign key ke penjualan  dengan no_penjualan
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE},
            fetch = FetchType.LAZY)
    @JoinColumn(name = "no_penjualan", nullable = false)
    private Penjualan penjualan ;
    // akan tergenerate suatu foreign key ke penjualan

    @Column(name = "quantity")
    private int quantity;
    @Column(name = "tanggal_penjualan_barang")
    private Date tanggalPenjualan;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Barang getBarang() {
        return barang;
    }

    public void setBarang(Barang barang) {
        this.barang = barang;
    }

    public Penjualan getPenjualan() {
        return penjualan;
    }

    public void setPenjualan(Penjualan penjualan) {
        this.penjualan = penjualan;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getTanggalPenjualan() {
        return tanggalPenjualan;
    }

    public void setTanggalPenjualan(Date tanggalPenjualan) {
        this.tanggalPenjualan = tanggalPenjualan;
    }
}
