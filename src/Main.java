import javax.swing.*;

public class Main{
    public static void main(String[] args){
        JFrame frame = new JFrame("Comet the pet");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,450);

        JButton Boton1 = new JButton("Boton1");
        JButton Boton2 = new JButton("Boton2");
        JButton Boton3 = new JButton("Boton3");
        JButton Boton4 = new JButton("Boton4");
        frame.add(Boton1);

        JLabel Label1 = new JLabel("Nombre");
        frame.add(Label1);

        frame.setVisible(true);
    }

}