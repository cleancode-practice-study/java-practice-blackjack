package model;

import java.util.*;
// 딜러와 참가자 초기화 -> 이름, 카드 2장 생성해서 딜러, 참가자 객체 생성하기
public class BlackJackGame {
    private static final int INIT_CARD_COUNT = 2;
    private static final String WIN = "승";
    private static final String LOSE = "패";
    private static final String DRAW = "무";

    public static Dealer getDealer() {
        Cards cards = getInitCards();

        return new Dealer(cards);
    }

    public static List<Participant> getParticipantsByNames(String names) {
        List<String> splitNames = splitNames(names);

        List<Participant> participants = new ArrayList<>();

        for (String name : splitNames) {
            Cards cards = getInitCards();
            Participant participant = new Participant(name, cards);
            participants.add(participant);
        }

        return participants;
    }

    private static Cards getInitCards() {
        List<Card> cards = new ArrayList<>();

        for (int i = 0 ; i < INIT_CARD_COUNT ; i++) {
            cards.add(RandomCardCreator.getRandomCard());
        }

        return new Cards(cards);
    }

    private static List<String> splitNames(String names) {
        String[] participantsNames = names.split(",");
        return new ArrayList<>(Arrays.asList(participantsNames));
    }

    public static List<String> getCardStates(Cards cards) {
        List<Card> playerCard = cards.getCards();
        List<String> cardNames = new ArrayList<>();

        for (Card card : playerCard) {
            cardNames.add(card.getCard());
        }

        return cardNames;
    }

    public static Map<String, String> getParticipantGameResult(List<Participant> participants, Dealer dealer) {
        Map<String, String> participantGameResult = new HashMap<>();

        for (Participant participant : participants) {
            String participantResult = participant.getGameResult(Calculator.getCardSum(dealer.getCards()));
            participantGameResult.put(participant.getName(), participantResult);
        }

        return participantGameResult;
    }

    public static List<String> getDealerGameResult(Map<String, String> participantGameResult, Dealer dealer) {
        Map<String, Integer> dealerGameResult = new HashMap<>();

        for (String name : participantGameResult.keySet()) {
            String participantResult = participantGameResult.get(name);
            String dealerResult = dealer.getGameResult(participantResult);
            dealerGameResult.put(dealerResult, dealerGameResult.getOrDefault(dealerResult, 0) + 1);
        }

        return getResultForPrint(dealerGameResult);
    }

    private static List<String> getResultForPrint(Map<String, Integer> finalGameResult) {
        List<String> resultForPrint = new ArrayList<>();
        if (finalGameResult.containsKey(WIN)) {
            resultForPrint.add(finalGameResult.get(WIN) + WIN);
        }

        if (finalGameResult.containsKey(LOSE)) {
            resultForPrint.add(finalGameResult.get(LOSE) + LOSE);
        }

        if (finalGameResult.containsKey(DRAW)) {
            resultForPrint.add(finalGameResult.get(DRAW) + DRAW);
        }

        return resultForPrint;
    }

}
