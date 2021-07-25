package josh.website.boba.repository;

import josh.website.boba.model.Drink;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DrinkRepository extends JpaRepository<Drink, Integer> {
}
