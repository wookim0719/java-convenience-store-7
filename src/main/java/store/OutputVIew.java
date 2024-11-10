package store;

import java.text.NumberFormat;

public class OutputVIew {


    public void printProduct(ProductList list) {
        for (String key : list.products.keySet()) {
            Product item = list.products.get(key);
            if (item.eventQuantity > 0) {
                System.out.println(makePromotionSentence(item));
            }
            String productInfo = makeGeneralSentence(item);
            System.out.println(productInfo);
        }
    }

    public String makeGeneralSentence(Product product) {
        String str = "- ";
        str += product.name + makeBlank();
        NumberFormat formatter = NumberFormat.getInstance();
        str += formatter.format(product.price) + "원" + makeBlank();
        if (product.quantity == 0) str += "재고 없음";
        if (product.quantity != 0)
            str += product.quantity + "개" + makeBlank();
        return str;
    }

    public String makePromotionSentence(Product product) {
        String str = "- ";
        str += product.name + makeBlank();
        NumberFormat formatter = NumberFormat.getInstance();
        str += formatter.format(product.price) + "원" + makeBlank();
        str += product.eventQuantity + "개" + makeBlank();
        str += product.promotion.getName() + makeBlank();
        return str;
    }

    public String makeBlank() {
        return " ";
    }
}
