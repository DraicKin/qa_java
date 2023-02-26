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
    public void getsFriendsOfAlex() throws Exception {
        LionAlex alex = new LionAlex(feline);
        Assert.assertEquals("Неверный список друзей у Алекса!",
                List.of("Марти", "Глория", "Мелман"),
                alex.getFriends()
        );
    }

    @Test
    public void getsPlaceOfLivingZoo() throws Exception {
        String place = "Ньюйоркский зоопарк";
        LionAlex alex = new LionAlex(feline);
        Assert.assertEquals("Неверное место жительства Алекса!", place, alex.getPlaceOfliving());
    }

    @Test
    public void kittenCountTest() throws Exception {
        LionAlex alex = new LionAlex(feline);
        Mockito.when(feline.getKittens(Mockito.anyInt())).thenReturn(0);
        Assert.assertEquals("Неверное число детей Алекса!", 0, alex.getKittens());
    }
}
