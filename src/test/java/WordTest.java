import org.junit.*;
import static org.junit.Assert.*;

public class WordTest {
  // @After
  // public void tearDown() {
  //   Word.clear();
  //   //Definition.clear();
  // }
  @Test
  public void word_instantiatesCorrectly_true() {
    Word testWord = new Word("Home");
    assertEquals(true, testWord instanceof Word);
  }
}
