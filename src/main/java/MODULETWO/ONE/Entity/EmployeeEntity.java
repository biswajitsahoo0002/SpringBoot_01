package MODULETWO.ONE.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@jakarta.persistence.Entity
@Table
@Setter
@Getter
@NoArgsConstructor
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String Name;
    private Integer Age;
    private String EmailId;
    private LocalDate dateOfJoin;
    private boolean IsActive;
    private Integer IsPrimeNumber;
}
