package gan.cloud.co.id;

import com.sun.org.apache.xpath.internal.SourceTree;
import gan.cloud.co.id.models.Barang;
import gan.cloud.co.id.repository.BarangService;
import gan.cloud.co.id.repository.implement.BarangServiceImpl;
import gan.cloud.co.id.utils.HibernateUtility;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;


import java.util.List;
//sudah bisa transaction update dan delete
//sudah tau tentang hibernate query language
/**
 * Created by SUFI on 8/28/14.
 */
public class BarangRepositoryTest {
    private HibernateUtility hibernateUtil = new HibernateUtility();
    private Session session = hibernateUtil.getSessionFactory().openSession();    // manggil getSessionFactory() di HibernateUtility.
    private Transaction transaction = session.beginTransaction();
    private BarangService barangService = new BarangServiceImpl();

    @Test
    public  void findAll(){
     List<Barang> barangs = barangService.findAll();

        System.out.println("Jumlah Barang : "+barangs.size());
        barangs.remove(1);
        for(Barang b : barangs){
            System.out.println(b);
        }
    }
    @Test
    public void testSave(){
        Barang barang = new Barang();
        barang.setCodeBarang("C-006");
        barang.setNamaBarang("New Era Baru");
        barang.setHargaBeli(300000D);
        double profit =10/1000;
        barang.setHargaJual((barang.getHargaBeli()*profit)+barang.getHargaBeli());
        barang.setQuantity(20);
      /* List<Barang>  barangs= (List<Barang>) session.createQuery("from Barang ");
        barangs.size();*/
        session.save(barang); // session untuk save table barang
        transaction.commit(); //lalu di commit
        session.close(); // lalu di close
    }
    //hibernate query language
    @Test
    public void findAllBarang(){
        String queryString = "from Barang b where codeBarang like :codeBarang"; // (b) ALIAS VARIABEL
        Query query = session.createQuery(queryString);
        String  codeBarang="C-00";
        query.setParameter("codeBarang", codeBarang+"%");
        List<Barang> barangs = query.list();
        System.out.println("Jumlah Barang :"+barangs.size());
        for(Barang b : barangs){
            System.out.println(b);
        }
    }
    @Test
    public  void deleteBarang(){
        String codeBarang = "C-005";
        Barang barang = (Barang) session.load(Barang.class, codeBarang);
        System.out.println(barang);
        session.delete(barang);
        transaction.commit();
        session.close();
    }
    @Test
    public  void updateBarang(){
        String codeBarang = "C-003";
        Barang barang = (Barang) session.load(Barang.class, codeBarang);
        System.out.println(barang);
        barang.setNamaBarang("sepatu ku");
        session.update(barang);
        transaction.commit();
        session.close();
    }
}

