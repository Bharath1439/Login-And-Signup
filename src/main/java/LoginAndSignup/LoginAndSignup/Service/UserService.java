package LoginAndSignup.LoginAndSignup.Service;

import LoginAndSignup.LoginAndSignup.Dto.UserDto;
import LoginAndSignup.LoginAndSignup.Models.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {

    String userSignup(UserDto userDto);

    String userLogin(String email, String password);
    List<User> getAllUsers();
}
