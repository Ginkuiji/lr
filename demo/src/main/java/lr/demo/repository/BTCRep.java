package lr.demo.repository;

import lr.demo.models.BTC;
import org.springframework.data.repository.CrudRepository;
public interface BTCRep extends CrudRepository<BTC, Long> {
}
