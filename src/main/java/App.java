import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (req, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("words", Word.all());
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/words/new", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/word-form.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/words", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      String word = request.queryParams("word");
      Word newWord = new Word(word);
      model.put("words", Word.all());
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  //
  //   get("/words/:id", (request, response) -> {
  //     HashMap<String, Object> model = new HashMap<String, Object>();
  //     Word word = Word.find(Integer.parseInt(request.params(":id")));
  //     model.put("word", word);
  //     model.put("template", "templates/word.vtl");
  //     return new ModelAndView(model, layout);
  //   }, new VelocityTemplateEngine());
  //
  //   get("/words/:id/definition/new", (request, response) -> {
  //     HashMap<String, Object> model = new HashMap<String, Object>();
  //     Word word = Word.find(Integer.parseInt(request.params(":id")));
  //     model.put("word", word);
  //     model.put("template", "templates/word-definition-form.vtl");
  //     return new ModelAndView(model, layout);
  //   }, new VelocityTemplateEngine());
  //
  //   post("/definition", (request, response) -> {
  //     HashMap<String, Object> model = new HashMap<String, Object>();
  //     Word word = Word.find(Integer.parseInt(request.queryParams("wordId")));
  //     String description = request.queryParams("description");
  //     Definition newDef = new Definition(description);
  //     word.addDefinition(newTask);
  //     model.put("word", word);
  //     model.put("template", "templates/index.vtl");
  //     return new ModelAndView(model, layout);
  //   }, new VelocityTemplateEngine());
  }

}
