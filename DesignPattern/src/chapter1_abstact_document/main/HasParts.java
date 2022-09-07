package chapter1_abstact_document.main;

import java.util.stream.Stream;

public interface HasParts extends Document {

    default Stream<Part> getParts() {
        return children(Property.PARTS.toString(), Part::new);
    }
}
