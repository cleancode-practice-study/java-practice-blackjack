package controller;

import domain.Player;
import domain.Validator;
import view.OutputView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrintController {
    public static void printPlayerInitialMessage(List<String> names) {
        OutputView.printPlayerInitialMessage(names);
        System.out.println("");
    }

    // 플레이어 초기 카드 출력
    public static void printPlayerInitialCards(Player dealer, List<Player> users) {
        OutputView.printPlayerOwnCard(dealer);
        System.out.println("");

        for (Player user : users) {
            OutputView.printPlayerOwnCard(user);
            System.out.println("");
        }
        System.out.println("");
    }

    public static void printPlayerOwnCard(Player user) {
        OutputView.printPlayerOwnCard(user);
        System.out.println("");
    }

    public static void printDealerOneCardMessage() {
        OutputView.printDealerOneMoreCardMessage();
        System.out.println("");
    }

    public static void printGameResult(Player dealer, List<Player> users) {
        int userSize = users.size();
        if (dealer.cards.size() > 2)
            PrintController.printDealerOneCardMessage();

        printPlayerFinalCardsAndSumResult(dealer, users); // 플레이어들의 최종 카드와 숫자 합 결과 출력
        Map<String, String> userWinOrLoseResult = new HashMap<>();
        for (Player user : users)
            Validator.compareDealerAndUser(userWinOrLoseResult, dealer, user); // 유저 승패 결과 구하기
        printWinOrLoseResult(userSize, userWinOrLoseResult); // 최종 승패 결과 출력
    }

    private static void printPlayerFinalCardsAndSumResult(Player dealer, List<Player> users) {
        OutputView.printPlayerCardTotalResult(dealer);
        for (Player user : users)
            OutputView.printPlayerCardTotalResult(user);

        System.out.println("");
    }

    private static void printWinOrLoseResult(int userSize, Map<String, String> userWinOrLoseResult) {
        int dealerWinCount = Player.getDealerWinCounter(userWinOrLoseResult);

        OutputView.printDealerWinOrLoseResult(userSize, dealerWinCount);
        OutputView.printUsersWinOrLoseResult(userWinOrLoseResult);
    }
}