package pt.multicert.client.api.dal.repo;

import java.util.List;

import pt.multicert.client.api.dal.entity.Client;

/**
 * Client table manipulation interface
 * @author artur
 *
 */
public interface ClientRepo {

	public void save(Client c);

    public List<Client> findAllForName(String nome);
    
    public Client findForNif(String nif);
    
    public void delete(Client c);

    public List<Client> findAll(); 
}
