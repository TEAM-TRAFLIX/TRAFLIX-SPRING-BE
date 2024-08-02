package org.example.traflixspringbe.data.dto;

import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;
import org.example.traflixspringbe.data.entity.UserEntity;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class UserDTO {
    @Id
    String userId = "";

    String userName;

    @Email
    @NotNull
    String userEmail;
    @NotNull
    String userPassword;

    boolean userIsOAuth;
    String userOAuthType;

    String userSchool;
    String userMajor;
    String userGrade;

    List<String> userSavedLectures = new ArrayList<>();
    ArrayList<String> userSchedule = new ArrayList<String>();

    String userUsePurpose;

    // 비밀번호 인코딩 없이 비밀번호를 업데이트하기 위해서 오버로딩한 메소드
    public UserEntity toEntitiy(){

        String stringSchedule = null;
        if(!userSchedule.isEmpty())
            stringSchedule = String.join(",", userSchedule);

        return UserEntity.builder()
                .id(userId)
                .name(userName)
                .email(userEmail)
                .password(userPassword)
                .isOAuth(userIsOAuth)
                .oauthType(userOAuthType)
                .school(userSchool)
                .major(userMajor)
                .grade(userGrade)
                .savedLectures(userSavedLectures)
                .schedule(stringSchedule)
                .usePurpose(userUsePurpose)
                .build();
    }

    public UserEntity toEntitiy(PasswordEncoder passwordEncoder){

        String stringSchedule = null;
        if(!userSchedule.isEmpty())
            stringSchedule = String.join(",", userSchedule);

        return UserEntity.builder()
                .id(userId)
                .name(userName)
                .email(userEmail)
                .password(passwordEncoder.encode(userPassword))
                .isOAuth(userIsOAuth)
                .oauthType(userOAuthType)
                .school(userSchool)
                .major(userMajor)
                .grade(userGrade)
                .savedLectures(userSavedLectures)
                .schedule(stringSchedule)
                .usePurpose(userUsePurpose)
                .build();
    }
}