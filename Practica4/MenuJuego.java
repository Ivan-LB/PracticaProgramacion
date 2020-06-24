import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

class MenuJuego extends JFrame implements ActionListener{
JPanel panel;
int numUser;
JButton btnPuntaje;
JButton btnIniciar;
JCheckBox opciones[] = new JCheckBox[8];
String categorias[] = {"Peliculas","Frutas","Paises","Bebidas","Comidas","Colores","Instrumentos","Carros"};
Boolean prueba = new Boolean(false);
Boolean inicio = new Boolean(false);
ArrayList<String> arrayCategorias = new ArrayList<String>();
ArrayList<String> arrayScore = new ArrayList<String>();
JLabel lbl1;
JLabel lbl2;
JLabel lbl3;
JLabel lbl4;
JLabel lbl5;
JLabel lbl6;
JLabel lbl7;
JLabel lbl8;


	public MenuJuego(int numUser){
		this.numUser=numUser;
		arrayScore = Archivo.leerTodo("D:/Practica4/UsersPasswords/Puntajes.txt");
		panel = new JPanel();
		panel.setLayout(null);
		Color cGris = new Color(211,211,211);
		Color cAzul = new Color(173, 216, 230);
		panel.setBackground(cAzul);

		//1ra parte
   	lbl1=new JLabel(new ImageIcon(((new ImageIcon("./Imagenes/peliculas.png")).getImage()).getScaledInstance(30,30,java.awt.Image.SCALE_SMOOTH)));
    lbl1.setBounds(45,10,30,30);
    lbl2=new JLabel(new ImageIcon(((new ImageIcon("./Imagenes/fruta.png")).getImage()).getScaledInstance(30,30,java.awt.Image.SCALE_SMOOTH)));
    lbl2.setBounds(45,50,30,30);
    lbl3=new JLabel(new ImageIcon(((new ImageIcon("./Imagenes/paises.png")).getImage()).getScaledInstance(30,30,java.awt.Image.SCALE_SMOOTH)));
    lbl3.setBounds(45,90,30,30);
    lbl4=new JLabel(new ImageIcon(((new ImageIcon("./Imagenes/bebidas.png")).getImage()).getScaledInstance(30,30,java.awt.Image.SCALE_SMOOTH)));
    lbl4.setBounds(45,130,30,30);
    //2da parte
    lbl5=new JLabel(new ImageIcon(((new ImageIcon("./Imagenes/comidas.png")).getImage()).getScaledInstance(30,30,java.awt.Image.SCALE_SMOOTH)));
    lbl5.setBounds(255,10,30,30);
    lbl6=new JLabel(new ImageIcon(((new ImageIcon("./Imagenes/colores.png")).getImage()).getScaledInstance(30,30,java.awt.Image.SCALE_SMOOTH)));
    lbl6.setBounds(255,50,30,30);
    lbl7=new JLabel(new ImageIcon(((new ImageIcon("./Imagenes/instrumentos.png")).getImage()).getScaledInstance(30,30,java.awt.Image.SCALE_SMOOTH)));
    lbl7.setBounds(255,90,30,30);
    lbl8=new JLabel(new ImageIcon(((new ImageIcon("./Imagenes/carros.png")).getImage()).getScaledInstance(30,30,java.awt.Image.SCALE_SMOOTH)));
    lbl8.setBounds(255,130,30,30);


		for(int i=0, y=10; i<4; i++, y+=40){
			opciones[i] = new JCheckBox(categorias[i]);
			opciones[i].setBounds(90,y,120,30);
			opciones[i].setBackground(cAzul);
			panel.add(opciones[i]);
		}
		for(int i=4, y=10; i<8; i++, y+=40){
			opciones[i] = new JCheckBox(categorias[i]);
			opciones[i].setBounds(300,y,120,30);
			opciones[i].setBackground(cAzul);
			panel.add(opciones[i]);
		}

		btnPuntaje = new JButton("Mostrar Puntajes");
		btnPuntaje.setVerticalAlignment(SwingConstants.CENTER);
		btnPuntaje.setBackground(cGris);
		btnPuntaje.setBounds(5,200,150,50);
		btnPuntaje.addActionListener(this);

		btnIniciar = new JButton("Comenzar Juego");
		btnIniciar.setVerticalAlignment(SwingConstants.CENTER);
		btnIniciar.setBackground(cGris);
		btnIniciar.setBounds(280,200,150,50);
		btnIniciar.addActionListener(this);

		panel.add(btnPuntaje);panel.add(btnIniciar);
		panel.add(lbl1);panel.add(lbl2);panel.add(lbl3);panel.add(lbl4);panel.add(lbl5);panel.add(lbl6);panel.add(lbl7);panel.add(lbl8);

		this.add(panel);
	  this.setTitle(" Menu Juego ");
    this.setSize(440,300);
    this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
    this.setVisible(true);
    this.setLocationRelativeTo(null);
		this.setResizable(false);
	}
	public void actionPerformed(ActionEvent event){
		if(event.getSource() == this.btnIniciar){
			for (int i=0; i<8; i++) {
				prueba = opciones[i].isSelected();
				if(prueba.equals(true)){
					arrayCategorias.add(categorias[i]);
					inicio = true;
				}
			}
			if(inicio == true){
				BackgroundImageJFrame bijf = new BackgroundImageJFrame(arrayCategorias,0,numUser);
				this.dispose();
			}else{
				JOptionPane.showMessageDialog(null,"No se selecciono ninguna categoria");
			}
		}else if (event.getSource() == this.btnPuntaje ){
			JOptionPane.showMessageDialog(null, "Su puntaje mas alto es: " + arrayScore.get(numUser));
		}
	}
}
