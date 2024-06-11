package repository.reservationsImpl;

import config.DatabaseConnection;
import mapping.dtos.userDTO;
import model.Reservations;
import repository.RepositoryGeneral;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReservationsRepositoryJDBC implements RepositoryGeneral<Reservations> {
    private Connection getConnection() throws SQLException {
        return (Connection) DatabaseConnection.getInstance();
    }


    @Override
    public void addUser(userDTO userDTO) {

    }

    @Override
    public List<Reservations> list() {
        List<Reservations> Reservations = new ArrayList<>();
        try (Statement statement = getConnection().createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM vehicles")) {
            while (resultSet.next()) {
                Reservations reservation = createReservation(resultSet);
                Reservations.add(reservation);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al listar clientes", e);
        }
        return Reservations;
    }

    @Override
    public Reservations byId(int id) {
        Reservations reservation = null;
        try {
            String sql = "SELECT * FROM reservations WHERE id = ?";
            PreparedStatement preparedStatement = getConnection().prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                reservation = createReservation(resultSet);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al buscar cliente por ID", e);
        }
        return reservation;
    }

    @Override
    public void save(Reservations reservation) {
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(
                "INSERT INTO reservations(start_Date, end_Date, idVehicle, idUser, status) VALUES (?, ?, ?, ?, ?)")) {
            preparedStatement.setDate(1, new java.sql.Date(reservation.getStart_Date().getTime()));
            preparedStatement.setDate(2, new java.sql.Date(reservation.getEnd_Date().getTime()));
            preparedStatement.setInt(3, reservation.getIdVehicle());
            preparedStatement.setInt(4, reservation.getIdUser());
            preparedStatement.setString(5, reservation.getStatus());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error al guardar cliente", e);
        }
    }

    @Override
    public void delete(int id) {
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(
                "DELETE FROM reservations WHERE id = ?")) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error al eliminar reserva", e);
        }
    }

    @Override
    public void update(Reservations reservation) {
        try (PreparedStatement preparedStatement = getConnection()
                .prepareStatement("UPDATE reservations SET start_Date = ?, end_Date = ?, idVehicle = ?," +
                        " idUser = ?, status = ? WHERE id = ?")) {
            preparedStatement.setDate(1, new java.sql.Date(reservation.getStart_Date().getTime()));
            preparedStatement.setDate(2, new java.sql.Date(reservation.getEnd_Date().getTime()));
            preparedStatement.setInt(3, reservation.getIdVehicle());
            preparedStatement.setInt(4, reservation.getIdUser());
            preparedStatement.setString(5, reservation.getStatus());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error al actualizar vehiculo", e);
        }
    }

    private Reservations createReservation(ResultSet resultSet) throws SQLException {
        Reservations reservation = new Reservations();
        reservation.setId(resultSet.getInt("id"));
        reservation.setStart_Date(resultSet.getDate("start_Date"));
        reservation.setEnd_Date(resultSet.getDate("end_Date"));
        reservation.setIdVehicle(resultSet.getInt("idVehicle"));
        reservation.setIdUser(resultSet.getInt("idUser"));
        reservation.setStatus(resultSet.getString("status"));
        return reservation;
    }
}

