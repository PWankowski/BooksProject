package booksProject.user.mappers;

import booksProject.user.Role;
import booksProject.user.dto.UserDto;
import booksProject.user.dto.UserForm;
import booksProject.user.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {

    private static PasswordEncoder passwordEncoder;

    @Autowired
    public UserMapper(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public static UserDto mapToDto(UserEntity user) {

        return UserDto.builder()
                .name(user.getName())
                .surname(user.getSurname())
                .age(user.getAge())
                .emailAddress(user.getEmailAddress())
                .sex(user.getSex())
                .password(user.getPassword())
                .login(user.getLogin())
                .build();
    }

    public static List<UserDto> map(List<UserEntity> userList) {

       return userList.stream()
                .map(user -> mapToDto(user))
                .collect(Collectors.toList());
    }

    public static UserEntity mapToEntity(UserForm form) {

        String password = form.getPassword();
        return  UserEntity.builder()
                    .name(form.getName())
                    .surname(form.getSurname())
                    .age(form.getAge())
                    .emailAddress(form.getEmailAddress())
                    .sex(form.getSex())
                    .password(passwordEncoder.encode(password))
                    .login(form.getLogin())
                    .role(Role.USER)
                    .build();
    }
}
