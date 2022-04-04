package domain;

import demain.DealerGameResult;
import demain.GameResultType;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class DealerGameResultTest {
    @Test
    public void 딜러_게임_결과_확인() {
        Map<String, Integer> gameResult = new HashMap<>();

        gameResult.put(GameResultType.WIN.getCardType(),
                gameResult.getOrDefault(GameResultType.WIN.getCardType(), 0) + 1);

        gameResult.put(GameResultType.WIN.getCardType(),
                gameResult.getOrDefault(GameResultType.WIN.getCardType(), 0) + 1);

        DealerGameResult dealerGameResult = new DealerGameResult(gameResult);

        assertThat(dealerGameResult.getResultForPrint()).contains("2승");
    }
}
