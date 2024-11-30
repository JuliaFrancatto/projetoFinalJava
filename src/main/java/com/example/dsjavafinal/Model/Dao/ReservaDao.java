package com.example.dsjavafinal.Model.Dao;

import com.example.dsjavafinal.Model.Reserva;
import java.sql.Connection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.*;

public class ReservaDao {
    private Connection connection;

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public boolean inserir(Reserva reserva) {
        String sql = "INSERT INTO reservas (numeroSala, curso, disciplina, professor, data, horaEntrada, horaSaida, informatica, turno) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement pst = connection.prepareStatement(sql)) {
            pst.setString(1, reserva.getNumeroSala());
            pst.setString(2, reserva.getCurso());
            pst.setString(3, reserva.getDisciplina());
            pst.setString(4, reserva.getProfessor());
            pst.setString(5, reserva.getData());
            pst.setString(6, reserva.getHrEntrada());
            pst.setString(7, reserva.getHrSaida());
            pst.setBoolean(8, reserva.isInformatica());
            pst.setString(9, reserva.getTurno());

            int rowsAffected = pst.executeUpdate();

            return rowsAffected == 0; // Se não inseriu, retorna erro
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Se ocorrer erro na inserção
        }
    }

    public Reserva getReservaById(int id) {
        String sql = "SELECT * FROM reservas WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet resultado = stmt.executeQuery();

            if (resultado.next()) {
                return new Reserva(
                        resultado.getInt("id"),
                        resultado.getString("numeroSala"),
                        resultado.getString("curso"),
                        resultado.getString("disciplina"),
                        resultado.getString("professor"),
                        resultado.getString("data"),
                        resultado.getString("hrEntrada"),
                        resultado.getString("hrSaida"),
                        resultado.getBoolean("informatica"),
                        resultado.getString("turno")
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReservaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean delete(int id) {
        String sql = "DELETE FROM reservas WHERE id = ?";

        try (PreparedStatement pst = connection.prepareStatement(sql)) {
            pst.setInt(1, id);

            int rowsAffected = pst.executeUpdate();

            return rowsAffected > 0; // Retorna true se deletou com sucesso
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Se ocorreu algum erro
        }
    }

    public List<Reserva> getReservas() {
        String sql = "SELECT * FROM reservas";
        List<Reserva> listReservas = new ArrayList<>();
        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet resultado = stmt.executeQuery()) {

            while (resultado.next()) {
                Reserva reserva = new Reserva(
                        resultado.getInt("id"),
                        resultado.getString("numeroSala"),
                        resultado.getString("curso"),
                        resultado.getString("disciplina"),
                        resultado.getString("professor"),
                        resultado.getString("data"),
                        resultado.getString("hrEntrada"),
                        resultado.getString("hrSaida"),
                        resultado.getBoolean("informatica"),
                        resultado.getString("turno")
                );
                listReservas.add(reserva);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ReservaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listReservas;
    }}


