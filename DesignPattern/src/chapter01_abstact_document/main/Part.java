package chapter01_abstact_document.main;

import java.util.Map;

public class Part extends AbstractDocument implements HasType, HasPrice, HasModel{
    protected Part(Map<String, Object> properties) {
        super(properties);
    }



}
