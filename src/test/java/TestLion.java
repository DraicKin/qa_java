import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

@RunWith(Parameterized.class)
public class TestLion {

    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    private final String EXCEPTION_TEXT = "Используйте допустимые значения пола животного - самей или самка";
    Feline feline = Mockito.mock(Feline.class);
    String sex;
    boolean hasManeExpected;

    public TestLion(String sex, boolean hasManeExpected){
        this.sex = sex;
        this.hasManeExpected = hasManeExpected;
    }

    @Parameterized.Parameters
    public static Object[][] getLionData () {
        return new Object [][] {
                {"Самец", true},
                {"Самка", false},
                {"Кто-то", false}
        };
    }

    @Test
    public void testHasMane() {
        try {
            Lion lion = new Lion(sex, feline);
            Assert.assertEquals(hasManeExpected, lion.doesHaveMane());
        } catch (Exception exception) {
            Assert.assertEquals(EXCEPTION_TEXT, exception.getMessage());
        }
    }

    @Test
    public void testGetKittens() {
        final int KITTENS = 6;
        try {
            Lion lion = new Lion(sex, feline);
            Mockito.when(feline.getKittens()).thenReturn(KITTENS);
            Assert.assertEquals(KITTENS, lion.getKittens());
        } catch (Exception exception) {
            Assert.assertEquals(EXCEPTION_TEXT, exception.getMessage());
        }
    }

    @Test
    public void testGetFood() {
        try {
            Lion lion = new Lion(sex, feline);
            lion.getFood();
            Mockito.verify(feline).getFood("Хищник");
        } catch (Exception exception) {
            Assert.assertEquals(EXCEPTION_TEXT, exception.getMessage());
        }
    }
}
