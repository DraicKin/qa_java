import com.example.Cat;
import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class TestCat {

    @Mock
    Feline feline;
    @Test
    public void catSaysMeow() {
        final String CAT_SOUND = "Мяу";
        Cat cat = new Cat(feline);
        String catSays = cat.getSound();
        Assert.assertEquals(String.format("Эта кошка говорит %s, но должна бы сказать %s", catSays, CAT_SOUND),
                CAT_SOUND, catSays);
    }
    @Test
    public void catGetsFood() throws Exception {
        List<String> meals = List.of("Животные", "Птицы", "Рыба");
        Cat cat = new Cat(feline);
        Mockito.when(feline.eatMeat()).thenReturn(meals);
        Assert.assertEquals("Эта кошка ест" + cat.getFood().toString() + "но должна есть " +
                meals, meals, cat.getFood());
    }
}
