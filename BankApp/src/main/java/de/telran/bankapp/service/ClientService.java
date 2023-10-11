package de.telran.bankapp.service;

import de.telran.bankapp.dto.ClientDto;

import java.util.List;

public interface ClientService {
    List<ClientDto> getAll();

    ClientDto getById(Long id);

//    List<ClientDto> getClientsByManagerId(Long managerId);
}
