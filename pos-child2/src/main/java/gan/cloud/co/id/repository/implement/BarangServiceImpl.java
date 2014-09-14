package gan.cloud.co.id.repository.implement;

import gan.cloud.co.id.models.Barang;
import gan.cloud.co.id.repository.BarangService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SUFI on 8/28/14.
 */
public class BarangServiceImpl implements BarangService{
    @Override
    public void insert(Barang barang) {

    }

    @Override
    public List<Barang> findAll() {
        List<Barang> barangs = new ArrayList<Barang>();
        Barang barangSampo = new Barang();
        barangSampo.setCodeBarang("S-001");
        barangSampo.setNamaBarang("Sampo");
        barangSampo.setHargaBeli(2000D);
        double profit = 5/100d;
        barangSampo.setQuantity(30);
        barangSampo.setHargaJual((barangSampo.getHargaBeli()*profit)+barangSampo.getHargaBeli());
        Barang barangSabun = new Barang("S-002", "Sabun", 3000D, (3000*profit)+3000D, 100);
        barangs.add(barangSampo);
        barangs.add(barangSabun);
        return barangs;
    }
}