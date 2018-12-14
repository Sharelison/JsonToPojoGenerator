package org.edds.opensource.arguments;

public enum Argument {

    JSON("J", "json", true, "A json string or path to a json file(.txt or .json)"),
    OUTPUT_DIR("O", "output-dir", false, "Output directry for generated .java files"),
    CLASS_NAME("C", "class-name", true, "Class name of generated class"),
    PACKAGE("P", "package", true, "Java package for generated classes");

    private String name;
    private String longName;
    private boolean required;
    private String description;

    Argument(String name, String longName, boolean required, String description) {
        this.name = name;
        this.longName = longName;
        this.required = required;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getLongName() {
        return longName;
    }

    public boolean isRequired() {
        return required;
    }

    public String getDescription() {
        return description;
    }
}
