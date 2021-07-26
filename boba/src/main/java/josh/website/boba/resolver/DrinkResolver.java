package josh.website.boba.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import josh.website.boba.model.Drink;
import josh.website.boba.model.Restaurant;
import josh.website.boba.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DrinkResolver implements GraphQLResolver<DrinkResolver> {
    private RestaurantRepository restaurantRepository;

    @Autowired
    public DrinkResolver(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    public Restaurant getRestaurant(Drink drink) {
        return restaurantRepository.findById(drink.getRestaurant().getId()).orElseThrow(null);
    }
}
