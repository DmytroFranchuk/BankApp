package de.telran.bankapp.controller;

import de.telran.bankapp.dto.ManagerDto;
import de.telran.bankapp.dto.ManagerInfoDto;
import de.telran.bankapp.dto.ManagerWithClientsDto;
import de.telran.bankapp.entity.Manager;
import de.telran.bankapp.service.ClientService;
import de.telran.bankapp.service.ManagerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/managers")
@RequiredArgsConstructor
public class ManagerController {

    private final ManagerService managerService;
    private final ClientService clientService;

    @GetMapping
    public ResponseEntity<List<ManagerDto>> getAll() {
        List<ManagerDto> managers = managerService.getAll();
        return new ResponseEntity<>(managers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public Manager getById(@PathVariable("id") Long id) {
        Manager manager = managerService.getById(id);
        if (manager == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Менеджер с id " + id + " не найден");
        }
        return manager;
    }

    @GetMapping("/clients")
    public ResponseEntity<List<ManagerWithClientsDto>> getManagersWithClients() {
        List<ManagerWithClientsDto> managerWithClients = clientService.getManagersWithClients();
        return new ResponseEntity<>(managerWithClients, HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<Manager> create(@RequestBody Manager manager) {
        Manager addNew = managerService.createManager(manager);
        return new ResponseEntity<>(addNew, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Manager> updateById(@PathVariable("id") Long id, @RequestBody Manager updatedManager) {
        Manager updated = managerService.updateById(id, updatedManager);
        if (updated != null) {
            return new ResponseEntity<>(updated, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") Long id) {
        boolean deleted = managerService.deleteById(id);
        if (deleted) {
            String message = "Удаление id = " + id + " выполнено успешно";
            return ResponseEntity.status(HttpStatus.OK).body(message);
        } else {
            String errorMessage = "Запись с указанным id = " + id + " не существует";
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
        }
    }

    // Вывести всех клиентов у менеджера по его managerId
    @GetMapping("/{managerId}/clients")
    public ResponseEntity<List<ManagerInfoDto>> getClientsByManagerId(@PathVariable Long managerId) {
        List<ManagerInfoDto> clients = managerService.getClientsByManagerId(managerId);
        return ResponseEntity.ok(clients);
    }


}
