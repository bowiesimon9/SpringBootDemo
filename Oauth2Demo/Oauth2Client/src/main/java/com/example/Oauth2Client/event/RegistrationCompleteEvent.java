package com.example.Oauth2Client.event;

import com.example.Oauth2Client.entity.TblUser;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;

@Getter
@Setter
public class RegistrationCompleteEvent extends ApplicationEvent {

    private TblUser user;
    private String applicationUrl;

    public RegistrationCompleteEvent(TblUser user, String applicationUrl) {
        super(user);
        this.user = user;
        this.applicationUrl = applicationUrl;
    }
}
