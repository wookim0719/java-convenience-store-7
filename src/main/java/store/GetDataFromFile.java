package store;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class GetDataFromFile {
    String productFilePath = "src/main/resources/products.md";  // Path to the markdown file

    public GetDataFromFile() {
    }

    public List<String> getProductsInfo() {
        try {
            List<String> productData = Files.readAllLines(Paths.get(productFilePath));
            return productData;
        } catch (IOException e) {
            throw new IllegalArgumentException("파일을 불러 오지 못했습니다");
        }
    }

}


