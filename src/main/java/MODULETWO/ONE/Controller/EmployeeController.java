package MODULETWO.ONE.Controller;

import MODULETWO.ONE.DTO.EmployesDto;
import MODULETWO.ONE.Service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/Employes")
public class EmployeeController {

//    final EmployeeRepository employeeRepository;
//    public EmployeeController(EmployeeRepository employeeRepository) {
//        this.employeeRepository = employeeRepository;
//    }

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/{EmployeeId}")
    public ResponseEntity<EmployesDto> GetEmployeeById(@PathVariable(name = "EmployeeId") Long id) {
        Optional<EmployesDto> employedto = employeeService.GetEmployeeById(id);
        return employedto.
                map(employesDto -> ResponseEntity.ok(employesDto))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<EmployesDto>> GetAllEmployees() {
        return ResponseEntity.ok(employeeService.GetAllEmployees());
    }

    @PostMapping
    public ResponseEntity<EmployesDto> AddEmployee(@RequestBody @Valid EmployesDto InputEmployee) {
        EmployesDto saveemploye = employeeService.AddEmployee(InputEmployee);
        return new ResponseEntity<>(saveemploye, HttpStatus.CREATED);
    }

    @PutMapping(path = "/{employeid}")
    public EmployesDto UpdateemployeBYid(@RequestBody EmployesDto employesDto, @PathVariable Long employeid) {
        return employeeService.UpdateemployeBYid(employesDto, employeid);
    }

    @DeleteMapping(path = "/{employeid}")
    public void DeleteEmployeByid(@PathVariable Long employeid) {
        employeeService.DeleteEmployeByid(employeid);
        System.out.println("Delete Successfully");
    }

    @PatchMapping(path = "/{employeid}")
    public EmployesDto PatchEmployee(@PathVariable Long employeid,
                                     @RequestBody Map<String, Object> updatefiled) {
        return employeeService.PatchEmployee(employeid, updatefiled);
    }

}
