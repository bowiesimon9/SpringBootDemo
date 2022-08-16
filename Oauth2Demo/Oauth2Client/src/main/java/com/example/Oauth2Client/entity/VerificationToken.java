package com.example.Oauth2Client.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;
@Entity
@Data
@NoArgsConstructor
public class VerificationToken {
    //expiration time 10 minutes
    private static final int EXPIRATION_TIME = 10;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id1;

    private String token1;
    private Date expirationTime;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id",
            nullable = false,
            foreignKey = @ForeignKey(name="FK_USER_VERIFY_TOKEN1")
    )
    private TblUser user;

    public VerificationToken(TblUser user, String token) {
        super();
        this.token1 = token;
        this.user = user;
        this.expirationTime = calculateExpirationDate(EXPIRATION_TIME);
    }

    public VerificationToken(String token) {
        super();
        this.token1 = token;
        this.expirationTime = calculateExpirationDate(EXPIRATION_TIME);
    }

    private Date calculateExpirationDate(int expirationTime) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(new Date().getTime());
        calendar.add(Calendar.MINUTE, expirationTime);
        return new Date(calendar.getTime().getTime());
    }
}

