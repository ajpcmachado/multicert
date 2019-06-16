package pt.multicert.client.api.rest.impl;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import pt.multicert.client.api.dal.repo.ClientRepo;
import pt.multicert.client.rest.bean.Client;
import pt.multicert.client.rest.bean.ClientList;

@RunWith(MockitoJUnitRunner.class)
public class ClientRestServiceImplTest {
    
    @InjectMocks
    ClientRestServiceImpl clientRestServiceImpl;
    
    @Mock
    private ClientRepo clientRepo;
    
//    @Before
//    public void setup() throws Exception {
//        
//    }

    @Test
    public void testSuccess_getAll() {        
        Mockito.when(clientRepo.findAll()).thenReturn(getDbClientList());
        ClientList ret = clientRestServiceImpl.getList(null);
        Assert.assertNotNull(ret);
        Assert.assertEquals(getDbClientList().size(), ret.getClients().size());
    }
    
    @Test
    public void testSuccess_getAllForName() {        
        Mockito.when(clientRepo.findAllForName(Mockito.anyString())).thenReturn(getDbClientList());
        ClientList ret = clientRestServiceImpl.getList("teste");
        Assert.assertNotNull(ret);
        Assert.assertEquals(getDbClientList().size(), ret.getClients().size());
    }
    
    @Test
    public void testSuccess_getForNif() {        
        Mockito.when(clientRepo.findForNif(Mockito.anyString())).thenReturn(getDbClient());
        Client ret = clientRestServiceImpl.get("teste");
        Assert.assertNotNull(ret);
        Assert.assertEquals(getDbClient().getNif(), ret.getNif());
    }
    
    @Test
    public void testSuccess_add() {        
        Mockito.doNothing().when(clientRepo).save(Mockito.any(pt.multicert.client.api.dal.entity.Client.class));        
        Client c = new Client();
        c.setNif("12");
        Client ret = clientRestServiceImpl.add(c);
        Assert.assertNotNull(ret);
        Assert.assertEquals(c.getNif(), ret.getNif());
    }
    
    @Test
    public void testSuccess_delete() {        
        Mockito.doNothing().when(clientRepo).delete(Mockito.any(pt.multicert.client.api.dal.entity.Client.class));
        Mockito.when(clientRepo.findForNif(Mockito.anyString())).thenReturn(getDbClient());
        Client c = new Client();
        c.setNif("12");
        clientRestServiceImpl.delete("12");
    }
    
    //TODO: Do unsuccess tests
    
    private ArrayList<pt.multicert.client.api.dal.entity.Client> getDbClientList(){
        ArrayList<pt.multicert.client.api.dal.entity.Client> dbClient = new ArrayList<pt.multicert.client.api.dal.entity.Client>();
        dbClient.add(getDbClient());
        return dbClient;
    }
    
    private pt.multicert.client.api.dal.entity.Client getDbClient(){
        return new pt.multicert.client.api.dal.entity.Client(1l, "s", "s", "as","s");
    }

}
