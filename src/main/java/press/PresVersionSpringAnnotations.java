package press;

import metier.IMetier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PresVersionSpringAnnotations {
    public static void main(String[] args) {
        ApplicationContext context =new AnnotationConfigApplicationContext("dao","metier");//faut indiquer les package qui doit scanner(ou les classes on componnent)
        IMetier metier=context.getBean(IMetier.class);
        System.out.println("RES="+metier.calcul());
    }
}