// camel-k: language=java dependency=camel-quarkus-openapi-java 

import org.apache.camel.builder.AggregationStrategies;
import org.apache.camel.builder.RouteBuilder;

public class BooksApi extends RouteBuilder {
  @Override
  public void configure() throws Exception {

    from("direct:list")
    .setBody(simple("[{\"title\":\"Twenty Thousand Leagues Under the Seas\",\"author\":\"Jules Verne\",\"isbn\":\"ISBN-99-977-1123366315\"},"
    + "{\"title\":\"The Wonderful Wizard of Oz\",\"author\":\"L. Frank Baum \",\"isbn\":\"ISBN-92-917-1124612333\"},"
    + "{\"title\":\"I, Robot\",\"author\":\"Isaac Asimov\",\"isbn\":\"ISBN-88-543-2345678909\"}]"));

    from("direct:root")
      .setBody(simple("{\"status\":\"UP\"}"));

    from("direct:book")
    .setBody(simple("{\"title\": \"The big Book\",      \"author\": \"Jhon White\",      \"isbn\": \"${header.isbn}\"  }"));  
  }
}