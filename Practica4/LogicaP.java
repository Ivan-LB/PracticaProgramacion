import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.lang.StringBuilder;
import java.awt.event.*;

class LogicaP extends JFrame{
  JPanel panel;
  JLabel lblPalabra;
  JLabel lblRespuesta;
  JTextField txtRespuesta;
  ArrayList<String> categoria;
  JButton btnRespuesta;
  int errores = 0;
  int victorias = 0;

  public LogicaP(JLabel lblPalabra, JLabel lblRespuesta){
    this.lblPalabra = lblPalabra;
    this.lblRespuesta = lblRespuesta;
  }
  public LogicaP(ArrayList<String> categoria,JLabel lblPalabra, JLabel lblRespuesta){
    this.categoria = categoria;
    this.lblPalabra = lblPalabra;
    this.lblRespuesta = lblRespuesta;
  }
  public static String generar(ArrayList<String> categorias, JLabel lblPalabra, JLabel lblRespuesta){
    JLabel lblPalabraR = lblPalabra;
    JLabel lblRespuestaR = lblRespuesta;
    Random aleatorio = new Random(System.currentTimeMillis());
    ArrayList<String> arrayPeliculas = new ArrayList<String>();
    ArrayList<String> arrayFrutas = new ArrayList<String>();
    ArrayList<String> arrayPaises = new ArrayList<String>();
    ArrayList<String> arrayBebidas = new ArrayList<String>();
    ArrayList<String> arrayComidas = new ArrayList<String>();
    ArrayList<String> arrayColores = new ArrayList<String>();
    ArrayList<String> arrayInstrumentos = new ArrayList<String>();
    ArrayList<String> arrayArtistas = new ArrayList<String>();
    ArrayList<ArrayList<String>> arrayCategoriasActivas = new ArrayList();
    int rdmCategoria;
    int rdmPalabra;
    int errores = 0;
    String s;
    String original;

    for(int i=0; i<categorias.size();i++){
      if(categorias.get(i)=="Peliculas"){
        arrayPeliculas = Archivo.leerTodo("D:/Practica4/Categorias/Peliculas.txt");
        arrayCategoriasActivas.add(arrayPeliculas);
      }else if(categorias.get(i)=="Frutas"){
        arrayFrutas = Archivo.leerTodo("D:/Practica4/Categorias/Frutas.txt");
        arrayCategoriasActivas.add(arrayFrutas);
      }else if(categorias.get(i)=="Paises"){
        arrayPaises = Archivo.leerTodo("D:/Practica4/Categorias/Paises.txt");
        arrayCategoriasActivas.add(arrayPaises);
      }else if(categorias.get(i)=="Bebidas"){
        arrayBebidas = Archivo.leerTodo("D:/Practica4/Categorias/Bebidas.txt");
        arrayCategoriasActivas.add(arrayBebidas);
      }else if(categorias.get(i)=="Comidas"){
        arrayComidas = Archivo.leerTodo("D:/Practica4/Categorias/Comidas.txt");
        arrayCategoriasActivas.add(arrayComidas);
      }else if(categorias.get(i)=="Colores"){
        arrayColores = Archivo.leerTodo("D:/Practica4/Categorias/Colores.txt");
        arrayCategoriasActivas.add(arrayColores);
      }else if(categorias.get(i)=="Instrumentos"){
        arrayInstrumentos = Archivo.leerTodo("D:/Practica4/Categorias/Instrumentos.txt");
        arrayCategoriasActivas.add(arrayInstrumentos);
      }else if(categorias.get(i)=="Artistas"){
        arrayArtistas = Archivo.leerTodo("D:/Practica4/Categorias/Carros.txt");
        arrayCategoriasActivas.add(arrayArtistas);
      }
    }
    rdmCategoria = aleatorio.nextInt(categorias.size());
    rdmPalabra = aleatorio.nextInt(arrayCategoriasActivas.get(rdmCategoria).size());
    s = arrayCategoriasActivas.get(rdmCategoria).get(rdmPalabra);
    lblPalabra.setText(s);
    for(int i=0; i<s.length(); i++) {
      lblRespuesta.setText(lblRespuesta.getText()+" ");
    }
    original = lblRespuesta.getText();
    return s;
  }
  public Boolean comprobar(String letra, String palabra, String original){
    int coincidencia = 0;
    String temporal = letra;
    String s = palabra;
    char temp = temporal.charAt(0);
    for(int i=0; i<s.length(); i++){
      if(temp == (s.charAt(i))){
        original = new StringBuilder(original).replace(i,i+1,temporal).toString();
        lblRespuesta.setText(original);
        coincidencia++;
      }
    }
    if(coincidencia!=0){
      return false;
    }
    return true;
  }
}
