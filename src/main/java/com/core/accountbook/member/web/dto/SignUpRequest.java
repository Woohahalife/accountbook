package com.core.accountbook.member.web.dto;

import com.core.accountbook.member.application.dto.SignUpServiceRequest;
import com.core.accountbook.member.domain.Password;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class SignUpRequest {

//    @NotBlank
//    @Size(max = 40)
//    @Email
    private String email;

//    @NotBlank
    private String password;

//    @NotBlank
//    @Size(max = 10)
    private String name;

//    @NotNull
    private String address;

//    @NotBlank
//    @Size(max = 11)
    private String phoneNumber;

    public SignUpServiceRequest toService() {
        return new SignUpServiceRequest(
                this.email,
                this.password,
                this.name,
                this.address,
                this.phoneNumber
        );
    }
}
