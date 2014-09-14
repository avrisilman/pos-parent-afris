package gan.cloud.co.id.repository;

import gan.cloud.co.id.models.Barang;

import java.util.List;

/**
 * Created by SUFI on 8/28/14.
 */
public interface BarangService {
    public void insert(Barang barang);
    public List<Barang> findAll();
}
