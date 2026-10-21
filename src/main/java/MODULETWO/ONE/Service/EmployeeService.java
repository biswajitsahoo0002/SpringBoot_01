package MODULETWO.ONE.Service;

import MODULETWO.ONE.DTO.EmployesDto;
import MODULETWO.ONE.Entity.EmployeeEntity;
import MODULETWO.ONE.Repository.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.io.File;
import java.io.FileDescriptor;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    public EmployeeService(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }


    public Optional<EmployesDto> GetEmployeeById(Long id) {
//        Optional<EmployeeEntity> employeentity = employeeRepository.findById(id);
//        return employeentity.map(employeeEntity -> modelMapper.map(employeeEntity, EmployesDto.class));
        return employeeRepository.findById(id).map(employeeEntity -> modelMapper.map(employeeEntity, EmployesDto.class));
    }

    public List<EmployesDto> GetAllEmployees() {
        List<EmployeeEntity> employeeentitylist = employeeRepository.findAll();
        return employeeentitylist
                .stream()
                .map(employeeEntity -> modelMapper.map(employeeEntity, EmployesDto.class))
                .collect(Collectors.toList());

    }

    public EmployesDto AddEmployee(EmployesDto inputEmployee) {
        EmployeeEntity employeentity = modelMapper.map(inputEmployee,EmployeeEntity.class);
        EmployeeEntity saveNewemployee =  employeeRepository.save(employeentity);
        return modelMapper.map(saveNewemployee, EmployesDto.class);
    }

    public boolean IsEmployeidExit(Long employeid){
        boolean isexit = employeeRepository.existsById(employeid);
        return isexit;
    }

    public EmployesDto UpdateemployeBYid(EmployesDto employesDto, Long employeid) {
        boolean IsidExit = IsEmployeidExit(employeid);
        if (!IsidExit) return null;
        EmployeeEntity employeeEntity = modelMapper.map(employesDto, EmployeeEntity.class);
        employeeEntity.setId(employeid);
        EmployeeEntity updateEmploye = employeeRepository.save(employeeEntity);
        return modelMapper.map(updateEmploye, EmployesDto.class);
    }

    public void DeleteEmployeByid(Long employeid) {
        boolean isidexit = IsEmployeidExit(employeid);
        if (!isidexit) return;
        employeeRepository.deleteById(employeid);
    }

    public EmployesDto PatchEmployee(Long employeid, Map<String, Object> updatefiled) {
        boolean isidexit = IsEmployeidExit(employeid);
        if (!isidexit) return null;
        EmployeeEntity employeeEntity = employeeRepository.findById(employeid).get();
        updatefiled.forEach((field,value) ->{
            Field updateFiledByid = ReflectionUtils.findField(EmployeeEntity.class, field);
            updateFiledByid.setAccessible(true);
            ReflectionUtils.setField(updateFiledByid,employeeEntity,value);
        });
        return modelMapper.map(employeeRepository.save(employeeEntity), EmployesDto.class);
    }
}
