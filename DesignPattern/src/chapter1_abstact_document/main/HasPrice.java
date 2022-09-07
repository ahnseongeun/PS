package chapter1_abstact_document.main;

import java.util.Optional;

public interface HasPrice extends Document {

    default Optional<Long> getPrice() {
        return Optional.ofNullable((Long) get(Property.PRICE.toString()));
    }

}
