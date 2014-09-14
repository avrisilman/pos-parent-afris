package gan.cloud.co.id.spring;

import gan.cloud.co.id.models.Barang;
import gan.cloud.co.id.repository.pos.BarangRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by SUFI on 9/13/14.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:META-INF.spring/applicationContext.xml")
@ActiveProfiles({"repository", "LOC"})
public class BarangRepositoryTest {

    @Autowired  /**/
    private BarangRepository barangRepository;

    @Test
    public void testBarang() {
        Barang barang = new Barang();
        barang.setCodeBarang("C-007");
        barang.setNamaBarang("NIKE");
        barang.setHargaBeli(300000D);
        double profit = 10 / 1000;
        barang.setHargaJual((barang.getHargaBeli() * profit) + barang.getHargaBeli());
        barang.setQuantity(20);
        barangRepository.save(barang);
    }
    public void findAll(){
        /*barangRepository.findAll();*/
        String query="select " +
                "code_barang," +
                "harga_beli," +
                "harga_jual," +
                "nama_barang," +
                "quantity,";
    }
}
