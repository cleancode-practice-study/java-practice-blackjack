import domain.Player;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class PlayerTest {
    @Test
    void 플레이어를_생성하는_경우() {
        //given
        List<String> names = new ArrayList<>();
        names.add("halim");
        names.add("jinhee");

        //when
        List<Player> users = Player.createUserPlayers(names);

        //then
        assertThat(users.size()).isEqualTo(2);
        assertThat(users.get(0).name).isEqualTo("halim");
        assertThat(users.get(1).name).isEqualTo("jinhee");
    }

    @Test
    void 초기_랜덤_카드를_지급하는_경우() {
        //when
        List<String> cards = Player.getInitialCard();

        //then
        assertThat(cards.size()).isEqualTo(2);
    }
}
