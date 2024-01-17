package sub2.dataMapper.magazin;

import sub2.dataMapper.DataMapperException;
import sub2.mvc.magazin.Magazin;

public interface MagazinDataMapper {

    void insert(Magazin magazin) throws DataMapperException;

    Magazin find(String denumireMagazin);

    void update(Magazin magazin) throws DataMapperException;

    void delete(Magazin magazin) throws DataMapperException;
}
