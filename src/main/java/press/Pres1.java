package press;

import dao.DaoImpl;
import ext.DaoImpl2;
import metier.MetierImpl;
//pres1 n est pas ferme a la modif car elle utilise le couplage fort (à chaque fois il y a une version on modifie) ,fait appel à des classe. on veut la rendre fermer à la modif car on la classe daoimpl et metier impl
//sol on fait l instanciation dynamique pour l injection de dependance
//press est une factory car la ou il ya l instanciation(les objets)
//instancition statique par new
//instanciation dynamique par forname ,new instance,invoke
public class Pres1 {
    public static void main(String[] args) {
        DaoImpl dao=new DaoImpl();
        MetierImpl metier=new MetierImpl(dao);//injection via le constructeur
        //metier.setDao(dao);//injection de dependance
        System.out.println("Res="+metier.calcul());
    }
}