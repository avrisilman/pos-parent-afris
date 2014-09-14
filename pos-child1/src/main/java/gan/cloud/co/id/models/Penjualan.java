package gan.cloud.co.id.models;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by SUFI on 9/4/14.
 */
@Entity
@Table(name = "tn_penjualan")
public class Penjualan {
    @Id
    @Column(name = "no_penjualan", length = 15)
    private String noPenjualan;
    @Column(name = "tanggal_penjualan")
    private Date tanggalPenjualan;
    @Column (name = "pembayaran")
    private Double pembayaran;
    @Column (name = "status")
    private boolean status;

    @OneToMany( fetch = FetchType.LAZY, cascade =
            {CascadeType.PERSIST , CascadeType.MERGE },
    mappedBy = "penjualan", orphanRemoval = true)
    @Column(name = "penjualan", nullable = false)
    private Set <PenjualanBarang>penjualanBarangs= new HashSet<PenjualanBarang>();

    public Set<PenjualanBarang> getPenjualanBarangs() {
        return penjualanBarangs;
    }

    public void setPenjualanBarangs(Set<PenjualanBarang> penjualanBarangs) {
        this.penjualanBarangs = penjualanBarangs;
    }

    public String getNoPenjualan() {
        return noPenjualan;
    }

    public void setNoPenjualan(String noPenjualan) {
        this.noPenjualan = noPenjualan;
    }

    public Date getTanggalPenjualan() {
        return tanggalPenjualan;
    }

    public void setTanggalPenjualan(Date tanggalPenjualan) {
        this.tanggalPenjualan = tanggalPenjualan;
    }

    public Double getPembayaran() {
        return pembayaran;
    }

    public void setPembayaran(Double pembayaran) {
        this.pembayaran = pembayaran;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
