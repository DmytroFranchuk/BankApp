package de.telran.bankapp.mapper;

import de.telran.bankapp.dto.ClientDto;
import de.telran.bankapp.entity.Client;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ClientMapper {

//    @Named("toClientDto")
    @Mapping(source = "manager.id", target = "managerId")
    ClientDto clientToDto(Client client);
//    @IterableMapping(qualifiedByName = "toClientDto")
//    List<ClientDto> toListClientDto(List<Client> clients);

//    Client dtoToClient(ClientDto clientDto);
}
