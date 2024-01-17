package sub2.dataMapper.client;

import sub2.dataMapper.DataMapperException;
import sub2.mvc.client.Client;

public interface ClientDataMapper {
    Client find(int clientId);

    void insert(Client client) throws DataMapperException;

    void update(Client client) throws DataMapperException;

    void delete(Client client) throws DataMapperException;
}
