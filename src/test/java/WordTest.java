import org.junit.*;
import static org.junit.Assert.*;

public class WordTest {
  @After
  public void tearDown() {
    Word.clear();
    //Definition.clear();
  }
  @Test
  public void word_instantiatesCorrectly_true() {
    Word testWord = new Word("Bleak");
    assertEquals(true, testWord instanceof Word);
  }

  @Test
  public void getName_wordInstantiatesWithName_Home() {
    Word testWord = new Word("Bleak");
    assertEquals("Bleak", testWord.getName());
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

  @Test
  public void getDefinitions_initiallyReturnsEmptyList_ArrayList() {
    Word test = new Word("Home");
    assertEquals(0, test.getDefinitions().size());
  }

  @Test
  public void addDefinition_addsDefinitionToList_true() {
    Word testWord = new Word("Home");
    Definition testDef = new Definition("Where one sleeps");
    testWord.addDefinition(testDef);
    assertTrue(testWord.getDefinitions().contains(testDef));
  }

  @Test
  public void addDefinition_addsManyDefinitionToOneWord_true() {
    Word testWord = new Word("Home");
    Definition testDefOne = new Definition("Where one sleeps");
    testWord.addDefinition(testDefOne);
    Definition testDefTwo = new Definition("Perferred place to take shower");
    testWord.addDefinition(testDefTwo);
    assertTrue(testWord.getDefinitions().contains(testDefOne));
    assertTrue(testWord.getDefinitions().contains(testDefTwo));
  }
}
