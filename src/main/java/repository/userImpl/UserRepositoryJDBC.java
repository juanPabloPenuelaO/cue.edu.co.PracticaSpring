package repository.userImpl;

import model.User;
import model.Reservations;
import mapping.dtos.userDTO;
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
public class UserRepositoryJDBC implements Repository<User> {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final RowMapper<User> userRowMapper = new RowMapper<User>() {
        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setName(rs.getString("name"));
            user.setLastName(rs.getString("lastName"));
            user.setPhoneNumber(rs.getInt("phoneNumber"));
            user.setPassword(rs.getString("password"));
            return user;
        }
    };

    @Override
    @Transactional
    public void addUser(userDTO userDTO) {
        String sql = "INSERT INTO users (name, lastName, phoneNumber, password) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, userDTO.name(), userDTO.lastName(), userDTO.phoneNumber(), userDTO.password());
    }

    @Override
    public List<User> list() {
        String sql = "SELECT * FROM users";
        return jdbcTemplate.query(sql, userRowMapper);
    }

    @Override
    public User byId(int id) {
        String sql = "SELECT * FROM users WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, userRowMapper, id);
    }

    @Override
    @Transactional
    public void save(User user) {
        String sql = "INSERT INTO users (name, lastName, phoneNumber, password) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, user.getName(), user.getLastName(), user.getPhoneNumber(), user.getPassword());
    }

    @Override
    @Transactional
    public void delete(int id) {
        String sql = "DELETE FROM users WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public void update(Reservations reservation) {
    }
}
