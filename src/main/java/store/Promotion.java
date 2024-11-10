package store;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;

import camp.nextstep.edu.missionutils.DateTimes;

public enum Promotion {
    탄산2_1,
    MD추천상품,
    반짝할인,
    NULL;
    private String name;
    private int buy;
    private int get;
    private LocalDate startDate;
    private LocalDate endDate;

    // 프로모션 특성을 설정하는 메서드
    public void setPromotionDetails(String name, int buy, int get, LocalDate startDate, LocalDate endDate) {
        this.name = name;
        this.buy = buy;
        this.get = get;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public static Promotion findByName(String name) {
        Promotion promotion = null;
        for (Promotion promotionValue : Promotion.values()) {
            String PromotionName = promotionValue.getName();
            if (Objects.equals(PromotionName, name)) {
                promotion = promotionValue;
            }
        }
        return promotion;
    }

    public static void setPromotionFeature(List<String> promotions) {
        for (String rawProduct : promotions) {
            String[] promotionFeature = rawProduct.split(",");
            String name = promotionFeature[0];
            int buy = Integer.parseInt(promotionFeature[1]);
            int get = Integer.parseInt(promotionFeature[2]);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate startDate = LocalDate.parse(promotionFeature[3], formatter);
            LocalDate endDate = LocalDate.parse(promotionFeature[4], formatter);
            String enumName = Promotion.convertToEnumName(name);
            if (enumName.equals("null")) enumName = "NULL";
            Promotion promotion = Promotion.valueOf(enumName);
            promotion.setPromotionDetails(name, buy, get, startDate, endDate);
        }
    }

    // 특성들을 가져오는 메서드
    public String getName() {
        return name;
    }

    public int getBuy() {
        return buy;
    }

    public int getGet() {
        return get;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    // "+"를 "_"로 바꾸는 메서드
    public static String convertToEnumName(String rawName) {
        return rawName.replace("+", "_");
    }
}