package com.edds.opensource;

import com.edds.opensource.arguments.Argument;
import com.edds.opensource.arguments.ArgumentsHandler;
import com.edds.opensource.jsontojava.JsonToJava;
import com.edds.opensource.jsontojava.exception.JsonToJavaException;
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
        } catch (ParseException e) {
            System.out.println(e.getMessage());
            System.out.println();
            ArgumentsHandler.help(APPLICATION_NAME);
        } catch(JsonToJavaException e) {
            System.out.println("Error while processing JSON : " + e.getMessage());
        }
    }
}
