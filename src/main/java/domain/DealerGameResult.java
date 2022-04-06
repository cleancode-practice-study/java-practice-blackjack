package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DealerGameResult {
    Map<GameResultType, Integer> gameResult;

    public DealerGameResult (Map<GameResultType, Integer> gameResult) {
        this.gameResult = gameResult;
    }

    public List<String> getResultForPrint() {
        List<String> resultForPrint = new ArrayList<>();
        if (gameResult.containsKey(GameResultType.WIN)) {
            resultForPrint.add(gameResult.get(GameResultType.WIN) + GameResultType.WIN.getCardType());
        }

        if (gameResult.containsKey(GameResultType.LOSE)) {
            resultForPrint.add(gameResult.get(GameResultType.LOSE) + GameResultType.LOSE.getCardType());
        }

        if (gameResult.containsKey(GameResultType.DRAW)) {
            resultForPrint.add(gameResult.get(GameResultType.DRAW) + GameResultType.DRAW.getCardType());
        }

        return resultForPrint;
    }
}
