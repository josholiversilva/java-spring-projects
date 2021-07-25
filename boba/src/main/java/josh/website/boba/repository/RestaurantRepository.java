package josh.website.boba.repository;

import josh.website.boba.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {
    @Query("SELECT COUNT(id) FROM Restaurant WHERE name= ?1")
    Integer getRestaurantVisits(String name);
}
