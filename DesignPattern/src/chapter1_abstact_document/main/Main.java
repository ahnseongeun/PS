package chapter1_abstact_document.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;


public class Main {
    public static void main(String[] args) {

        final Logger LOGGER = LoggerFactory.getLogger(Main.class.getName());
        LOGGER.info("test");

        LOGGER.info("Constructing parts and car");

        var wheelProperties = Map.of(
                Property.TYPE.toString(), "wheel",
                Property.MODEL.toString(), "15C",
                Property.PRICE.toString(), 100L);

        var doorProperties = Map.of(
                Property.TYPE.toString(), "door",
                Property.MODEL.toString(), "Lambo",
                Property.PRICE.toString(), 300L);

        var carProperties = Map.of(
                Property.MODEL.toString(), "300SL",
                Property.PRICE.toString(), 10000L,
                Property.PARTS.toString(), List.of(wheelProperties, doorProperties));

        var car = new Car(carProperties);

        LOGGER.info("Here is our car:");
        LOGGER.info("-> model: {}", car.getModel().orElseThrow());
        LOGGER.info("-> price: {}", car.getPrice().orElseThrow());
        LOGGER.info("-> parts: ");

        /*
        car.getParts().forEach(p -> LOGGER.info("\t{}/{}/{}",
                p.getType().orElse(null),
                p.getModel().orElse(null),
                p.getPrice().orElse(null))
        );
        */

        // Constructing parts and car
        // Here is our car:
        // model: 300SL
        // price: 10000
        // parts:
        // wheel/15C/100
        // door/Lambo/300
    }
}
