import domain.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.entry;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class GameResultCreatorTest {
    @Test
    void 카드_숫자들의_합을_구하는_경우() {
        //given
        List<Card> card = new ArrayList<Card>() {
            {
                add(new Card(CardNumbers.FOUR, CardShapes.CLOVER));
                add(new Card(CardNumbers.NINE, CardShapes.DIAMOND));
                add(new Card(CardNumbers.ACE, CardShapes.SPADE));
            }
        };
        Cards cards = new Cards(card);

        //when
        int result = Cards.getSum(cards);

        //then
        assertThat(result).isEqualTo(14);
    }

    @Test
    void 딜러의_승패_결과를_구하는_경우() {
        //given
        Map<String, String> userResult = new HashMap<>();
        userResult.put("halim", "패");
        userResult.put("sojeong", "패");
        userResult.put("jinhee", "승");
        userResult.put("dowon", "무");

        //when
        Map<String, Integer> dealerResult = GameResultCreator.getDealerResult(userResult);

        //then
        int winCount = dealerResult.get(ResultTypes.LOSE.getResultType());
        int loseCount = dealerResult.get(ResultTypes.WIN.getResultType());
        int tieCount = dealerResult.get(ResultTypes.TIE.getResultType());

        assertThat(winCount).isEqualTo(2);
        assertThat(loseCount).isEqualTo(1);
        assertThat(tieCount).isEqualTo(1);
    }

    @Test
    void 유저의_승패_결과를_구하는_경우() {
        //given
        List<Card> player1 = new ArrayList<Card>() {
            {
                add(new Card(CardNumbers.FOUR, CardShapes.CLOVER));
                add(new Card(CardNumbers.EIGHT, CardShapes.DIAMOND));
                add(new Card(CardNumbers.SIX, CardShapes.DIAMOND));
            }
        };

        Cards p1 = new Cards(player1);

        List<Card> player2 = new ArrayList<Card>() {
            {
                add(new Card(CardNumbers.FIVE, CardShapes.SPADE));
                add(new Card(CardNumbers.QUEEN, CardShapes.DIAMOND));
                add(new Card(CardNumbers.THREE, CardShapes.HEART));
            }
        };

        Cards p2 = new Cards(player2);

        List<Card> player3 = new ArrayList<Card>() {
            {
                add(new Card(CardNumbers.EIGHT, CardShapes.HEART));
                add(new Card(CardNumbers.ACE, CardShapes.DIAMOND));
                add(new Card(CardNumbers.TWO, CardShapes.HEART));
            }
        };

        Cards p3 = new Cards(player3);

        Player dealer = new Player("딜러", p1);
        Player user1 = new Player("halim", p2);
        Player user2 = new Player("jinhee", p3);

        List<Player> players = new ArrayList<Player>() {
            {
                add(dealer);
                add(user1);
                add(user2);
            }
        };

        Participants participants = new Participants(players);

        //when
        Map<String, String> userResult = GameResultCreator.getParticipantsResult(dealer, participants);

        //then
        assertThat(userResult).contains(entry("halim", "무"), entry("jinhee", "승"));
    }
}
