package sub2.dataMapper.comanda;

import sub2.dataMapper.DataMapperException;
import sub2.mvc.comanda.Comanda;

public interface ComandaDataMapper {

    Comanda find(int comandaId);

    void insert(Comanda comanda) throws DataMapperException;

    void update(Comanda comanda) throws DataMapperException;

    void delete(Comanda comanda) throws DataMapperException;
}
