package chapter1_abstact_document.main;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

public class Car extends AbstractDocument implements HasModel, HasPrice, HasParts {

    public Car(Map<String, Object> properties) {
        super(properties);
    }

}
