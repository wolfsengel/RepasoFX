package agp.cristinini.repasofx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.util.Callback;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

public class HelloController {

    private final ObservableList<Persona> data;
    private FilteredList<Persona> filtered;
    @FXML
    private TableView<Persona> tablaGente;
    @FXML
    private TableColumn<Persona, String> cD;
    @FXML
    private TableColumn<Persona, LocalDate> cDate;
    @FXML
    private ListView<Persona> listaGente;
    @FXML
    private TableColumn<Persona, String> cN;
    @FXML
    private TableColumn<Persona, Boolean> c18;
    @FXML
    private MenuItem filtro;
    @FXML
    private MenuItem borrar;
    @FXML
    private MenuItem engadir;
    @FXML
    private TextField lupa;
    @FXML
    private Button fotoButon;

    public HelloController() {
        data = Database.data;
        filtered = new FilteredList<>(data);
    }
    public void initialize() {
        setUpColumnas();
        tablaGente.setItems(filtered);
        listaGente.setItems(filtered);
        lupa.textProperty().addListener((observableValue, old, newT) -> filterItems(newT));
    }
    protected void removeItem(Persona p){
        data.remove(p);
        filtered.remove(p);
    }
    protected void filterItems(String newT){
        filtered.setPredicate(persona -> persona.getNome().contains(newT));
    }

    public void setUpColumnas(){
        cD.setCellValueFactory(new PropertyValueFactory<>("dni"));
        cN.setCellValueFactory(new PropertyValueFactory<>("nome"));
        c18.setCellValueFactory(new PropertyValueFactory<>("mayorEdad"));
        cDate.setCellValueFactory(new PropertyValueFactory<>("dataNacemento"));
    }

    @FXML
    public void borrarPersona(ActionEvent actionEvent) {
        Persona uwu = tablaGente.getSelectionModel().getSelectedItem();
        if (uwu == null){
            Alert dialogoError = new Alert(Alert.AlertType.ERROR);
            dialogoError.setTitle("Selecciona una fila");
            dialogoError.setContentText("Te pasaste Wey");
            dialogoError.showAndWait();
            return;
        }
        Alert seguro = new Alert(Alert.AlertType.WARNING);
        seguro.setTitle("Seguro???????????????????");
        seguro.setContentText("ayayay");
        seguro.showAndWait();
        if(seguro.getResult() == ButtonType.OK){
            removeItem(uwu);
        }
    }
    @FXML
    public void editarPersona(ActionEvent actionEvent) {
        Persona uwu = tablaGente.getSelectionModel().getSelectedItem();
        if (uwu == null){
            Alert dialogoError = new Alert(Alert.AlertType.ERROR);
            dialogoError.setTitle("Selecciona una fila");
            dialogoError.setContentText("Te pasaste Wey");
            dialogoError.showAndWait();
            return;
        }
        Alert dialogEdit = new Alert(Alert.AlertType.CONFIRMATION);
        TextField nome = new TextField();
        nome.setText(uwu.getNome());
        TextField dni = new TextField();
        dni.setText(uwu.getDni());
        DatePicker dataNacemento = new DatePicker();
        dataNacemento.setValue(uwu.getDataNacemento());
        dialogEdit.getDialogPane().setContent(new VBox(nome, dni, dataNacemento));
        Optional<ButtonType> result = dialogEdit.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK){
            uwu.setNome(nome.getText());
            uwu.setDni(dni.getText());
            uwu.setDataNacemento(dataNacemento.getValue());
            uwu.setMayorEdad(esMayorEdad(dataNacemento.getValue()));
        }
    }
    private boolean esMayorEdad(LocalDate coño) {
        if (LocalDate.now().getYear() - coño.getYear() > 18){
            return true;
        }
        return false;
    }
}