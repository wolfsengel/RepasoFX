module agp.cristinini.repasofx {
    requires javafx.controls;
    requires javafx.fxml;


    opens agp.cristinini.repasofx to javafx.fxml;
    exports agp.cristinini.repasofx;
}