package chapter1_abstact_document.main;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Stream;

public interface Document {

    Void put(String key, Object value);

    Object get(String key);

    <T> Stream<T> children(String key, Function<Map<String, Object>, T> constructor);
}
