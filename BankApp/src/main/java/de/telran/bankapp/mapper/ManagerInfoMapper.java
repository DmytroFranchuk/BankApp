package de.telran.bankapp.mapper;

import de.telran.bankapp.dto.ManagerInfoDto;
import de.telran.bankapp.entity.Client;
import de.telran.bankapp.entity.Manager;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface ManagerInfoMapper {

    @Mapping(source = "manager.id", target = "managerId")
//    @Mapping(source = "products", target = "products")
    @Mapping(source = "manager.clients", target = "clientId", qualifiedByName = "mapClientsToClientId")
    ManagerInfoDto managerInfoToDto(Manager manager);

    @Named("mapClientsToClientId")
    default List<String> mapClientsToClientId(List<Client> clients) {
        if (clients == null) {
            return Collections.emptyList();
        }
        return clients.stream()
                .map(client -> client.getId().toString())
                .collect(Collectors.toList());
    }



}