package domain;

import java.util.List;

public class Validator {
    // 딜러와 플레이어의 카드 숫자 합 비교
    public static int compareDealerAndUser(Player dealer, List<Player> users) {
        int winCount = 0;

        if (dealer.getCardTotalSum() <= 21 && dealer.getCardTotalSum() > users.get(0).getCardTotalSum()) {

            winCount++;
        }

        if (dealer.getCardTotalSum() <= 21 && dealer.getCardTotalSum() > users.get(1).getCardTotalSum()) {
            winCount++;
        }

        return winCount;
    }
}
