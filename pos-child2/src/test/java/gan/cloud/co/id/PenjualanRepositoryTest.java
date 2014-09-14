package gan.cloud.co.id;

import gan.cloud.co.id.models.Barang;
import gan.cloud.co.id.models.Penjualan;
import gan.cloud.co.id.models.PenjualanBarang;
import gan.cloud.co.id.utils.HibernateUtility;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.annotations.SourceType;
import org.junit.Test;

import java.sql.SQLClientInfoException;
import java.util.*;

/**
 * Created by SUFI on 9/7/14.
 */
public class PenjualanRepositoryTest {
    private HibernateUtility hibernateUtil = new HibernateUtility();
    private Session session = hibernateUtil.getSessionFactory().openSession();    // manggil getSessionFactory() di HibernateUtility.
    private Transaction transaction = session.beginTransaction();

    @Test
    public void savePenjualan(){
        Barang barang1 = (Barang)session.load(Barang.class, "C-001");
        Barang barang2 = (Barang) session.load(Barang.class, "C-002");
        Barang barang3 = (Barang) session.load(Barang.class, "C-003");
        Barang barang4 = (Barang) session.load(Barang.class, "C-004");

        Penjualan penjualan = new Penjualan();
        penjualan.setNoPenjualan("1");
        penjualan.setTanggalPenjualan(new Date());
        penjualan.setStatus(true);
        Set<PenjualanBarang> penjualanBarangs = new HashSet<PenjualanBarang>();
        PenjualanBarang  penjualanBarang1= new PenjualanBarang();
        penjualanBarang1.setTanggalPenjualan(new Date());
        penjualanBarang1.setPenjualan(penjualan);
        penjualanBarang1.setBarang(barang1);
        penjualanBarang1.setQuantity(2);

        PenjualanBarang  penjualanBarang2= new PenjualanBarang();
        penjualanBarang2.setTanggalPenjualan(new Date());
        penjualanBarang2.setPenjualan(penjualan);
        penjualanBarang2.setBarang(barang2);
        penjualanBarang2.setQuantity(2);

        PenjualanBarang  penjualanBarang3= new PenjualanBarang();
        penjualanBarang3.setTanggalPenjualan(new Date());
        penjualanBarang3.setPenjualan(penjualan);
        penjualanBarang3.setBarang(barang3);
        penjualanBarang3.setQuantity(5);

        PenjualanBarang  penjualanBarang4= new PenjualanBarang();
        penjualanBarang4.setTanggalPenjualan(new Date());
        penjualanBarang4.setPenjualan(penjualan);
        penjualanBarang4.setBarang(barang4);
        penjualanBarang4.setQuantity(6);

        penjualanBarangs.add(penjualanBarang1);
        penjualanBarangs.add(penjualanBarang2);
        penjualanBarangs.add(penjualanBarang3);
        penjualanBarangs.add(penjualanBarang4);

        penjualan.setPenjualanBarangs(penjualanBarangs);
       // session.persist(penjualan); untuk create otomatis di childnya
        session.merge(penjualan); //otomatis untuk update beserta childnya
        transaction.commit();
        session.close();
    }

    @Test
    public void findTransaksi(){
        String query = "select \n" +
                "p.no_penjualan,\n" +
                "p.tanggal_penjualan,\n" +
                "b.nama_barang,\n" +
                "b.harga_jual,\n" +
                "pb.quantity,\n" +
                "sum(b.harga_jual * pb.quantity) as total\n" +
                "from tn_penjualan_barang pb join tn_penjualan p  on p.no_penjualan = pb.no_penjualan join tn_barang b on b.code_barang = pb.code_barang group by p.no_penjualan,\n" +
                "p.tanggal_penjualan,\n" +
                "b.nama_barang,\n" +
                "b.harga_jual,\n" +
                "pb.quantity ;";
        SQLQuery sqlQuery = session.createSQLQuery(query);
        sqlQuery.addEntity("pb",PenjualanBarang.class).addEntity("p",Penjualan.class).addEntity("b",Barang.class);
        /*List<PenjualanBarang> penjualanBarangs = (List<PenjualanBarang>)*/
       /* sqlQuery.addEntity(PenjualanBarang.class).list();*/
        List<Object> objects = sqlQuery.list();
        Iterator it = objects.iterator();
        while ((it.hasNext()))
        {
            Object p  =  (Object)it.hasNext();
            System.out.println(p);
        }
    }
    @Test
    public void findNativeQuery(){
        String query = "select * from tn_penjualan_barang";
        SQLQuery sqlQuery = session.createSQLQuery(query);
        sqlQuery.addEntity(PenjualanBarang.class);
        List<PenjualanBarang> penjualanBarangs = sqlQuery.list();

/*
        for(PenjualanBarang pb : penjualanBarangs){
            System.out.println(pb.getPenjualan().getNoPenjualan()
                    +"  "+pb.getBarang().getNamaBarang()
                    +"  "+pb.getBarang().getHargaJual()
                    +"  "+pb.getQuantity()
                    +"  "+pb.getBarang().getHargaJual()*pb.getQuantity());
        }
*/

        for(int index=0;index<penjualanBarangs.size();index++){
            System.out.println(penjualanBarangs.get(index).getPenjualan().getNoPenjualan()
                    +"  "+penjualanBarangs.get(index).getBarang().getNamaBarang()
                    +"  "+penjualanBarangs.get(index).getBarang().getHargaJual()
                    +"  "+penjualanBarangs.get(index).getQuantity()
                    +"  "+penjualanBarangs.get(index).getBarang().getHargaJual()*penjualanBarangs.get(index).getQuantity());
            if(index == 2){
                System.out.println("Berhenti");
                break;
            }
        }
    }

@Test
    public void saveArray(){
        String[] simpan = new String[3];
        simpan[0] = "satu";
        simpan[1] = "dua";
        simpan[2] = "tiga";
        for(String s :simpan){
            System.out.println("s = "+s);
        }
    }
}
