package agp.cristinini.repasofx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDate;
import java.util.List;

public class Database {
    public static final ObservableList<Persona> data = FXCollections.observableArrayList(List.of(
            new Persona("CarlosHuevosLargos1", "234453336", true, LocalDate.of(2002, 3, 3)),
            new Persona("CarlosHuevosLargos2", "234453336", true, LocalDate.of(2002, 3, 3)),
            new Persona("CarlosHuevosLargos3", "234453336", true, LocalDate.of(2002, 3, 3)),
            new Persona("CarlosHuevosLargos4", "234453336", true, LocalDate.of(2002, 3, 3))
    ));
}
