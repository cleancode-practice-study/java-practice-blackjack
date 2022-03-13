package domain;

import java.util.ArrayList;
import java.util.List;

public class Convert {
    // 입력 받은 String, 쉼표 기준으로 String[] 반환 메서드
    public static String[] splitNames(String names) {
        return names.split(",");
    }

    // 콤마 포함 문자열 반환
    public static String getNamesWithComma(List<Player> users) {
        List<String> names = new ArrayList<>();

        for (Player user : users) {
            String userName = user.name;
            names.add(userName);
        }

        return String.join(", ", names);
    }
}
