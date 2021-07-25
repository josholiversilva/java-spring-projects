package josh.website.boba.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import josh.website.boba.model.Drink;
import josh.website.boba.model.Restaurant;
import josh.website.boba.repository.DrinkRepository;
import josh.website.boba.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.TypedQuery;
import java.util.List;

@Component
public class Query implements GraphQLQueryResolver {
    private DrinkRepository drinkRepository;
    private RestaurantRepository restaurantRepository;

    @Autowired
    public Query(DrinkRepository drinkRepository, RestaurantRepository restaurantRepository) {
        this.drinkRepository = drinkRepository;
        this.restaurantRepository = restaurantRepository;
    }

    // Drinks
    public List<Drink> findAllDrinks() {
        return this.drinkRepository.findAll();
    }

    public Drink findDrink(Integer id) {
        return this.drinkRepository.findById(id).orElse(null);
    }

    // Restaurants
    public List<Restaurant> findAllRestaurants() {
        return this.restaurantRepository.findAll();
    }

    public Integer getRestaurantVisits(String restaurant_name) {
        return restaurantRepository.getRestaurantVisits(restaurant_name);
    }
}
