import org.fluentlenium.adapter.FluentTest;
import static org.fluentlenium.core.filter.FilterConstructor.*;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class AppTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();

  @Override
  public WebDriver getDefaultDriver() {
    return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();

  @Test
  public void rootTest() {
    goTo("http://localhost:4567/");
    assertThat(pageSource()).contains("Dictionary");
    assertThat(pageSource()).contains("Add a New Word");
  }

  @Test
  public void WordIsCreatedAndDisplayedTest() {
    goTo("http://localhost:4567/");
    click("a", withText("Add a New Word"));
    fill("#word").with("Boolean");
    submit(".btn");
    assertThat(pageSource()).contains("Boolean");
  }

  @Test
  public void definitonIsAddedAndDisplayed() {
    goTo("http://localhost:4567/words/new");
    fill("#word").with("Towel");
    submit(".btn");
    click("a", withText("Towel"));
    click("a", withText("Add a definition for this word"));
    fill("#description").with("Cloth to dry body");
    submit(".btn");
    click("a", withText("Towel"));
    assertThat(pageSource()).contains("Cloth to dry body");
  }

}
