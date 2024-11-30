package com.example.dsjavafinal.Model;
import javafx.beans.property.*;

    public class Reserva {

        private final IntegerProperty id;
        private final StringProperty numeroSala;
        private final StringProperty curso;
        private final StringProperty disciplina;
        private final StringProperty professor;
        private final StringProperty data;
        private final StringProperty hrEntrada;
        private final StringProperty hrSaida;
        private final StringProperty turno;
        private final BooleanProperty informatica;

        public Reserva(int id, String numeroSala, String curso, String disciplina, String professor,
                       String data, String hrEntrada, String hrSaida, boolean informatica, String turno) {
            this.id = new SimpleIntegerProperty(id);
            this.numeroSala = new SimpleStringProperty(numeroSala);
            this.curso = new SimpleStringProperty(curso);
            this.disciplina = new SimpleStringProperty(disciplina);
            this.professor = new SimpleStringProperty(professor);
            this.data = new SimpleStringProperty(data);
            this.hrEntrada = new SimpleStringProperty(hrEntrada);
            this.hrSaida = new SimpleStringProperty(hrSaida);
            this.turno = new SimpleStringProperty(turno);
            this.informatica = new SimpleBooleanProperty(informatica);
        }

        // Getters com Propriedades JavaFX
        public IntegerProperty idProperty() { return id; }
        public StringProperty numeroSalaProperty() { return numeroSala; }
        public StringProperty cursoProperty() { return curso; }
        public StringProperty disciplinaProperty() { return disciplina; }
        public StringProperty professorProperty() { return professor; }
        public StringProperty dataProperty() { return data; }
        public StringProperty hrEntradaProperty() { return hrEntrada; }
        public StringProperty hrSaidaProperty() { return hrSaida; }
        public StringProperty turnoProperty() { return turno; }
        public BooleanProperty informaticaProperty() { return informatica; }

        // Getters normais
        public int getId() { return id.get(); }
        public String getNumeroSala() { return numeroSala.get(); }
        public String getCurso() { return curso.get(); }
        public String getDisciplina() { return disciplina.get(); }
        public String getProfessor() { return professor.get(); }
        public String getData() { return data.get(); }
        public String getHrEntrada() { return hrEntrada.get(); }
        public String getHrSaida() { return hrSaida.get(); }
        public String getTurno() { return turno.get(); }
        public boolean isInformatica() { return informatica.get(); }

        public boolean getInformatica() {
            return false;
        }
    }
