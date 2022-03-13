package controller;

import domain.Convert;
import domain.Player;
import domain.Result;
import view.OutputView;

import java.util.List;
import java.util.Map;

public class PrintController {
    public static void printDealerOneMoreCardMessage() {
        OutputView.printDealerOneMoreCardMessage();
        System.out.println("");
    }

    // 플레이어 초기 카드 출력
    public static void printPlayerInitialCards(Player dealer, List<Player> users) {
        printPlayerInitialMessage(users);
        System.out.println("");

        printPlayerOwnCard(dealer);
        for (Player user : users)
            printPlayerOwnCard(user);

        System.out.println("");
    }

    public static void printPlayerOwnCard(Player user) {
        OutputView.printPlayerOwnCard(user);
        System.out.println("");
    }

    public static void printGameResult(List<Player> users, Player dealer) {
        printTotalPlayerResult(dealer, users); // 플레이어들의 최종 카드와 결과 출력
        Map<String, String> userWinOrLoseResult = Result.getUserWinOrLoseResult(dealer, users); // 유저 승패 결과 구하기
        printWinOrLoseResult(userWinOrLoseResult); // 최종 승패 결과 출력 (딜러+유저)
    }

    private static void printPlayerInitialMessage(List<Player> users) {
        String names = Convert.getNamesWithComma(users);

        OutputView.printPlayerInitialMessage(names);
        System.out.println("");
    }

    private static void printPlayerResult(Player player) {
        List<String> playersCards = player.cards;

        int playersResult = Result.getResultNumber(playersCards);
        OutputView.printTotalPlayerResult(player, playersResult);
    }

    private static void printTotalPlayerResult(Player dealer, List<Player> users) {
        printPlayerResult(dealer);

        for (Player user : users)
            printPlayerResult(user);

        System.out.println("");
    }

    // 승패 결과 출력
    private static void printWinOrLoseResult(Map<String, String> userWinOrLoseResult) {
        List<Integer> dealerResult = Result.getDealerWinOrLoseResult(userWinOrLoseResult);

        OutputView.printDealerWinOrLoseResult(dealerResult); // 딜러 승패 결과
        OutputView.printUsersWinOrLoseResult(userWinOrLoseResult); // 유저 승패 결과
    }
}