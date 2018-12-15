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
            boolean withAnnotations = withAnnotations(argumentsHandler);
            if(argumentsHandler.hasArgument(Argument.OUTPUT_DIR)) {
                jsonToJava.jsonToJava(argumentsHandler.getArgument(Argument.JSON),
                                      argumentsHandler.getArgument(Argument.CLASS_NAME),
                                      argumentsHandler.getArgument(Argument.PACKAGE),
                                      argumentsHandler.getArgument(Argument.OUTPUT_DIR),
                                      withAnnotations);
            } else {
                jsonToJava.jsonToJava(argumentsHandler.getArgument(Argument.JSON),
                                      argumentsHandler.getArgument(Argument.CLASS_NAME),
                                      argumentsHandler.getArgument(Argument.PACKAGE),
                                      withAnnotations)
                          .forEach(System.out::println);
            }
            System.out.println("\nProcessed JSON Schema\n");
        } catch (ParseException e) {
            System.out.println(e.getMessage());
            System.out.println();
            ArgumentsHandler.help(APPLICATION_NAME);
        } catch(JsonToJavaException e) {
            System.out.println("Error while processing JSON : " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Unexpected error " + e.getMessage());
        }
    }

    private static boolean withAnnotations(ArgumentsHandler argumentsHandler) {
        boolean withAnnotations = true;

        if(argumentsHandler.hasArgument(Argument.WITH_ANNOTATIONS)) {
            try {
                withAnnotations = Boolean.valueOf(argumentsHandler.getArgument(Argument.WITH_ANNOTATIONS));
            } catch (RuntimeException exception) {
                System.out.println("Unexpected argument for --with-annotations default value true will be used");
            }

        }

        return withAnnotations;
    }
}
