package io.github.sharelison.jsontopojogenerator;

import io.github.sharelison.jsontopojogenerator.arguments.Argument;
import io.github.sharelison.jsontopojogenerator.arguments.ArgumentsHandler;
import io.github.sharelison.jsontojava.JsonToJava;
import io.github.sharelison.jsontojava.exception.JsonToJavaException;
import org.apache.commons.cli.ParseException;

public class JsonToPojoApp {

    public static final String APPLICATION_NAME = "jsontopojo";

    public static void main(String[] args) {
        try {
            ArgumentsHandler argumentsHandler = new ArgumentsHandler(args);
            JsonToJava jsonToJava = new JsonToJava();
            System.out.println("Processing JSON Schema\n");
            if(argumentsHandler.hasArgument(Argument.OUTPUT_DIR)) {
                jsonToJava.jsonToJava(argumentsHandler.getArgument(Argument.JSON),
                                      argumentsHandler.getArgument(Argument.CLASS_NAME),
                                      argumentsHandler.getArgument(Argument.PACKAGE),
                                      argumentsHandler.getArgument(Argument.OUTPUT_DIR));
            } else {
                jsonToJava.jsonToJava(argumentsHandler.getArgument(Argument.JSON),
                                      argumentsHandler.getArgument(Argument.CLASS_NAME),
                                      argumentsHandler.getArgument(Argument.PACKAGE))
                          .forEach(System.out::println);
            }
            System.out.println("\nProcessed JSON Schema\n");
        } catch (ParseException e) {
            System.out.println(e.getMessage());
            System.out.println();
            ArgumentsHandler.help(APPLICATION_NAME);
        } catch(JsonToJavaException e) {
            System.out.println("Error while processing JSON : " + e.getMessage());
        }
    }
}
