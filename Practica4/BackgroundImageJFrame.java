import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import java.util.*;
import javax.imageio.*;
import java.lang.Integer;
import java.awt.Toolkit;

class BackgroundImageJFrame extends JFrame implements ActionListener{
  BufferedImage imagen;
  BufferedImage subImagen;
  ArrayList<String> categorias;
  ImageIcon lblimagen;
  JLabel monito;
  JLabel lblPalabra;
  JLabel lblRespuesta;
  JLabel lblLongitud;
  int indiceX = 126;
  int indice = 2;
  int errores = 0;
  int puntaje = 0;
  int numUser;
  String s;
  String original;
  String spuntaje;
  String longitud;
  JButton btnsAbecedario[] = new JButton[27];
  JButton btnSalir;
  Thread hilo;
  Boolean gano = new Boolean(false);
  ArrayList<String> puntajes = new ArrayList<String>();
  MiReproductor mr = new MiReproductor();
  public BackgroundImageJFrame(ArrayList<String> categorias,int puntaje, int numUser){
      this.categorias = categorias;
      this.numUser = numUser;
      this.puntaje = puntaje;
      setTitle("");
      setSize(628,885);
      setLocationRelativeTo(null);
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      setVisible(true);

      setLayout(new BorderLayout());
      JLabel background=new JLabel(new ImageIcon("D:/Practica4/Imagenes/Escenario.png"));

      add(background);
      background.setLayout(null);

      btnsAbecedario[0] = new JButton();
      btnsAbecedario[0].setIcon(new ImageIcon(((new ImageIcon("./Botones/A.png")).getImage()).getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH)));
      btnsAbecedario[0].addActionListener(this);
      btnsAbecedario[0].setBounds(75,490,55,40);
      background.add(btnsAbecedario[0]);

      btnsAbecedario[1] = new JButton();
      btnsAbecedario[1].setIcon(new ImageIcon(((new ImageIcon("./Botones/B.png")).getImage()).getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH)));
      btnsAbecedario[1].addActionListener(this);
      btnsAbecedario[1].setBounds(145,490,55,40);
      background.add(btnsAbecedario[1]);

      btnsAbecedario[2] = new JButton();
      btnsAbecedario[2].setIcon(new ImageIcon(((new ImageIcon("./Botones/C.png")).getImage()).getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH)));
      btnsAbecedario[2].addActionListener(this);
      btnsAbecedario[2].setBounds(215,490,55,40);
      background.add(btnsAbecedario[2]);

      btnsAbecedario[3] = new JButton();
      btnsAbecedario[3].setIcon(new ImageIcon(((new ImageIcon("./Botones/D.png")).getImage()).getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH)));
      btnsAbecedario[3].addActionListener(this);
      btnsAbecedario[3].setBounds(285,490,55,40);
      background.add(btnsAbecedario[3]);

      btnsAbecedario[4] = new JButton();
      btnsAbecedario[4].setIcon(new ImageIcon(((new ImageIcon("./Botones/E.png")).getImage()).getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH)));
      btnsAbecedario[4].addActionListener(this);
      btnsAbecedario[4].setBounds(355,490,55,40);
      background.add(btnsAbecedario[4]);

      btnsAbecedario[5] = new JButton();
      btnsAbecedario[5].setIcon(new ImageIcon(((new ImageIcon("./Botones/F.png")).getImage()).getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH)));
      btnsAbecedario[5].addActionListener(this);
      btnsAbecedario[5].setBounds(425,490,55,40);
      background.add(btnsAbecedario[5]);

      btnsAbecedario[6] = new JButton();
      btnsAbecedario[6].setIcon(new ImageIcon(((new ImageIcon("./Botones/G.png")).getImage()).getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH)));
      btnsAbecedario[6].addActionListener(this);
      btnsAbecedario[6].setBounds(495,490,55,40);
      background.add(btnsAbecedario[6]);
      //linea2
      btnsAbecedario[7] = new JButton();
      btnsAbecedario[7].setIcon(new ImageIcon(((new ImageIcon("./Botones/H.png")).getImage()).getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH)));
      btnsAbecedario[7].addActionListener(this);
      btnsAbecedario[7].setBounds(75,540,55,40);
      background.add(btnsAbecedario[7]);

      btnsAbecedario[8] = new JButton();
      btnsAbecedario[8].setIcon(new ImageIcon(((new ImageIcon("./Botones/I.png")).getImage()).getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH)));
      btnsAbecedario[8].addActionListener(this);
      btnsAbecedario[8].setBounds(145,540,55,40);
      background.add(btnsAbecedario[8]);

      btnsAbecedario[9] = new JButton();
      btnsAbecedario[9].setIcon(new ImageIcon(((new ImageIcon("./Botones/J.png")).getImage()).getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH)));
      btnsAbecedario[9].addActionListener(this);
      btnsAbecedario[9].setBounds(215,540,55,40);
      background.add(btnsAbecedario[9]);

      btnsAbecedario[10] = new JButton();
      btnsAbecedario[10].setIcon(new ImageIcon(((new ImageIcon("./Botones/K.png")).getImage()).getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH)));
      btnsAbecedario[10].addActionListener(this);
      btnsAbecedario[10].setBounds(285,540,55,40);
      background.add(btnsAbecedario[10]);

      btnsAbecedario[11] = new JButton();
      btnsAbecedario[11].setIcon(new ImageIcon(((new ImageIcon("./Botones/L.png")).getImage()).getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH)));
      btnsAbecedario[11].addActionListener(this);
      btnsAbecedario[11].setBounds(355,540,55,40);
      background.add(btnsAbecedario[11]);

      btnsAbecedario[12] = new JButton();
      btnsAbecedario[12].setIcon(new ImageIcon(((new ImageIcon("./Botones/M.png")).getImage()).getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH)));
      btnsAbecedario[12].addActionListener(this);
      btnsAbecedario[12].setBounds(425,540,55,40);
      background.add(btnsAbecedario[12]);

      btnsAbecedario[13] = new JButton();
      btnsAbecedario[13].setIcon(new ImageIcon(((new ImageIcon("./Botones/N.png")).getImage()).getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH)));
      btnsAbecedario[13].addActionListener(this);
      btnsAbecedario[13].setBounds(495,540,55,40);
      background.add(btnsAbecedario[13]);
      //linea3
      btnsAbecedario[14] = new JButton();
      btnsAbecedario[14].setIcon(new ImageIcon(((new ImageIcon("./Botones/na.png")).getImage()).getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH)));
      btnsAbecedario[14].addActionListener(this);
      btnsAbecedario[14].setBounds(75,590,55,40);
      background.add(btnsAbecedario[14]);

      btnsAbecedario[15] = new JButton();
      btnsAbecedario[15].setIcon(new ImageIcon(((new ImageIcon("./Botones/O.png")).getImage()).getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH)));
      btnsAbecedario[15].addActionListener(this);
      btnsAbecedario[15].setBounds(145,590,55,40);
      background.add(btnsAbecedario[15]);

      btnsAbecedario[16] = new JButton();
      btnsAbecedario[16].setIcon(new ImageIcon(((new ImageIcon("./Botones/P.png")).getImage()).getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH)));
      btnsAbecedario[16].addActionListener(this);
      btnsAbecedario[16].setBounds(215,590,55,40);
      background.add(btnsAbecedario[16]);

      btnsAbecedario[17] = new JButton();
      btnsAbecedario[17].setIcon(new ImageIcon(((new ImageIcon("./Botones/Q.png")).getImage()).getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH)));
      btnsAbecedario[17].addActionListener(this);
      btnsAbecedario[17].setBounds(285,590,55,40);
      background.add(btnsAbecedario[17]);

      btnsAbecedario[18] = new JButton();
      btnsAbecedario[18].setIcon(new ImageIcon(((new ImageIcon("./Botones/R.png")).getImage()).getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH)));
      btnsAbecedario[18].addActionListener(this);
      btnsAbecedario[18].setBounds(355,590,55,40);
      background.add(btnsAbecedario[18]);

      btnsAbecedario[19] = new JButton();
      btnsAbecedario[19].setIcon(new ImageIcon(((new ImageIcon("./Botones/S.png")).getImage()).getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH)));
      btnsAbecedario[19].addActionListener(this);
      btnsAbecedario[19].setBounds(425,590,55,40);
      background.add(btnsAbecedario[19]);

      btnsAbecedario[20] = new JButton();
      btnsAbecedario[20].setIcon(new ImageIcon(((new ImageIcon("./Botones/T.png")).getImage()).getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH)));
      btnsAbecedario[20].addActionListener(this);
      btnsAbecedario[20].setBounds(495,590,55,40);
      background.add(btnsAbecedario[20]);
      //linea4
      btnsAbecedario[21] = new JButton();
      btnsAbecedario[21].setIcon(new ImageIcon(((new ImageIcon("./Botones/U.png")).getImage()).getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH)));
      btnsAbecedario[21].addActionListener(this);
      btnsAbecedario[21].setBounds(125,640,55,40);
      background.add(btnsAbecedario[21]);

      btnsAbecedario[22] = new JButton();
      btnsAbecedario[22].setIcon(new ImageIcon(((new ImageIcon("./Botones/V.png")).getImage()).getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH)));
      btnsAbecedario[22].addActionListener(this);
      btnsAbecedario[22].setBounds(195,640,55,40);
      background.add(btnsAbecedario[22]);

      btnsAbecedario[23] = new JButton();
      btnsAbecedario[23].setIcon(new ImageIcon(((new ImageIcon("./Botones/W.png")).getImage()).getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH)));
      btnsAbecedario[23].addActionListener(this);
      btnsAbecedario[23].setBounds(265,640,55,40);
      background.add(btnsAbecedario[23]);

      btnsAbecedario[24] = new JButton();
      btnsAbecedario[24].setIcon(new ImageIcon(((new ImageIcon("./Botones/X.png")).getImage()).getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH)));
      btnsAbecedario[24].addActionListener(this);
      btnsAbecedario[24].setBounds(335,640,55,40);
      background.add(btnsAbecedario[24]);

      btnsAbecedario[25] = new JButton();
      btnsAbecedario[25].setIcon(new ImageIcon(((new ImageIcon("./Botones/Y.png")).getImage()).getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH)));
      btnsAbecedario[25].addActionListener(this);
      btnsAbecedario[25].setBounds(405,640,55,40);
      background.add(btnsAbecedario[25]);

      btnsAbecedario[26] = new JButton();
      btnsAbecedario[26].setIcon(new ImageIcon(((new ImageIcon("./Botones/Z.png")).getImage()).getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH)));
      btnsAbecedario[26].addActionListener(this);
      btnsAbecedario[26].setBounds(475,640,55,40);
      background.add(btnsAbecedario[26]);

      btnSalir = new JButton();
      btnSalir.setIcon(new ImageIcon(((new ImageIcon("./Imagenes/Salir.png")).getImage()).getScaledInstance(55, 60, java.awt.Image.SCALE_SMOOTH)));
      btnSalir.addActionListener(this);
      btnSalir.setBounds(495,700,55,60);
      btnSalir.setBorder(null);
      background.add(btnSalir);

      JLabel horca = new JLabel();
      horca.setBounds(75,0,270,500);
      horca.setIcon(new ImageIcon(((new ImageIcon("./Imagenes/Horca1.png")).getImage()).getScaledInstance(270, 500, java.awt.Image.SCALE_SMOOTH)));
      background.add(horca);

      lblPalabra = new JLabel("");
      lblPalabra.setBounds(350,0,100,30);
      lblPalabra.setVisible(false);
      background.add(lblPalabra);

      lblRespuesta = new JLabel("");
      lblRespuesta.setBounds(350,70,250,75);
      background.add(lblRespuesta);

      s = LogicaP.generar(categorias,lblPalabra,lblRespuesta);
      longitud = "Longitud: "+String.valueOf(s.length());
      lblLongitud = new JLabel(longitud);
      lblLongitud.setBounds(350,0,200,75);
      background.add(lblLongitud);

      try {
        imagen = ImageIO.read(new File("./Imagenes/SpritesFinal1.png"));
      }catch (Exception e) {
        System.out.println("Error al cargar la imagen");
      }
      subImagen = imagen.getSubimage(0,0,126,350);
      lblimagen = new ImageIcon(subImagen);
      monito = new JLabel();
      monito.setBounds(185,50,126,350);
      monito.setIcon(lblimagen);
      background.add(monito);

      setSize(627,884);
      setSize(628,885);
  }
  public void derrota(){
    // spuntaje = Integer.toString((int)puntaje);
    // Archivo.modificarFichero("D:/Practica4/UsersPasswords/Puntajes.txt",numUser,spuntaje);
    puntajes = Archivo.leerTodo("D:/Practica4/UsersPasswords/Puntajes.txt");
    if(puntaje>Integer.parseInt(puntajes.get(numUser))) {
      puntajes.set(numUser,String.valueOf(puntaje));
      Archivo.reescribirArchivoPuntaje(puntajes);
      JOptionPane.showMessageDialog(null,"Partida terminada se ha actualizado tu puntuacion mas alta, la palabra fue: "+s);
    }else{
      JOptionPane.showMessageDialog(null,"Partida terminada, la palabra fue: "+s);
    }
    MenuJuego mj = new MenuJuego(numUser);
    this.dispose();
  }
  public void iniciarHilo(){
    hilo = new Thread(new Runnable(){
      public void run(){
        mr.inicializar();
        mr.reproducirNota(60,1,750);
        mr.finalizar();
      }
    });
    hilo.start();
  }
  public void botonPresionado(String letra){
    original = lblRespuesta.getText();
    LogicaP lp = new LogicaP(lblPalabra,lblRespuesta);
    Boolean error = lp.comprobar(letra,s,original);
    if(error.equals(false)){
      original = lblRespuesta.getText();
      if(original.equalsIgnoreCase(s)){
        ganar();
      }
    }
    if(error.equals(true)){
      iniciarHilo();
      subImagen = imagen.getSubimage(indiceX,0,126,350);
      lblimagen = new ImageIcon(subImagen);
      monito.setIcon(lblimagen);
      indiceX = ((indice)%7) * 126;
      indice++;
      errores++;
      if(errores==6){
        derrota();
      }
    }
  }
  public void ganar(){
    JOptionPane.showMessageDialog(null,"Gano, siguiente juego");
    this.dispose();
    puntaje++;
    BackgroundImageJFrame bijf =new BackgroundImageJFrame(categorias,puntaje,numUser);
  }
  public void actionPerformed(ActionEvent event){
  	if(event.getSource() == btnsAbecedario[0]){
      botonPresionado("A");
      btnsAbecedario[0].setVisible(false);
    }else if(event.getSource() == btnsAbecedario[1]){
      botonPresionado("B");
      btnsAbecedario[1].setVisible(false);
    }else if(event.getSource() == btnsAbecedario[2]){
      botonPresionado("C");
      btnsAbecedario[2].setVisible(false);
    }else if(event.getSource() == btnsAbecedario[3]){
      botonPresionado("D");
      btnsAbecedario[3].setVisible(false);
    }else if(event.getSource() == btnsAbecedario[4]){
      botonPresionado("E");
      btnsAbecedario[4].setVisible(false);
    }else if(event.getSource() == btnsAbecedario[5]){
      botonPresionado("F");
      btnsAbecedario[5].setVisible(false);
    }else if(event.getSource() == btnsAbecedario[6]){
      botonPresionado("G");
      btnsAbecedario[6].setVisible(false);
    }else if(event.getSource() == btnsAbecedario[7]){
      botonPresionado("H");
      btnsAbecedario[7].setVisible(false);
    }else if(event.getSource() == btnsAbecedario[8]){
      botonPresionado("I");
      btnsAbecedario[8].setVisible(false);
    }else if(event.getSource() == btnsAbecedario[9]){
      botonPresionado("J");
      btnsAbecedario[9].setVisible(false);
    }else if(event.getSource() == btnsAbecedario[10]){
      botonPresionado("K");
      btnsAbecedario[10].setVisible(false);
    }else if(event.getSource() == btnsAbecedario[11]){
      botonPresionado("L");
      btnsAbecedario[11].setVisible(false);
    }else if(event.getSource() == btnsAbecedario[12]){
      botonPresionado("M");
      btnsAbecedario[12].setVisible(false);
    }else if(event.getSource() == btnsAbecedario[13]){
      botonPresionado("N");
      btnsAbecedario[13].setVisible(false);
    }else if(event.getSource() == btnsAbecedario[14]){
      botonPresionado("Ñ");
      btnsAbecedario[14].setVisible(false);
    }else if(event.getSource() == btnsAbecedario[15]){
      botonPresionado("O");
      btnsAbecedario[15].setVisible(false);
    }else if(event.getSource() == btnsAbecedario[16]){
      botonPresionado("P");
      btnsAbecedario[16].setVisible(false);
    }else if(event.getSource() == btnsAbecedario[17]){
      botonPresionado("Q");
      btnsAbecedario[17].setVisible(false);
    }else if(event.getSource() == btnsAbecedario[18]){
      botonPresionado("R");
      btnsAbecedario[18].setVisible(false);
    }else if(event.getSource() == btnsAbecedario[19]){
      botonPresionado("S");
      btnsAbecedario[19].setVisible(false);
    }else if(event.getSource() == btnsAbecedario[20]){
      botonPresionado("T");
      btnsAbecedario[20].setVisible(false);
    }else if(event.getSource() == btnsAbecedario[21]){
      botonPresionado("U");
      btnsAbecedario[21].setVisible(false);
    }else if(event.getSource() == btnsAbecedario[22]){
      botonPresionado("V");
      btnsAbecedario[22].setVisible(false);
    }else if(event.getSource() == btnsAbecedario[23]){
      botonPresionado("W");
      btnsAbecedario[23].setVisible(false);
    }else if(event.getSource() == btnsAbecedario[24]){
      botonPresionado("X");
      btnsAbecedario[24].setVisible(false);
    }else if(event.getSource() == btnsAbecedario[25]){
      botonPresionado("Y");
      btnsAbecedario[25].setVisible(false);
    }else if(event.getSource() == btnsAbecedario[26]){
      botonPresionado("Z");
      btnsAbecedario[26].setVisible(false);
    }else if(event.getSource() == btnSalir){
      this.dispose();
    }
  }
}
