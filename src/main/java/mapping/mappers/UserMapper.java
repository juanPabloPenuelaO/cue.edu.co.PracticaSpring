package mapping.mappers;

import mapping.dtos.userDTO;
import model.User;

import java.util.List;

public class UserMapper {
    public static User mapFrom(userDTO userDTO) {
        return User.builder()
                .name(userDTO.name())
                .lastName(userDTO.lastName())
                .phoneNumber(userDTO.phoneNumber())
                .password(userDTO.password())
                .build();

    }

    public static userDTO mapFrom(User user) {
        return userDTO.builder()
                .name(user.getName())
                .lastName(user.getLastName())
                .phoneNumber(user.getPhoneNumber())
                .password(user.getPassword())
                .build();
    }
}
