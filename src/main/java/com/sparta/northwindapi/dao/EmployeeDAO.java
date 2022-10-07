package com.sparta.northwindapi.dao;

import com.sparta.northwindapi.dto.EmployeeDTO;
import com.sparta.northwindapi.entity.Employee;
import com.sparta.northwindapi.repo.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeDAO implements DAO<EmployeeDTO> {

    private final EmployeeRepository REPOSITORY;
    private final Assembler ASSEMBLER = new Assembler();


    public EmployeeDAO(EmployeeRepository repository, Assembler assembler) {
        this.repository = repository;
        this.assembler = assembler;
    }


    @Override
    public int insert(EmployeeDTO item) {
        return 0;
    }

    public Optional<EmployeeDTO> findById(int id) {
        Optional<EmployeeDTO> result;
        Optional<Employee> employee;
        if ((employee = REPOSITORY.findById(id)).isPresent())
            result = Optional.of(ASSEMBLER.assembleEmployee(employee.get()));
        else
            result = Optional.empty();
        return result;
    }


    @Override
    public int  update(EmployeeDTO item) {
        Optional<Employee> optional = REPOSITORY.findById(item.getId());
        if (optional.isEmpty()) {
            return -1;
        }
        Employee employee = optional.get();
        if (item.getFirstName() != null){
            employee.setFirstName(item.getFirstName());
        }
        if (item.getLastName() != null){
            employee.setLastName(item.getLastName());
        }
        REPOSITORY.save(employee); // Saves
        
        // Retrieves again to get updated object
        Optional<Employee> result =  REPOSITORY.findById(item.getId());
        if (result.isPresent()){
            employee = result.get();
        }
        return employee.getId();
    }

    @Override
    public boolean insertById(EmployeeDTO item, int id) {
        return false;
    }

    @Override
    public Optional<EmployeeDTO> findById(int id) {
        Optional<EmployeeDTO> result;
        Optional<Employee> employee;
        if ((employee = repository.findById(id)).isPresent())
            result = Optional.of(assembler.assembleEmployee(employee.get()));
        else
            result = Optional.empty();
        return result;
    }

    @Override
    public List<EmployeeDTO> findAll() {
        List<Employee> employees = repository.findAll();
        List<EmployeeDTO> results = new ArrayList<>();
        for (Employee employee: employees)
            results.add(assembler.assembleEmployee(employee));
        return results;
    }

    @Override

    public List<EmployeeDTO> findAll() {
        List<Employee> employees = REPOSITORY.findAll();
        List<EmployeeDTO> results = new ArrayList<>();
        for (Employee employee: employees)
            results.add(ASSEMBLER.assembleEmployee(employee));
        return results;
    }

    @Override
    public boolean updateById(EmployeeDTO item, int id) {
        return false;
    }

    @Override
    public int delete(EmployeeDTO item) {
        return 0;
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }

    @Override
    public boolean deleteAll() {
        return false;
    }
}