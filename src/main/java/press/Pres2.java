package press;
import dao.DaoImpl;
import dao.IDao;
import metier.MetierImpl;
import java.io.FileNotFoundException;

import java.io.File;
import java.lang.reflect.Method;
import java.util.Scanner;
import metier.IMetier;
public class Pres2{
    public static void main(String[] args) throws Exception {
        //DaoImpl dao=new DaoImpl();
        //Scanner scanner=new Scanner(new File("config.txt"));
        //lire a partir du clavier:
        Scanner scanner=new Scanner(System.in);
        System.out.print("Donner la classe de la couche DAO:");
        String doaClassName=scanner.nextLine();//la premiere ligen du fichier
        Class cDao=Class.forName(doaClassName);
        IDao dao=(IDao)cDao.getConstructor().newInstance();
        //System.out.println(dao.getData());   //=>new DaoImpl sauf que celle ci est statique , j aurais version de base de donn"es si je veux version 2 je modifie fichier conf par ext.daoimpl2
        //instanciation dynamoque
        //MetierImpl metier=new MetierImpl();
        //creation objet metier :jelie le nom de la classe avec scanner .nextline
        //la main pour ecrire:
        System.out.print("Donner la classe de la couche metier:");
        String metierClassname=scanner.nextLine();
        //charger la classe en memoire
        Class cMetier=Class.forName(metierClassname);
        //creer un objet
        IMetier metier=(IMetier) cMetier.getConstructor(IDao.class).newInstance(dao);//de type imetier je conneit pas l objet mais je connais l interfacd



        //metier.setDao(dao);//injection de dependance je peux pas utiliser la methode metier.setdao car metier et de type imetier et ne contient pas setdao donc je vais la faire dynamiquement
        Method setDao=cMetier.getDeclaredMethod("setDao", IDao.class);   //methode avec ses arguments elle recoit type Idao

        setDao.invoke(metier,dao);//invoke :exceute moi caa ,  metier dont le parmaetre et dao =>injection de dependance
        System.out.println("RES="+metier.calcul());



    }
}