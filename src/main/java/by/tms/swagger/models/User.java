package by.tms.swagger.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private int id;
    @NotBlank
    @NotEmpty
    @Size(min = 3)
    private String username;
    @NotBlank
    @NotEmpty
    @Size(min = 3)
    private String firstname;
    @NotBlank
    @NotEmpty
    @Size(min = 3)
    private String lastname;
    @NotBlank
    @NotEmpty
    @Size(min = 3)
    private String email;
    @NotBlank
    @NotEmpty
    @Size(min = 3)
    private String password;
    @NotEmpty
    private String phone;
    private int userStatus;

}
