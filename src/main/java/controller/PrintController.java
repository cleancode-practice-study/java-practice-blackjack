package controller;

import domain.Player;
import domain.ResultStatistics;
import domain.Validator;
import view.OutputView;

import java.util.List;
import java.util.Map;

public class PrintController {

    public static final int INITIAL_CARD_COUNT = 2;

    public static void printPlayerInitialMessage(List<Player> users, String addedCommaUserNames) {
        OutputView.printPlayerInitialMessage(users, Player.getAddedCommaUserNames(users));
        System.out.println("");
    }

    // 플레이어 초기 카드 출력
    public static void printPlayerInitialCards(Player dealer, List<Player> users) {
        PrintController.printPlayerInitialMessage(users, Player.getAddedCommaUserNames(users));
        System.out.println("");

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
        List<String> dealerCard = dealer.cards;

        // 딜러 한장 더 받았는지 안받았는지
        if (dealerCard.size() > INITIAL_CARD_COUNT)
            PrintController.printDealerOneCardMessage();

        printPlayerFinalCardsAndResult(dealer, users); // 플레이어들의 최종 카드와 숫자 합 결과 출력

        Map<String, String> userWinOrLoseResult = Validator.getUserWinOrLoseResult(dealer, users); // 유저 승패 결과 구하기

        printWinOrLoseResult(userWinOrLoseResult, userSize); // 최종 승패 결과 출력
    }

    private static void printPlayerFinalCardsAndResult(Player dealer, List<Player> users) {
        int dealerResult = ResultStatistics.getCardTotalSum(dealer.cards);
        OutputView.printPlayerCardTotalResult(dealer, dealerResult);
        for (Player user : users) {
            int userSumResult = ResultStatistics.getCardTotalSum(user.cards);
            OutputView.printPlayerCardTotalResult(user, userSumResult);
        }

        System.out.println("");
    }

    private static void printWinOrLoseResult(Map<String, String> userWinOrLoseResult, int userSize) {
        int dealerWinCount = ResultStatistics.getDealerWinCounter(userWinOrLoseResult);

        OutputView.printDealerWinOrLoseResult(userSize, dealerWinCount);
        OutputView.printUsersWinOrLoseResult(userWinOrLoseResult);
    }
}