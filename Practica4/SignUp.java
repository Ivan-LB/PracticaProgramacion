import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.awt.Dimension;

class SignUp extends JFrame implements ActionListener{
  /* Declarar Variables */
  JPanel panel;
  Font font = new Font("arial",Font.BOLD,25);
  JLabel lblUser;
  JLabel lblPassword;
  JTextField txtUserNew;
  JCheckBox visible;
  JPasswordField txtPasswordNew;
  JButton btnListo;
  JButton btnBack;
  JToggleButton btnVisible;
  ArrayList<String> usuarios = new ArrayList<String>();
  int flag = 0;

  public SignUp(){
      /* Ajustar Variables */
      panel = new JPanel();
      panel.setLayout(null);
      Color cGris = new Color(211,211,211);
      Color cAzul = new Color(173, 216, 230);
      panel.setBackground(cAzul);



      usuarios = Archivo.leerTodo("D:/Practica4/UsersPasswords/Users.txt");
      lblUser = new JLabel("Usuario: ", SwingConstants.RIGHT);
      lblUser.setBounds(15,25,120,30);
      lblUser.setFont(font);
      lblPassword = new JLabel("Clave: ", SwingConstants.RIGHT);
      lblPassword.setBounds(15,85,120,30);
      lblPassword.setFont(font);
      txtUserNew = new JTextField();
      txtUserNew.setBorder(null);
      txtUserNew.setBounds(140,25,200,30);
      txtUserNew.setFont(font);
      txtPasswordNew = new  JPasswordField();
      txtPasswordNew.setEchoChar('*');
      txtPasswordNew.setFont(font);
      txtPasswordNew.setBorder(null);
      txtPasswordNew.setBounds(140,85,200,30);
      btnListo = new JButton("Registrar");
      btnListo.setBounds(320,175,100,50);
      btnListo.setBackground(cGris);
      btnListo.addActionListener(this);
      btnBack = new JButton("Volver al menu");
      btnBack.setBounds(30,184,150,30);
      btnBack.setBackground(cGris);
      btnBack.addActionListener(this);
      btnVisible = new JToggleButton();
      btnVisible.setIcon(new ImageIcon(((new ImageIcon("./Imagenes/VisibleOff.png")).getImage()).getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH)));
      btnVisible.setSelectedIcon(new ImageIcon(((new ImageIcon("./Imagenes/VisibleOn.png")).getImage()).getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH)));
      btnVisible.setBounds(350,85,30,30);
      ItemListener itemListener = new ItemListener(){
        public void itemStateChanged(ItemEvent ItemEvent){
          int state = ItemEvent.getStateChange();
          if(state == ItemEvent.SELECTED){
            txtPasswordNew.setEchoChar((char)0);
          }else{
            txtPasswordNew.setEchoChar('*');
            txtPasswordNew.setFont(font);
          }
        }
      };
      btnVisible.addItemListener(itemListener);

      panel.add(lblUser);
      panel.add(lblPassword);
      panel.add(txtUserNew);
      panel.add(txtPasswordNew);
      panel.add(btnListo);
      panel.add(btnBack);
      panel.add(btnVisible);

      this.add(panel);
      this.setTitle(" Registro ");
  		this.setSize(450,300);
  		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
  		this.setVisible(true);
  		this.setLocationRelativeTo(null);
      this.setResizable(false);
  }
  public void actionPerformed(ActionEvent event){
  	if(event.getSource() == this.btnListo){
      if(txtUserNew.getText().isEmpty() == false){
        for (int i=0;i<usuarios.size(); i++) {
          if(txtUserNew.getText().equals(usuarios.get(i))) {
            JOptionPane.showMessageDialog(null,"El usuario ya existe intente con otro");
            flag++;
          }
        }
        if(flag==0){
          Archivo.CrearArchivo(txtUserNew.getText(),"Users.txt");
          Archivo.CrearArchivo(txtPasswordNew.getText(),"Passwords.txt");
          Archivo.CrearArchivo("0","Puntajes.txt");
          JOptionPane.showMessageDialog(null, "Usuario Registrado con exito...");
      	}
        txtUserNew.setText("");
        txtPasswordNew.setText("");
      }else{
        JOptionPane.showMessageDialog(null,"Falto de llenar uno de los espacios");
      }
    }else if(event.getSource() == this.btnBack){
      this.dispose();
      InicioSesion f = new InicioSesion();
    }
  }
}
