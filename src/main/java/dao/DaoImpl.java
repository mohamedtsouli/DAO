package dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//version base de données
@Repository("dao")
public class DaoImpl implements IDao{

    @Override
    public double getData() {
        System.out.println("version base de données");
        double data=34;
        return data;

    }
}