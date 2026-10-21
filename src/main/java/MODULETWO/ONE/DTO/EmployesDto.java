package MODULETWO.ONE.DTO;

import MODULETWO.ONE.Annotation.EmployeRoleValidation;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployesDto  {

    private Long id;
    @NotBlank(message = "Name can not be blank")
    private String Name;
    @Max(value = 80, message = "less than 80")
    @Min(value = 18, message = "greater than 18")
    private Integer Age;
    @Email(message = "ENTER A VALID Email")
    private String EmailId;
    private LocalDate dateOfJoin;
    private boolean IsActive;
    @EmployeRoleValidation
    @NotNull(message = "Prime number is required")
    private Integer IsPrimeNumber;
}
