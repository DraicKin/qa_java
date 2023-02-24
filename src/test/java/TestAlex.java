import com.example.Feline;
import com.example.LionAlex;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class TestAlex {

    @Mock
    Feline feline;

    @Test
    public void getsFriendsOfAlex() {
        try {
            LionAlex alex = new LionAlex(feline);
            Assert.assertEquals(List.of("Марти", "Глория", "Мелман"), alex.getFriends());
        } catch (Exception exception) {
            throw new AssertionError("Ошибка при инициализации Алекса!");
        }
    }

    @Test
    public void getsPlaceOfLivingZoo() {
        try {
            String place = "Ньюйоркский зоопарк";
            LionAlex alex = new LionAlex(feline);
            Assert.assertEquals(place, alex.getPlaceOfliving());
        } catch (Exception exception) {
            throw new AssertionError("Ошибка при инициализации Алекса!");
        }
    }

    @Test
    public void kittenCountTest() {
        try {
            LionAlex alex = new LionAlex(feline);
            Mockito.when(feline.getKittens(Mockito.anyInt())).thenReturn(0);
            Assert.assertEquals(0, alex.getKittens());
        } catch (Exception exception) {
            throw new AssertionError("Ошибка при инициализации Алекса!");
        }

    }
}
