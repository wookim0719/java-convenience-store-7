package store;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;

public class ProductList {
    LinkedHashMap<String, Product> products = new LinkedHashMap<>();

    public ProductList(List<String> productList) {
        initProducts(productList);
    }

    private void addProductToProducts(String[] productInfo) {
        String name = productInfo[0];
        int price = Integer.parseInt(productInfo[1]);
        int quantity = Integer.parseInt(productInfo[2]);
        String promotion = productInfo[3];
        if (isExist(name)) {
            modifyProduct(name, promotion, quantity, price);
        }
        if (!isExist(name)) {
            addNewProduct(name, promotion, quantity, price);
        }
    }

    private void initProducts(List<String> productList) {
        for (String rawProduct : productList) {
            String[] productInfo = rawProduct.split(",");
            addProductToProducts(productInfo);
        }
    }

    private boolean isExist(String name) {
        if (products.containsKey(name)) {
            return true;
        }
        return false;
    }

    private void addNewProduct(String name, String promotion, int quantity, int price) {
        Product product;
        if (!Objects.equals(promotion, "null")) {
            product = new Product(name, quantity, price, promotion);
        } else {
            product = new Product(name, quantity, price);
        }
        this.products.put(name, product);
    }

    private void modifyProduct(String name, String promotion, int quantity, int price) {
        Product product = products.get(name);
        if (Objects.equals(promotion, "null"))
            product.addQuantity(quantity);
        if (!Objects.equals(promotion, "null")) {
            product.promotion = Promotion.findByName(promotion);
            product.addEventQuantity(quantity);
            this.products.put(name, product);
        }
    }
}
