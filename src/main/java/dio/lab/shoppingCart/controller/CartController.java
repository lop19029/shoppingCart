package dio.lab.shoppingCart.controller;

import dio.lab.shoppingCart.model.Cart;
import dio.lab.shoppingCart.model.Item;
import dio.lab.shoppingCart.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartRepository cartRepository;

    //@PostMapping
    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public Cart addItem(@PathVariable("id") Integer id, @RequestBody Item item) {
        Optional<Cart> savedCart = cartRepository.findById(id);
        Cart cart;
        if (savedCart.equals(Optional.empty())) {
            cart = new Cart(id);
        }
        else {
            cart = savedCart.get();
        }
        cart.getItems().add(item);
        return  cartRepository.save(cart);
    }

    //@GetMapping
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Optional<Cart> findItemById(@PathVariable("id") Integer id) {
        return cartRepository.findById(id);
    }

    //@DeleteMapping
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteItem(@PathVariable("id") Integer id){ cartRepository.deleteById(id); }


}
