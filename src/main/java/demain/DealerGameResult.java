package demain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DealerGameResult {
    Map<String, Integer> gameResult;

    public DealerGameResult (Map<String, Integer> gameResult) {
        this.gameResult = gameResult;
    }

    public List<String> getResultForPrint() {
        List<String> resultForPrint = new ArrayList<>();
        if (gameResult.containsKey(GameResultType.WIN.getCardType())) {
            resultForPrint.add(gameResult.get(GameResultType.WIN.getCardType()) + GameResultType.WIN.getCardType());
        }

        if (gameResult.containsKey(GameResultType.LOSE.getCardType())) {
            resultForPrint.add(gameResult.get(GameResultType.LOSE.getCardType()) + GameResultType.LOSE.getCardType());
        }

        if (gameResult.containsKey(GameResultType.DRAW.getCardType())) {
            resultForPrint.add(gameResult.get(GameResultType.DRAW.getCardType()) + GameResultType.DRAW.getCardType());
        }

        return resultForPrint;
    }
}
