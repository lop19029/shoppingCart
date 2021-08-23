package dio.lab.shoppingCart.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.util.ArrayList;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@RedisHash("cart")
public class Cart {

    @Id
    private Integer id;
    private List<Item> items;

    public Cart (Integer id) {
        this.id = id;
    }

    public List<Item> getItems(){
        if (items == null) {
            items = new ArrayList<>();
        }
        return items;
    }

}
