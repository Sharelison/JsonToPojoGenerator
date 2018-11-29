package com.edds.opensource.arguments;

import org.apache.commons.cli.*;

public class ArgumentsHandler {

    private static final HelpFormatter helpFormatter = new HelpFormatter();
    private static final Options options = initOptions();

    private final CommandLine commandLine;

    public ArgumentsHandler(String[] args) throws ParseException {
        commandLine = new DefaultParser().parse(options, args);
    }

    public String getArgument(Argument argument){
        return commandLine.getOptionValue(argument.getLongName());
    }

    public boolean hasArgument(Argument argument){
        return commandLine.getOptionValue(argument.getLongName()) != null;
    }

    public static void help(String appName) {
       helpFormatter.printHelp(appName, options);
    }

    private static Options initOptions() {
        Options options = new Options();

        for(Argument argument : Argument.values()) {
            Option option = new Option(argument.getName(), argument.getLongName(), true, argument.getDescription());
            option.setRequired(argument.isRequired());
            options.addOption(option);
        }

        return options;
    }

}
