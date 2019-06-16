package pt.multicert.client.api.mapper;

import javax.annotation.Generated;
import pt.multicert.client.rest.bean.Client;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-06-16T23:02:31+0100",
    comments = "version: 1.3.0.Beta2, compiler: javac, environment: Java 1.8.0_211 (Oracle Corporation)"
)
public class ClientMapperImpl implements ClientMapper {

    @Override
    public pt.multicert.client.api.dal.entity.Client toDao(Client c) {
        if ( c == null ) {
            return null;
        }

        pt.multicert.client.api.dal.entity.Client client = new pt.multicert.client.api.dal.entity.Client();

        client.setNome( c.getNome() );
        client.setNif( c.getNif() );
        client.setMorada( c.getMorada() );
        client.setTelefone( c.getTelefone() );

        return client;
    }

    @Override
    public Client fromDao(pt.multicert.client.api.dal.entity.Client c) {
        if ( c == null ) {
            return null;
        }

        Client client = new Client();

        client.setNome( c.getNome() );
        client.setNif( c.getNif() );
        client.setMorada( c.getMorada() );
        client.setTelefone( c.getTelefone() );

        return client;
    }
}
