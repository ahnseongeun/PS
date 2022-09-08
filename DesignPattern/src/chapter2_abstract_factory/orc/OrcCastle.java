package chapter2_abstract_factory.orc;

import chapter2_abstract_factory.Castle;

public class OrcCastle implements Castle {

    static final String description = "This is the orc castle";

    @Override
    public String getDescription() {
        return description;
    }

}
