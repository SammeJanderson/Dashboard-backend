package com.sammjanderson.PerkProgramApi.mapping;

import com.sammjanderson.PerkProgramApi.dto.request.client.ClientDTO;
import com.sammjanderson.PerkProgramApi.dto.request.client.NewClientDTO;
import com.sammjanderson.PerkProgramApi.entity.Client;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ClientMapper {

    ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);

    Client toModel(ClientDTO clientDTO);

    ClientDTO toDTO(Client client);

    Client newClientDataToModel(NewClientDTO clientDTO);

}
