package agp.cristinini.repasofx;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.time.LocalDate;

public class Persona {

    private StringProperty nome;
    private StringProperty dni;
    private BooleanProperty mayorEdad;
    private LocalDate dataNacemento;

    public Persona(String nome, String dni, Boolean mayorEdad, LocalDate dataNacemento) {
        this.nome = new SimpleStringProperty(nome);
        this.dni = new SimpleStringProperty(dni);
        this.mayorEdad = new SimpleBooleanProperty(mayorEdad);
        this.dataNacemento = dataNacemento;
    }

    public Persona() {
    }

    public String getNome() {
        return nome.get();
    }

    public StringProperty nomeProperty() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome.set(nome);
    }

    public String getDni() {
        return dni.get();
    }

    public StringProperty dniProperty() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni.set(dni);
    }

    public boolean isMayorEdad() {
        return mayorEdad.get();
    }

    public BooleanProperty mayorEdadProperty() {
        return mayorEdad;
    }

    public void setMayorEdad(boolean mayorEdad) {
        this.mayorEdad.set(mayorEdad);
    }

    public LocalDate getDataNacemento() {
        return dataNacemento;
    }

    @Override
    public String toString() {
        return getNome();
    }

    public void setDataNacemento(LocalDate dataNacemento) {
        this.dataNacemento = dataNacemento;
    }
}
