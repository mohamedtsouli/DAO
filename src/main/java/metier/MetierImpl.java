package metier;

import dao.IDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service

public class MetierImpl implements IMetier {
    // @Autowired//injection de dependance automatique (je dis à spring qd tu creer un object de cette classe affecte moi une variable de type idao
    private IDao dao; //couplage faible classe metier depend d'implementation ideao =>la classe metier est prête de travailler avec n importe classe qui travaille avec cette interface  idao
    public MetierImpl(IDao dao){ //j aurais pas besoin de authowired car je vais faire les dependances a travers un constructeur
        this.dao=dao;
    }
    @Override
    public double calcul(){
        double d=dao.getData();
        double res=d*11.4;
        return res;
    }
    //couplage faible la classe metier depend directement de l interface
    //la valeur de dao est null car elle est private donc on a besoin de setters and getters
    /**
     * pour permettre de modifier la avelur de la varianle dao
     * injecter un objet de type idao (objet d une classe qui implemente l interface idao)
     */
    // public void setDao(IDao dao) {
    //this.dao = dao;
    //}
}