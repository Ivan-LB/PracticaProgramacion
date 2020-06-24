import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

class Login extends JFrame implements ActionListener{
  JPanel panel;
  Font font = new Font("arial",Font.BOLD,25);
  JLabel lblUsername;
  JLabel lblPassword;
  JTextField txtUsername;
  JPasswordField txtPassword;
  JButton btnLogin;
  JButton btnBack;
  Boolean iguales = new Boolean(false);
  int numUser = 0;
  int asegurar;

  public Login(){

    panel = new JPanel();
    panel.setLayout(null);
    Color cGris = new Color(211,211,211);
    Color cAzul = new Color(173, 216, 230);

    panel.setBackground(cAzul);

    lblUsername= new JLabel("Usuario: ");
    lblUsername.setBounds(25,25,115,30);
    lblUsername.setFont(font);
    lblPassword = new JLabel("Clave: ");
    lblPassword.setBounds(50,85,100,30);
    lblPassword.setFont(font);
    txtUsername = new JTextField();
    txtUsername.setBounds(180,25,250,30);
    txtUsername.setBorder(null);
    txtUsername.setFont(font);
    txtPassword = new  JPasswordField();
    txtPassword.setBounds(180,85,250,30);
    txtPassword.setBorder(null);
    txtPassword.setFont(font);
    btnLogin = new JButton("Ingresar");
    btnLogin.setBounds(270,175,100,30);
    btnLogin.setBackground(cGris);
    btnLogin.addActionListener(this);
    btnBack = new JButton("Regresar");
    btnBack.setBounds(90,175,100,30);
    btnBack.setBackground(cGris);
    btnBack.addActionListener(this);

    panel.add(lblUsername);
    panel.add(lblPassword);
    panel.add(txtUsername);
    panel.add(txtPassword);
    panel.add(btnLogin);
    panel.add(btnBack);

    this.add(panel);
    this.setTitle(" Login ");
    this.setSize(480,300);
    this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
    this.setVisible(true);
    this.setLocationRelativeTo(null);
    this.setResizable(false);

  }
  public void actionPerformed(ActionEvent event){
    if(event.getSource() == this.btnLogin){
      try{
        File usuarios = new File("D:/Practica4/UsersPasswords/Users.txt");
        File claves = new File ("D:/Practica4/UsersPasswords/Passwords.txt");

        FileReader fr1 = new FileReader(usuarios);
        FileReader fr2 = new FileReader(claves);

        BufferedReader bf1 = new BufferedReader(fr1);
        BufferedReader bf2 = new BufferedReader(fr2);

        String sCadena1 = bf1.readLine();
        String sCadena2 = bf2.readLine();

        while ((sCadena1!=null)||(sCadena2!=null)){
          if(sCadena1.equals(txtUsername.getText())){
            if(sCadena2.equals(txtPassword.getText())){
             this.dispose();
             iguales = true;
             MenuJuego mj = new MenuJuego(numUser);
            }
          }
          sCadena1 = bf1.readLine();
          sCadena2 = bf2.readLine();
          if(iguales.equals(false)){
            numUser++;
          }
        }
        if(iguales.equals(false)){
          System.out.println(iguales);
          JOptionPane.showMessageDialog(null,"Verifique que escribio correctamente su usuario y contraseña");
        }
      }catch(Exception e){
        e.printStackTrace();
      }
    }else if(event.getSource() == this.btnBack){
      this.dispose();
      InicioSesion is = new InicioSesion();
    }
  }
}
