package LoginAndSignup.LoginAndSignup.Repository;


import LoginAndSignup.LoginAndSignup.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {


    @Query("select count(u) from User u where u.email=:email")
    int findByEmail(String email);

    @Query("select count(u) from User u where u.phoneNumber=:phoneNumber")
    int findByphoneNumber(String phoneNumber);

    @Query("select u from User u where u.email=:email")
    User findBymail(String email);

    @Query("select u from User u where u.email=:email AND u.password=:password")
    User findByEmailAndPassword(String email, String password);
}
