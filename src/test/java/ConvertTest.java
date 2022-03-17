import domain.Convert;
import domain.Player;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class ConvertTest {
    @Test
    void 쉼표_기준으로_자르는_경우() {
        //given
        String names = "halim,jinhee";

        //when
        String[] name = Convert.splitNames(names);

        //then
        assertThat(name[0]).isEqualTo("halim");
        assertThat(name[1]).isEqualTo("jinhee");
    }

    @Test
    void 콤마를_포함하여_출력하는_경우() {
        //given
        List<Player> users = new ArrayList<>();
        Player user1 = Player.createPlayer("halim");
        Player user2 = Player.createPlayer("jinhee");
        users.add(user1);
        users.add(user2);

        //when
        String names = Convert.getNamesWithComma(users);

        //then
        assertThat(names).isEqualTo("halim, jinhee");
    }
}
