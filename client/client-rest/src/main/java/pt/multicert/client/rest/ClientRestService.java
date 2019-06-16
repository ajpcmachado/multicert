package pt.multicert.client.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import pt.multicert.client.rest.bean.Client;
import pt.multicert.client.rest.bean.ClientList;

@Path("/client/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface ClientRestService {

    /**
     *  Get the list of clients
     * @param name name to filter. Can be null to return all clients
     * @return
     */
    @GET
    @Path("/")//$NON-NLS-1$
    public ClientList getList(@QueryParam("name") String name);

    /**
     * Add a client. The NIF should be unique
     * @param client to add
     * @return
     */
    @PUT
    @Path("/")//$NON-NLS-1$
    @Produces(MediaType.APPLICATION_JSON)
    public Client add(Client client);

    /**
     * Search for client
     * @param nif of a client
     * @return
     */
    @GET
    @Path("/{nif}/")//$NON-NLS-1$
    @Produces(MediaType.APPLICATION_JSON)
    public Client get(@PathParam("nif") String nif);

    /**
     * Delete a client
     * @param nif to delete
     */
    @DELETE
    @Path("/{nif}/")//$NON-NLS-1$
    @Produces(MediaType.APPLICATION_JSON)
    public void delete(@PathParam("nif") String nif);
}
