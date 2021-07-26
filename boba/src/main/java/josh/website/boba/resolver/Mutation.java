package josh.website.boba.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import josh.website.boba.model.Drink;
import josh.website.boba.model.Restaurant;
import josh.website.boba.repository.DrinkRepository;
import josh.website.boba.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Mutation implements GraphQLMutationResolver {
    DrinkRepository drinkRepository;
    RestaurantRepository restaurantRepository;

    @Autowired
    public Mutation(DrinkRepository drinkRepository, RestaurantRepository restaurantRepository) {
        this.drinkRepository = drinkRepository;
        this.restaurantRepository = restaurantRepository;
    }

    // Drinks
    public Drink createDrink(String name, Integer sweetness, Float rating, Integer restaurant_id) {
        Drink drink = new Drink();

        drink.setName(name);
        drink.setSweetness(sweetness);
        drink.setRating(rating);
        drink.setRestaurant(new Restaurant(restaurant_id));
        drinkRepository.save(drink);

        return drink;
    }

    // Restaurants
    public Restaurant createRestaurant(String name, String location) {
        Restaurant restaurant = new Restaurant();

        restaurant.setName(name);
        restaurant.setLocation(location);

        restaurantRepository.save(restaurant);

        return restaurant;
    }
}
