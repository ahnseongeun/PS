package chapter02_abstract_factory.elf;

import chapter02_abstract_factory.Castle;

public class ElfCastle implements Castle {

    static final String description = "This is the elven castle";

    @Override
    public String getDescription() {
        return description;
    }
}
