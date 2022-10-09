package chapter02_abstract_factory;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Slf4j
public class App {

    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);
    private final Kingdom kingdom = new Kingdom();

    public static void main(String[] args) {
        App app = new App();
        app.run();
    }

    public void run() {
        LOGGER.info("elf kingdom");
        createKingdom(Kingdom.FactoryMaker.KingdomType.ELF);
        LOGGER.info(kingdom.getArmy().getDescription());
        LOGGER.info(kingdom.getCastle().getDescription());
        LOGGER.info(kingdom.getKing().getDescription());

        LOGGER.info("orc kingdom");
        createKingdom(Kingdom.FactoryMaker.KingdomType.ORC);
        LOGGER.info(kingdom.getArmy().getDescription());
        LOGGER.info(kingdom.getCastle().getDescription());
        LOGGER.info(kingdom.getKing().getDescription());
    }

    private void createKingdom(Kingdom.FactoryMaker.KingdomType type) {
        KingdomFactory kingdomFactory = Kingdom.FactoryMaker.makeFactory(type);
        King king = kingdomFactory.createKing();
        Castle castle = kingdomFactory.createCastle();
        Army army = kingdomFactory.createArmy();
        kingdom.kingdomSetting(king, castle, army);
    }
}