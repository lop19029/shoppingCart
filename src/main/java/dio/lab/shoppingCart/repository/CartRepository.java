package dio.lab.shoppingCart.repository;

import dio.lab.shoppingCart.model.Cart;
import org.springframework.data.repository.CrudRepository;

public interface CartRepository extends CrudRepository<Cart, Integer> {
}
