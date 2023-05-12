package LoginAndSignup.LoginAndSignup.Models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private int id;

    @Column(nullable = false)
     private String email;

    @Column(nullable = false)
     private String fullName;


    @Column(nullable = false)
     private String phoneNumber;

    @Column(nullable = false)
    private String password;

    @CreationTimestamp
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date createdTime;
}
