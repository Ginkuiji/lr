package lr.demo.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import lr.demo.models.Portfolio;
import lr.demo.models.Trend;
import lr.demo.models.Coin;
@Repository
public interface PortfolioRep extends CrudRepository<Portfolio, Long> {
}
