package de.telran.bankapp.service;

import de.telran.bankapp.dto.ManagerDto;
import de.telran.bankapp.dto.ManagerInfoDto;
import de.telran.bankapp.entity.Manager;

import java.util.List;

public interface ManagerService {

    List<ManagerDto> getAll();

    Manager getById(Long id);

    Manager createManager(Manager manager);

    Manager updateById(Long id, Manager updatedManager);

    boolean deleteById(Long id);

    List<ManagerInfoDto> getClientsByManagerId(Long managerId);

//    public ManagerDetailsDto getManagerDetails(Long managerId);
}
