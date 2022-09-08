package chapter2_abstract_factory.orc;

import chapter2_abstract_factory.King;

public class OrcKing implements King {

    static final String description = "This is the orc king";

    @Override
    public String getDescription() {
        return description;
    }

}
