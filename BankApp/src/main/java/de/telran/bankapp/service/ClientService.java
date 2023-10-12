package de.telran.bankapp.service;

import de.telran.bankapp.dto.ClientDto;
import de.telran.bankapp.dto.ManagerWithClientsDto;

import java.util.List;

public interface ClientService {
    List<ClientDto> getAll();

    List<ManagerWithClientsDto> getManagersWithClients();

    ClientDto getById(Long id);


//    List<ClientDto> getClientsByManagerId(Long managerId);
}
