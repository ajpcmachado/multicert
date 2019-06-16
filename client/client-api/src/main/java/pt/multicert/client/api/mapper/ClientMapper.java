package pt.multicert.client.api.mapper;

import org.mapstruct.Mapper;

import pt.multicert.client.rest.bean.Client;

@Mapper
public interface ClientMapper {
    pt.multicert.client.api.dal.entity.Client toDao(Client c);
    Client fromDao(pt.multicert.client.api.dal.entity.Client c);
}
