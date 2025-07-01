import javax.swing.*;
import java.awt.*;

public class Main{
    public static void main(String[] args){

        JFrame login  = new JFrame("Comet the pet");
        InicioSesion InicioSesion = new InicioSesion();
        login.setContentPane(InicioSesion.getIniciosesion());
        login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        login.setSize(1200,675);

        login.setVisible(true);
    }

}