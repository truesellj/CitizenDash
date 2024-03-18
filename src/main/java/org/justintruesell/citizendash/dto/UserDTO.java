package org.justintruesell.citizendash.dto;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@FieldMatch.List( { @FieldMatch(first = "password", second = "matchingPassword", message = "The password fields must match")})
public class UserDTO {
    @NotEmpty
    private String userName;

    @Pattern(regexp = "[A-Za-z]+$", message = "Only alphabetic allowed")
    private String firstName;

    @Pattern(regexp = "[A-Za-z]+$", message = "Only alphabetic allowed")
    private String lastName;

    @Column(unique = true)
    @Email
    private String email;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date dob;
    @Pattern(regexp = "[0-9]{7,}", message = "Only numeric allowed")
    private String phone;

    @Pattern(regexp = "[a-zA-z0-9\\s]{1,}", message = "Address code wrong format")
    private String address;

    @NotEmpty(message = "Required")
    private String password;

    @NotEmpty(message = "Required")
    private String matchingPassword;

    /**looks like this is where the user gets assigned from the sign-up form
     * and info transferred into the database
     * */
    public UserDTO(@NotEmpty String userName, @Pattern(regexp = "[A-Za-z]+$", message = "Only alphabetic allowed") String firstName, @Pattern(regexp = "[A-Za-z]+$", message = "Only alphabetic allowed") String lastName, @Email String email, String phone, @Pattern(regexp = "[0-9]{5}$", message = "Address code wrong format") String address, @NotEmpty(message = "Required") String password, @NotEmpty(message = "Required") String matchingPassword, Date dob) {
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.password = password;
        this.matchingPassword = matchingPassword;
        this.dob=dob;
    }
}
