package ru.gb.sbgb.model;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.gb.sbgb.controller.ShopControllerImpl;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Random;

@RequiredArgsConstructor
@Component
@Scope("prototype")
public class Buyer {
    private final ShopControllerImpl shopController;

    @PostConstruct
    public void init() {
        shopController.enterToShop();
    }

    public void purchase() {
        Random random = new Random();
        int productNumber = random.nextInt(9) + 2;
        System.out.println("Buyer want's to buy " + productNumber + " products");

        for (int i = 0; i < productNumber; i++) {
            shopController.addProductFromRepoToCartById(random.nextInt(5));
        }
        shopController.deleteProductFromCartById(random.nextInt(5));
    }

    public String showCart() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder
                .append("<h2>Покупатель добавил в корзину следующие товары:</h2><br><br>")
                .append(shopController.getProductsCartForShow())
                .toString();
    }

    public List<Integer> listIdCart() {
        return shopController.getListIdCart();
    }
}
