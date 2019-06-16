
package pt.multicert.client.rest.bean;

import java.util.List;

public class ClientList {
    private List<Client> clients;
    

    /**
     * @return the clients
     */
    public List<Client> getClients() {
        return clients;
    }

    /**
     * @param clients the clients to set
     */
    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "ClientList [clients=" + clients + "]";
    }
}
