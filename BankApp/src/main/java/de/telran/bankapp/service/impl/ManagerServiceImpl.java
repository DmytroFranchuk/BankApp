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
//    private final ClientMapper clientMapper;
//    private final ClientService clientService;
//    private final ProductService productService;

    @Override
    public List<ManagerDto> getAll() {
        List<Manager> managers = managerRepository
                .findAll(Sort.by(Sort.Order.asc("id")));
//        for (Manager manager : managers) {
//            for (Client client: manager.getClients()) {
//                System.out.println(client.getId());
//            }
//        }
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
                existingManager.setCreatedAt(updatedManager.getCreatedAt());
                existingManager.setUpdatedAt(updatedManager.getUpdatedAt());
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
//    public List<ManagerInfoDto> getClientsByManagerId(Long managerId) {
////        List<ManagerInfoDto> managerInfoDtos = new ArrayList<>();
//
//        Optional<Manager> manager = managerRepository.findById(managerId);
//        List<Client> clients = manager.get().getClients();
//        List<ManagerInfoDto> managerInfoDtos = clients.stream()
//                .map(client -> managerInfoMapper.managerInfoToDto(client.getManager()))
//                .collect(Collectors.toList());
////        for (Client client : manager.get().getClients()) {
////            managerInfoDtos.add(managerInfoMapper.managerInfoToDto(client.getManager()));
////        }
//        return managerInfoDtos;
//    }
}
