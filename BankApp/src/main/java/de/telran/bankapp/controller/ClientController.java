package de.telran.bankapp.controller;

import de.telran.bankapp.dto.ClientDto;
import de.telran.bankapp.dto.ProductDto;
import de.telran.bankapp.entity.Client;
import de.telran.bankapp.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/clients")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @GetMapping
    public ResponseEntity<List<ClientDto>> getAll() {
        List<ClientDto> clientDtoList = clientService.getAll();
        return new ResponseEntity<>(clientDtoList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public ClientDto getById(@PathVariable("id") Long id) {
        ClientDto clientDto = clientService.getById(id);
        if (clientDto == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Client is id " + id + " not find");
        }
        return clientDto;
    }

}
