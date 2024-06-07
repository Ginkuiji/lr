package lr.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import lr.demo.models.Coin;
import lr.demo.models.Deal;

@Repository
public interface DealRep extends CrudRepository<Deal, Long> {
}
