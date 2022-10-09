package chapter02_abstract_factory.orc;

import chapter02_abstract_factory.Army;

public class OrcArmy implements Army {

    static final String description = "This is the orc army";

    @Override
    public String getDescription() {
        return description;
    }
}
