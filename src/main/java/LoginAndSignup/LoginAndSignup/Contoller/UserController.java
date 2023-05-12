package LoginAndSignup.LoginAndSignup.Contoller;


import LoginAndSignup.LoginAndSignup.Dto.UserDto;
import LoginAndSignup.LoginAndSignup.Models.User;
import LoginAndSignup.LoginAndSignup.Service.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

       @Autowired
       UserServiceImp userServiceImp;

       @PostMapping("/Registration")
      public ResponseEntity<String> userSignup(@RequestBody UserDto userDto){
            String ans=userServiceImp.userSignup(userDto);
             return new ResponseEntity<>(ans, HttpStatus.OK);
      }
      @PostMapping("/login")
    public ResponseEntity<String> userLogin(@RequestParam String email,@RequestParam String password){
           String ans=userServiceImp.userLogin(email,password);
          return new ResponseEntity<>(ans, HttpStatus.OK);
      }
      @GetMapping("/getAlluser")
    public ResponseEntity<List<User>> getAllUsers(){
           List<User> ans=userServiceImp.getAllUsers();
           return new ResponseEntity<>(ans,HttpStatus.OK);
      }

}
