import domain.Player;
import domain.Result;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.AssertionsForClassTypes.entry;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class ResultTest {
    @Test
    void 카드_숫자들의_합을_구하는_경우() {
        //given
        List<String> cards = new ArrayList<>();
        cards.add("4클로버");
        cards.add("9다이아몬드");
        cards.add("A스페이드");

        //when
        int result = Result.getResultNumber(cards);

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
        List<Integer> dealerResult = Result.getDealerWinOrLoseResult(userResult);

        //then
        int winCount = dealerResult.get(0);
        int loseCount = dealerResult.get(1);
        int tieCount = dealerResult.get(2);

        assertThat(winCount).isEqualTo(2);
        assertThat(loseCount).isEqualTo(1);
        assertThat(tieCount).isEqualTo(1);
    }

    @Test
    void 유저의_승패_결과를_구하는_경우() {
        //given
        List<String> dealerCards = new ArrayList<String>(Arrays.asList("4클로버", "8다이아몬드", "6다이아몬드"));
        List<String> user1Cards = new ArrayList<String>(Arrays.asList("5스페이드", "Q다이아몬드", "3하트"));
        List<String> user2Cards = new ArrayList<String>(Arrays.asList("8하트", "A다이아몬드", "2하트"));
        Player dealer = new Player("딜러", dealerCards);
        Player user1 = new Player("halim", user1Cards);
        Player user2 = new Player("jinhee", user2Cards);

        List<Player> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);

        //when
        Map<String, String> userResult = Result.getUserWinOrLoseResult(dealer, users);

        //then
        assertThat(userResult).contains(entry("halim", "무"), entry("jinhee", "승"));
    }
}
