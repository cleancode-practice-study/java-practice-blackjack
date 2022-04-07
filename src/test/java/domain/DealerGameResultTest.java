package domain;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class DealerGameResultTest {
    @Test
    public void 딜러_게임_결과_확인() {
        Map<GameResultType, Integer> gameResult = new HashMap<>();

        gameResult.put(GameResultType.WIN,
                gameResult.getOrDefault(GameResultType.WIN, 0) + 1);

        gameResult.put(GameResultType.WIN,
                gameResult.getOrDefault(GameResultType.WIN, 0) + 1);

        DealerGameResult dealerGameResult = new DealerGameResult(gameResult);

        assertThat(dealerGameResult.getResultForPrint()).contains("2승");
    }
}
