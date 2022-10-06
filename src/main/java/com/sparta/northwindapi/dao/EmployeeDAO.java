package com.sparta.northwindapi.dao;

import com.sparta.northwindapi.dto.DTO;
import com.sparta.northwindapi.dto.EmployeeDTO;
import com.sparta.northwindapi.dto.TerritoryDTO;
import com.sparta.northwindapi.entity.Employee;
import com.sparta.northwindapi.entity.Territory;
import com.sparta.northwindapi.repo.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class EmployeeDAO implements DAO<EmployeeDTO> {
    private final EmployeeRepository REPOSITORY;

    private EmployeeDAO(EmployeeRepository repository) {
        this.REPOSITORY = repository;
    }

    @Override
    public Optional<EmployeeDTO> findById(int id) {
            Optional<Employee> optional = REPOSITORY.findById(id); // Finds employee
            if (optional.isEmpty()){
                return Optional.of(new EmployeeDTO(
                        -1,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null
                ));
            } else {
                Employee employee = optional.get();
                return Optional.of(new EmployeeDTO(
                        employee.getId(),
                        employee.getLastName(),
                        employee.getFirstName(),
                        employee.getTitle(),
                        employee.getTitleOfCourtesy(),
                        employee.getBirthDate(),
                        employee.getHireDate(),
                        employee.getAddress(),
                        employee.getCity(),
                        employee.getRegion(),
                        employee.getPostalCode(),
                        employee.getCountry(),
                        employee.getHomePhone(),
                        employee.getExtension(),
                        employee.getPhoto(),
                        employee.getNotes(),
                        employee.getPhotoPath(),
                        employee.getSalary(),
                        setTerritoriesThing(employee.getTerritories())));
            }
        }

    public static Set<TerritoryDTO> setTerritoriesThing(Set<Territory> t){

        Set<TerritoryDTO> result = new LinkedHashSet<>();

        t.stream().forEach(territory -> {result.add(new TerritoryDTO(territory.getId(), territory.getTerritoryDescription()));});

        return result;
    }
    @Override
    public int  update(EmployeeDTO item) {
        return 0;
    }

    @Override
    public int insert(EmployeeDTO item) {
        return 0;
    }

    @Override
    public boolean insertById(EmployeeDTO item, int id) {
        return false;
    }

    @Override
    public List findAll() {
        return REPOSITORY.findAll();
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