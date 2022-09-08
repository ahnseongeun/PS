package chapter2_abstract_factory.orc;

import chapter2_abstract_factory.Army;

public class OrcArmy implements Army {

    static final String description = "This is the orc army";

    @Override
    public String getDescription() {
        return description;
    }
}
