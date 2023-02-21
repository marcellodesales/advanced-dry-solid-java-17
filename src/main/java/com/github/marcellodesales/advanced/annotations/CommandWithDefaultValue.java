package com.github.marcellodesales.advanced.annotations;

public @interface CommandWithDefaultValue {

    // default
    String value();
}

@CommandWithDefaultValue("Super value!")
class MyCommand {

}