package chapter02_abstract_factory.elf;

import chapter02_abstract_factory.Army;

public class ElfArmy implements Army {

    static final String description = "This is the elven army";

    @Override
    public String getDescription() {
        return description;
    }
}
