package lr.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import lr.demo.models.Coin;

@Repository
public interface CoinRep extends CrudRepository<Coin, Long> {

}
