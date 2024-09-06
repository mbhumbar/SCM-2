package com.mbinfotechworld.SCM_2.form;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserForm {

    @NotBlank(message = "Username is required")
    @Size(min = 3, message = "Minimun 3 character is required")
    private String name;
    @Email(message = "Invalid Email Address")
    @NotBlank(message = "Email is required")
    private String email;
    @NotBlank(message = "Password is required")
    @Size(min = 6 , message = "Min 6 Characters is required")
    private String password;
    @NotBlank(message = "About is required")
    private String about;

    @NotBlank(message = "PhoneNumber is required")
    @Size(min = 8, max = 12, message = "Invalid Phone Number")
    private String phoneNumber;

}