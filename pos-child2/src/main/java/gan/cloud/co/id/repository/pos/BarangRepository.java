package gan.cloud.co.id.repository.pos;

import gan.cloud.co.id.models.Barang;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by SUFI on 9/13/14.
 */
/*pemanggilan object */
public interface BarangRepository extends PagingAndSortingRepository<Barang, String> {

}
