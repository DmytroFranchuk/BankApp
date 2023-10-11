package de.telran.bankapp.mapper;

import de.telran.bankapp.dto.ManagerDto;
import de.telran.bankapp.entity.Manager;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ManagerMapper {

//    @Mapping(source = "products", target = "products")
//    @Mapping(source = "clients", target = "clients")
    ManagerDto managerToDto(Manager manager);

    Manager dtoToManager(ManagerDto managerDto);

//    ManagerInfoDto managerInfoToDto(Manager manager);

//    List<ManagerDetailsDto> managersToManagerDetailsDtos(List<Manager> managers);

}
