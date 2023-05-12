package LoginAndSignup.LoginAndSignup.Service;

import LoginAndSignup.LoginAndSignup.Dto.UserDto;
import LoginAndSignup.LoginAndSignup.Exceptions.GlobalException;
import LoginAndSignup.LoginAndSignup.Exceptions.userException;
import LoginAndSignup.LoginAndSignup.Models.User;
import LoginAndSignup.LoginAndSignup.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;


@Service
public class UserServiceImp implements UserService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;
    @Override
    public String userSignup(UserDto userDto) {
        //System.out.print("i am in service");
        if(userDto.getFirstName()==null || userDto.getFirstName().length()==0)throw new userException("Please check FirstName");
        if(userDto.getLastName()==null || userDto.getLastName().length()==0)throw new userException("Please check LastName");
        if(userDto.getPhoneNumber()==null || userDto.getPhoneNumber().length()==0)throw new userException("please check mobile number");
        if(userDto.getEmail()==null || !(userDto.getEmail().contains("@gmail.com")) || userDto.getEmail().length()==0){
            throw new userException("please check email properly");
        }
        int emailCount=userRepository.findByEmail(userDto.getEmail());
        int phoneNumberCount=userRepository.findByphoneNumber(userDto.getPhoneNumber());
        if(emailCount>0)throw new userException("This email id is already registered");
        if(phoneNumberCount>0)throw new userException("This phonenumber is already registered");
        if(userDto.getPassword()==null || userDto.getPassword().length()==0)throw new userException("please enter password");
        String pass=userDto.getPassword();
        boolean checkCaps=false;
        boolean checkSmall=false;
        boolean checkNum=false;
        boolean checkSpcl=false;
        for(int i=0;i<pass.length();i++){
            if(pass.charAt(i)>=65 && pass.charAt(i)<=90)checkCaps=true;
            else if(pass.charAt(i)>=97 && pass.charAt(i)<=122)checkSmall=true;
            else if(pass.charAt(i)>=48 && pass.charAt(i)<=57)checkNum=true;
            else{
                checkSpcl=true;
            }
        }
        if(checkNum && checkCaps && checkSmall && checkSpcl){
            userDto.setPassword(this.passwordEncoder.encode(userDto.getPassword()));
        }
        else{
            throw new userException("please enter password based on the specifications");
        }
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String fullname=userDto.getFirstName()+userDto.getLastName();

        User user= User.builder().fullName(fullname).email(userDto.getEmail()).phoneNumber(userDto.getPhoneNumber()).password(userDto.getPassword()).createdTime(timestamp).build();

        userRepository.save(user);

        return "User Succesfully created!";
    }

    @Override
    public String userLogin(String email,String password){
        User user=userRepository.findBymail(email);
        if(user==null){
            throw new userException("User Does not registered with this emailId");
        }
        String encodedPassword = user.getPassword();
        Boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
        if(isPwdRight){
                return "User Login Successful";
            }
        else{
            throw new userException("password Does not matched");}
        }
    @Override
    public List<User> getAllUsers() {
        List<User> ans=userRepository.findAll();
        return ans;
    }
}
