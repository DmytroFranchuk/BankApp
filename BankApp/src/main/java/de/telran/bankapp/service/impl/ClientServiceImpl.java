package de.telran.bankapp.service.impl;

import de.telran.bankapp.dto.ClientDto;
import de.telran.bankapp.entity.Client;
import de.telran.bankapp.mapper.ClientMapper;
import de.telran.bankapp.repository.ClientRepository;
import de.telran.bankapp.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    @Override
    public List<ClientDto> getAll() {
        List<Client> clients = clientRepository.findAll();
        return clients.stream()
                .map(clientMapper::clientToDto)
                .collect(Collectors.toList());
    }

    @Override
    public ClientDto getById(Long id) {
        Client client = clientRepository.findById(id).orElse(null);
        return client != null ? clientMapper.clientToDto(client) : null;
    }

//    @Override
//    public List<ClientDto> getClientsByManagerId(Long managerId) {
//        return null;
//    }
}
