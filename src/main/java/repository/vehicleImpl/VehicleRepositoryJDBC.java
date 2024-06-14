package repository.vehicleImpl;


import model.Vehicles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class VehicleRepositoryJDBC {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final RowMapper<Vehicles> vehicleRowMapper = new RowMapper<Vehicles>() {
        @Override
        public Vehicles mapRow(ResultSet rs, int rowNum) throws SQLException {
            Vehicles vehicle = new Vehicles();
            vehicle.setId(rs.getInt("id"));
            vehicle.setType(rs.getString("type"));
            vehicle.setModel(rs.getString("model"));
            vehicle.setModelYear(rs.getInt("modelYear"));
            vehicle.setBrand(rs.getString("brand"));
            vehicle.setPriceDay(rs.getInt("priceDay"));
            vehicle.setPlate(rs.getString("plate"));
            vehicle.setAvailability(rs.getString("availability"));
            return vehicle;
        }
    };

    public List<Vehicles> list() {
        String sql = "SELECT * FROM vehicles";
        return jdbcTemplate.query(sql, vehicleRowMapper);
    }

    public Vehicles byId(int id) {
        String sql = "SELECT * FROM vehicles WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, vehicleRowMapper, id);
    }

    @Transactional
    public void save(Vehicles vehicle) {
        String sql = "INSERT INTO vehicles(type, model, modelYear, brand, priceDay, plate, availability) VALUES (?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, vehicle.getType(), vehicle.getModel(), vehicle.getModelYear(), vehicle.getBrand(), vehicle.getPriceDay(), vehicle.getPlate(), vehicle.getAvailability());
    }

    @Transactional
    public void delete(int id) {
        String sql = "DELETE FROM vehicles WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    @Transactional
    public void update(Vehicles vehicle) {
        String sql = "UPDATE vehicles SET type = ?, model = ?, modelYear = ?, brand = ?, priceDay = ?, plate = ?, availability = ? WHERE id = ?";
        jdbcTemplate.update(sql, vehicle.getType(), vehicle.getModel(), vehicle.getModelYear(), vehicle.getBrand(), vehicle.getPriceDay(), vehicle.getPlate(), vehicle.getAvailability(), vehicle.getId());
    }
}
