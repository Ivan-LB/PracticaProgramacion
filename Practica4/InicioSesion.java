import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Dimension;



class InicioSesion extends JFrame implements ActionListener{
  /* Inicializacion de variables */
  JButton btnLogin;
  JButton btnSignUp;
  JPanel panel;
  JLabel lblV;

	public InicioSesion()
	{
    /* Asignacion variables */


    panel = new JPanel();
    panel.setLayout(null);
    Color cGris = new Color(211,211,211);
		Color cAzul = new Color(173, 216, 230);

    panel.setBackground(cAzul);
    //lblV= new JLabel(new ImageIcon("./Imagenes/inicio.png"));
    lblV=new JLabel(new ImageIcon(((new ImageIcon("./Imagenes/inicio.png")).getImage()).getScaledInstance(70,70,java.awt.Image.SCALE_SMOOTH)));
    lblV.setBounds(110,15,70,120);


    btnLogin = new JButton("Iniciar Sesion");
    btnLogin.setBounds(70,120,150,30);
    btnLogin.setBackground(cGris);
    btnLogin.setVerticalAlignment(SwingConstants.CENTER);
    btnLogin.addActionListener(this);

    btnSignUp = new JButton("Registrarse ");
    btnSignUp.setBounds(70,190,150,30);
    btnSignUp.setBackground(cGris);
    btnSignUp.setVerticalAlignment(SwingConstants.CENTER);
    btnSignUp.addActionListener(this);

    panel.add(btnLogin);
    panel.add(btnSignUp);
    panel.add(lblV);


    this.add(panel);
    this.setTitle(" Inicio ");
		this.setSize(300,300);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
    this.setResizable(false);

	}
  public void actionPerformed(ActionEvent event){
  		if(event.getSource() == this.btnLogin){
  			this.dispose();
        Login l = new Login();

  		}else if(event.getSource() == this.btnSignUp){
        this.dispose();
        SignUp su = new SignUp();
      }
  }
}
