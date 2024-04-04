package ext;

import dao.IDao;
import org.springframework.stereotype.Component;

//c est une extension
//version web service
@Component("DaoImpl2")
public class DaoImpl2 implements IDao {
    @Override
    public double getData() {
        System.out.println("Version Web service");
        double data=55;
        return data;
    }
}