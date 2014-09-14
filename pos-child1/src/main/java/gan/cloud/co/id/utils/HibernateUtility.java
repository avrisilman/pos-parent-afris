package gan.cloud.co.id.utils;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
/**
 * Created by SUFI on 8/31/14.
 */
public class HibernateUtility {
    private SessionFactory sessionFactory; //untuk enghubungkan databasenya
    //1. bisa mengkonfigurasi HibernateConfiguration
   // 2.kamu membuat entityModel untuk di mapping ke database
    public SessionFactory getSessionFactory() {
        try {
            Configuration configuration = new Configuration().configure();  //manggil configurasi pada hibernate.cfg.xml
            StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties());  // manggil semua factory uyang ada di hibernate.cfg.xml
            SessionFactory factory = configuration.buildSessionFactory(builder.build());
            return factory;
        } catch (Throwable ex) {
            System.err.println("Gagal Membuat Session Factory" + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
