package repository.reservationsImpl;

import model.Reservations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import repository.RepositoryGeneral;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ReservationsRepositoryJDBC implements RepositoryGeneral<Reservations> {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final RowMapper<Reservations> reservationRowMapper = new RowMapper<Reservations>() {
        @Override
        public Reservations mapRow(ResultSet rs, int rowNum) throws SQLException {
            Reservations reservation = new Reservations();
            reservation.setId(rs.getInt("id"));
            reservation.setStart_Date(rs.getDate("start_Date"));
            reservation.setEnd_Date(rs.getDate("end_Date"));
            reservation.setIdVehicle(rs.getInt("idVehicle"));
            reservation.setIdUser(rs.getInt("idUser"));
            reservation.setStatus(rs.getString("status"));
            return reservation;
        }
    };

    @Override
    public List<Reservations> list() {
        String sql = "SELECT * FROM reservations";
        return jdbcTemplate.query(sql, reservationRowMapper);
    }

    @Override
    public Reservations byId(int id) {
        String sql = "SELECT * FROM reservations WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, reservationRowMapper, id);
    }

    @Override
    @Transactional
    public void save(Reservations reservation) {
        String sql = "INSERT INTO reservations (start_Date, end_Date, idVehicle, idUser, status) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, reservation.getStart_Date(), reservation.getEnd_Date(), reservation.getIdVehicle(), reservation.getIdUser(), reservation.getStatus());
    }

    @Override
    @Transactional
    public void delete(int id) {
        String sql = "DELETE FROM reservations WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    @Transactional
    public void update(Reservations reservation) {
        String sql = "UPDATE reservations SET start_Date = ?, end_Date = ?, idVehicle = ?, idUser = ?, status = ? WHERE id = ?";
        jdbcTemplate.update(sql, reservation.getStart_Date(), reservation.getEnd_Date(), reservation.getIdVehicle(), reservation.getIdUser(), reservation.getStatus(), reservation.getId());
    }
}
