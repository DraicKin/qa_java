import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class TestFeline {

    private final String ANIMAL_KIND = "Хищник";
    private final String ANIMAL_FAMILY = "Кошачьи";
    private final int KITTENS = 5;
    private final List<String> FELINE_MEALS = List.of("Животные", "Птицы", "Рыба");

    @Spy
    Feline feline = new Feline();

    @Test
    public void felineEatsMeat() throws Exception{
        Mockito.when(feline.getFood(ANIMAL_KIND)).thenReturn(FELINE_MEALS);
        Assert.assertEquals("Ошибка в получении списка еды для кошачьих", FELINE_MEALS, feline.eatMeat());
    }

    /* Здесь не использован шпион feline, потому что для
    тестирования метода public String getFamily() это не требуется -
    там нет зависимостей. */
    @Test
    public void felineGetsFamily() {
        Feline feline1 = new Feline();
        Assert.assertEquals("Ошибка определения семейства", ANIMAL_FAMILY, feline1.getFamily());
    }

    @Test
    public void felineOneKittenCount() {
        Mockito.when(feline.getKittens(Mockito.anyInt())).thenReturn(1);
        Assert.assertEquals("Ошибка при определении количества котят без параметров",
                1, feline.getKittens());
    }

    /* Здесь не использован шпион feline, потому что для
   тестирования метода int getKittens(int kittensCount) это не требуется -
   там нет зависимостей. */
    @Test
    public void felineKittensCount() {
        Feline feline1 = new Feline();
        Assert.assertEquals("Ошибка при определении количества котят", KITTENS, feline1.getKittens(KITTENS));
    }

}
