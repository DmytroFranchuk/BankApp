package de.telran.bankapp.service.impl;

import de.telran.bankapp.dto.ManagerDto;
import de.telran.bankapp.dto.ManagerInfoDto;
import de.telran.bankapp.entity.Client;
import de.telran.bankapp.entity.Manager;
import de.telran.bankapp.mapper.ManagerInfoMapper;
import de.telran.bankapp.mapper.ManagerMapper;
import de.telran.bankapp.repository.ManagerRepository;
import de.telran.bankapp.service.ManagerService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ManagerServiceImpl implements ManagerService {

    private final ManagerRepository managerRepository;
    private final ManagerMapper managerMapper;
    private final ManagerInfoMapper managerInfoMapper;

    @Override
    public List<ManagerDto> getAll() {
        List<Manager> managers = managerRepository
                .findAll(Sort.by(Sort.Order.asc("id")));
        return managers.stream()
                .map(managerMapper::managerToDto)
                .collect(Collectors.toList());
    }

    @Override
    public Manager getById(Long id) {
        return managerRepository.findById(id).orElse(null);
    }

    @Override
    public Manager createManager(Manager manager) {
        LocalDateTime currentTime = LocalDateTime.now();
        manager.setCreatedAt(currentTime);
        manager.setUpdatedAt(currentTime);
        return managerRepository.save(manager);
    }

    @Override
    public Manager updateById(Long id, Manager updatedManager) {
        if (managerRepository.existsById(id)) {
            Manager existingManager = managerRepository.findById(id).orElse(null);
            if (existingManager != null) {
                existingManager.setFirstName(updatedManager.getFirstName());
                existingManager.setLastName(updatedManager.getLastName());
                existingManager.setStatus(updatedManager.getStatus());
                LocalDateTime currentTime = LocalDateTime.now();
                existingManager.setCreatedAt(currentTime);
                existingManager.setUpdatedAt(currentTime);
                return managerRepository.save(existingManager);
            }
        }
        return null;
    }

    @Override
    public boolean deleteById(Long id) {
        if (managerRepository.existsById(id)) {
            managerRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<ManagerInfoDto> getClientsByManagerId(Long managerId) {

        Optional<Manager> managerOptional = managerRepository.findById(managerId);
        if (managerOptional.isPresent()) {
            Manager manager = managerOptional.get();
            List<Client> clients = manager.getClients();
            ManagerInfoDto managerInfo = managerInfoMapper.managerInfoToDto(manager);
            managerInfo.setClientId(clients.stream()
                    .map(client -> client.getId().toString())
                    .collect(Collectors.toList()));
            return Collections.singletonList(managerInfo);
        } else {
            return Collections.emptyList();
        }
    }

}
