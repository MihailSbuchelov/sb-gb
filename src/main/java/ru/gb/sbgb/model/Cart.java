package ru.gb.sbgb.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.gb.sbgb.entity.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

@Component
@Scope("prototype")
public class Cart implements Consumer<Product> {
    private final Map<Integer, Product> products = new HashMap<>();
    private final List<Integer> listId = new ArrayList<>();

    public void add(Product product) {
        if (!products.containsValue(product)) {
            products.put(product.getId(), product);
            listId.add(product.getId());
        }
        Product product1 = products.get(product.getId());
        product1.setCount(product1.getCount() + 1);
    }

    public void dellByProductId(Integer id) {
        Product p = products.get(id);
        if (p.getCount() == 1) {
            products.remove(id);
            listId.remove(id);
        } else {
            p.setCount(p.getCount() - 1);
        }
    }

    public String showProductList() {
        StringBuilder stringBuilder = new StringBuilder();

        for (Map.Entry<Integer, Product> pair : products.entrySet()) {
            stringBuilder.append("ID: " + pair.getValue().getId() + ", ")
                    .append("Title: " + pair.getValue().getTitle() + ", ")
                    .append("Cost: " + pair.getValue().getCost() + ", ")
                    .append("Count: " + pair.getValue().getCount() + "; <br>")
                    .append("________________<br>");
        }
        return stringBuilder.toString();
    }

    public List<Integer> getListIdProducts() {
        return listId;
    }

    @Override
    public void accept(Product product) {
        add(product);
    }
}
