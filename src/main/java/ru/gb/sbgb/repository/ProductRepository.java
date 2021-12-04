package ru.gb.sbgb.repository;

import org.springframework.stereotype.Component;
import ru.gb.sbgb.entity.Product;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Component
public class ProductRepository {
    private final List<Product> products = new ArrayList<>();
    private final List<Integer> listIdAssortment = new ArrayList<>();

    @PostConstruct
    public void init() {
        products.add(new Product(0, "Bread", 345, 0));
        listIdAssortment.add(products.get(0).getId());
        products.add(new Product(1, "Water", 4444.3, 0));
        listIdAssortment.add(products.get(1).getId());
        products.add(new Product(2, "Orange", 3.0, 0));
        listIdAssortment.add(products.get(2).getId());
        products.add(new Product(3, "Milk", 345, 0));
        listIdAssortment.add(products.get(3).getId());
        products.add(new Product(4, "Banana", 345, 0));
        listIdAssortment.add(products.get(4).getId());
    }

    public List<Product> findAll() {
        return new ArrayList<>(products);
    }

    public Optional<Product> findById(Integer id) {

        if (id >= 0 && id < (products.size()))
            return Optional.of(products.get(id));
        else return Optional.empty();
    }

    public List<Integer> getListId() {
        return listIdAssortment;
    }

    public String showProducts() {
        StringBuilder stringBuilder = new StringBuilder();
        List<Product> products = this.findAll();
        for (Product p : products) {
            stringBuilder.append("ID: " + p.getId() + ", ")
                    .append("Title: " + p.getTitle() + ", ")
                    .append("Cost: " + p.getCost() + ";<br>")
                    .append("________________<br>");
        }
        return stringBuilder.toString();
    }
}
