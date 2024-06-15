package repository.userImpl;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class UserRepositoryJDBC {

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

    public User findByUsername(String name) {
        String sql = "SELECT * FROM users WHERE name = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{name}, userRowMapper);
    }

    public void save(User user) {
        String sql = "INSERT INTO users (name, lastName, phoneNumber, password) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, user.getName(), user.getLastName(), user.getPhoneNumber(), user.getPassword(), user.getPhoneNumber());
    }
}


