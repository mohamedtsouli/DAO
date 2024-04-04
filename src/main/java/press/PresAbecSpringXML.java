package press;

import metier.IMetier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PresAbecSpringXML {
    public static void main(String[] args) {
        //demarrer spring avec l object applicationcontext
        ApplicationContext springContext=new ClassPathXmlApplicationContext("config.xml"); //je dis a sprinf va lire le fichier config.xml =>spring va creer un objet dao et un objet metier et fait l injection des dependances
        IMetier metier=springContext.getBean(IMetier.class);
        System.out.println("Res="+metier.calcul());//ce n est pas moi qui creer les classes ces spring qui le fait au demarrage je modifie les version dans fichiers config.xml , en utilisant spring on injecte les dependances juste avec le fichier config.xml

    }
}