import javax.management.StringValueExp;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InicioSesion {
    private JButton INICIARSESIONButton;
    private JButton CREARCUENTANUEVAButton;
    private JTextField correoElectronicoTextField;
    private JPasswordField contraseñaPasswordField;
    private JPanel iniciosesion;
    private JCheckBox mostrarContraseñaCheckBox;

    public InicioSesion() {
        INICIARSESIONButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usuario = correoElectronicoTextField.getText();
                String contraseña = String.valueOf(contraseñaPasswordField.getPassword());
                if (usuario.equals("Daniel") && contraseña.equals("123")){
                    JOptionPane.showMessageDialog(null, "Bienvenido");
                    JFrame menu = new JFrame("Comet the pet");
                    PantallaPrincipal PantallaPrincipal = new PantallaPrincipal();
                    menu.setSize(1200,675);
                    menu.setVisible(true);
                }
                else
                    JOptionPane.showMessageDialog(null,"Usuario o Contraseña Incorrecto");
            }
        });
        mostrarContraseñaCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (mostrarContraseñaCheckBox.isSelected()){
                    contraseñaPasswordField.setEchoChar((char)0);
                }
                else
                    contraseñaPasswordField.setEchoChar('*');
            }
        });
    }

    public JPanel getIniciosesion() {
        return iniciosesion;
    }
}
