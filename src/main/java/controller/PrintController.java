package controller;

import domain.Player;
import domain.ResultStatistics;
import domain.Validator;
import view.OutputView;

import java.util.List;
import java.util.Map;

public class PrintController {

    public static final int INITIAL_CARD_COUNT = 2;

    public static void printPlayerInitialMessage(List<Player> users) {
        String names = Player.getAddedCommaUserNames(users);

        OutputView.printPlayerInitialMessage(names);
        System.out.println("");
    }

    // 플레이어 초기 카드 출력
    public static void printPlayerInitialCards(Player dealer, List<Player> users) {
        printPlayerInitialMessage(users);
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

    public static void printGameResult(Player dealer, List<Player> users) {
        if (isDealerOneMoreCard(dealer))
            printDealerOneCardMessage();

        printPlayerFinalCardsAndResultNumber(dealer, users); // 플레이어들의 최종 카드와 숫자 합 결과 출력
        Map<String, String> userWinOrLoseResult = Validator.getUserWinOrLoseResult(dealer, users); // 유저 승패 결과 구하기
        printWinOrLoseResult(userWinOrLoseResult); // 최종 승패 결과 출력
    }

    private static void printDealerOneCardMessage() {
        OutputView.printDealerOneMoreCardMessage();
        System.out.println("");
    }

    private static boolean isDealerOneMoreCard(Player dealer) {
        List<String> dealerCard = dealer.cards;

        return dealerCard.size() > INITIAL_CARD_COUNT;
    }

    private static void printPlayerFinalCardsAndResultNumber(Player dealer, List<Player> users) {
        List<String> dealerCard = dealer.cards;

        int dealerResult = ResultStatistics.getCardTotalSum(dealerCard);
        OutputView.printPlayerCardTotalResult(dealer, dealerResult);

        for (Player user : users) {
            List<String> userCards = user.cards;

            int userResultNumber = ResultStatistics.getCardTotalSum(userCards);
            OutputView.printPlayerCardTotalResult(user, userResultNumber);
        }

        System.out.println("");
    }

    private static void printWinOrLoseResult(Map<String, String> userWinOrLoseResult) {
        List<Integer> dealerCount = ResultStatistics.getDealerCount(userWinOrLoseResult);

        OutputView.printDealerWinOrLoseResult(dealerCount); // 딜러 승패 결과
        OutputView.printUsersWinOrLoseResult(userWinOrLoseResult); // 유저 승패 결과
    }
}