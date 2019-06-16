package pt.multicert.client.api.rest.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;

import org.mapstruct.factory.Mappers;

import pt.multicert.client.api.dal.repo.ClientRepo;
import pt.multicert.client.api.mapper.ClientMapper;
import pt.multicert.client.rest.ClientRestService;
import pt.multicert.client.rest.bean.Client;
import pt.multicert.client.rest.bean.ClientList;

public class ClientRestServiceImpl implements ClientRestService {

    @Resource
    private ClientRepo clientRepo;

    @Override
    public ClientList getList(String name) {

        Collection<pt.multicert.client.api.dal.entity.Client> clients = new ArrayList<>();

        //TODO: Deal with exceptions
        if (name != null && !name.isEmpty()) {
            clients = clientRepo.findAllForName(name);
        } else {
            clients = clientRepo.findAll();
        }
        ClientMapper mapper = getMapper();
        ClientList list = new ClientList();
        List<Client> clientList = new ArrayList<>();
        clients.forEach(p -> clientList.add(mapper.fromDao(p)));
        list.setClients(clientList);

        return list;
    }

    @Override
    public Client add(Client client) {
        //TODO: Deal with exceptions
        //TODO: Deal with duplicate
        //TODO: Validate input
        clientRepo.save(getMapper().toDao(client));
        return client;
    }

    @Override
    public Client get(String nif) {
        pt.multicert.client.api.dal.entity.Client client = clientRepo.findForNif(nif);
        if (client != null) {
            return getMapper().fromDao(client);
        }
        return null;
    }

    @Override
    public void delete(String nif) {
        pt.multicert.client.api.dal.entity.Client client = clientRepo.findForNif(nif);
        if (client != null) {
            clientRepo.delete(client);
        }
    }

    private ClientMapper getMapper() {
        return Mappers.getMapper(ClientMapper.class);
    }
}
