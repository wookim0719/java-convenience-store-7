package store;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        GetDataFromFile data = new GetDataFromFile();
        Promotion.setPromotionFeature(data.getPromotionInfo());
        ProductList list = new ProductList(data.getProductsInfo());
        OutputVIew view = new OutputVIew();
        view.printProduct(list);
    }
}
