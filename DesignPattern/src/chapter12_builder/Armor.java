package chapter12_builder;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Armor {

    CLOTHES("clothes"),
    LEATHER("leather"),
    CHAIN_MAIL("chain mail"),
    PLATE_MAIL("plate mail");

    private final String title;

    @Override
    public String toString() {
        return title;
    }
}
