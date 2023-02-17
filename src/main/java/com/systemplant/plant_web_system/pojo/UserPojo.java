package com.systemplant.plant_web_system.pojo;

import com.systemplant.plant_web_system.Entity.User;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserPojo {

    private Integer id;

    @NotNull
    private String email;

    @NotNull
    private String user_name;

    @NotNull
    private String fullname;

    @NotNull
    private String password ;

    public UserPojo(User user){
        this.id=user.getId();
        this.email=user.getEmail();
        this.user_name=user.getUsername();
        this.fullname=user.getFullname();
        this.password=user.getPassword();
    }
}
