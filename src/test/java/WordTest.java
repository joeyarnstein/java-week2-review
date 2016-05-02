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
    Word testWord = new Word("Bleak");
    assertEquals(true, testWord instanceof Word);
  }

  @Test
  public void getName_wordInstantiatesWithName_Home() {
    Word testCategory = new Word("Bleak");
    assertEquals("Bleak", testCategory.getName());
  }

  @Test
  public void all_returnsAllInstancesOfWord_true() {
    Word firstTest = new Word("Home");
    Word secondTest = new Word("Work");
    assertTrue(Word.all().contains(firstTest));
    assertTrue(Word.all().contains(secondTest));
  }

  @Test
  public void clear_emptiesAllCategoriesFromList_0() {
    Word testWord = new Word("Home");
    Word.clear();
    assertEquals(Word.all().size(), 0);
  }

  @Test
  public void getId_WordInstantiateWithAnId_1() {
    Word.clear();
    Word testWord = new Word("Home");
    assertEquals(1, testWord.getId());
  }

  @Test
  public void find_returnsWordWithSameId_secondWord() {
    Word.clear();
    Word firstWord = new Word("Home");
    Word secondWord = new Word("Work");
    assertEquals(Word.find(secondWord.getId()), secondWord);
  }

  @Test
  public void find_returnsNullWhenNoWordFound_null() {
    assertTrue(Word.find(999) == null);
  }
}
