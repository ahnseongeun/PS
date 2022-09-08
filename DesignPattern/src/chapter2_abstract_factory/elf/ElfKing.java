package chapter2_abstract_factory.elf;

import chapter2_abstract_factory.King;

public class ElfKing implements King {

    static final String description = "This is the elven king";

    @Override
    public String getDescription() {
        return description;
    }
}
