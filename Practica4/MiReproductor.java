import javax.sound.midi.*;
import java.io.*;
import java.util.*;

class MiReproductor{

	private Synthesizer synthe = null;
	private int intensity = 100;
	private MidiChannel [] channels;
	private MidiChannel channel;

	private Instrument[] instrumentos;


	public MiReproductor(){
		try{
			synthe = MidiSystem.getSynthesizer();

		}catch(Exception e){
			System.out.println("Error: al obtener synthe.");
		}
	}

	public void inicializar(){
		try{
			synthe.open();
			channels = synthe.getChannels();

			// instrumentos = synthe.getLoadedInstruments();
			// for (Instrument i : instrumentos)
			// 	System.out.println(i);
		}catch(Exception e){
			System.out.println("Error: al inizializar el synthe.");
		}
	}


	public void reproducirNota(int nota, int canal, int duracion){
		try{
			channel = channels[canal];
			channel.noteOn(nota, intensity);

			//	channel.programChange(0,40);

			try{
					Thread.sleep(duracion);
			}catch(Exception e){
				System.out.println("ERROR: en sleep.");
			}
			channel.noteOff(nota);
		}catch(Exception e)
		{
			System.out.println("ERROR: al reproducir la nota");
		}
	}

	public void reproducirAcorde3Notas(int nota1,int nota2, int nota3, int canal, int duracion){
		try{
			channel = channels[canal];
			channel.noteOn(nota1, intensity);
			channel.noteOn(nota2, intensity);
			channel.noteOn(nota3, intensity);

			try{
					Thread.sleep(duracion);
				}catch(Exception e){
					System.out.println("ERROR: en sleep.");
				}

			channel.noteOff(nota1);
			channel.noteOff(nota2);
			channel.noteOff(nota3);
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("ERROR: al reproducir el acorde");
		}

	}

	public void reproducirAcordeNnotas(ArrayList<Integer> notas, int n, int canal, int duracion){
		channel = channels[canal];
		for(int i=0;i<n;i++)
			channel.noteOn(notas.get(i),intensity);

		try{
				Thread.sleep(duracion);
			}catch(Exception e){
				System.out.println("ERROR: en sleep.");
			}
		for(int i=0; i<n; i++)
		channel.noteOff(notas.get(i));
	}

	public void probarCanal(){
		Scanner teclado = new Scanner(System.in);
		int nota=65;
		int intensity=100;
		int opc=-1;
		int canal;

		do{
			System.out.print("Que canal desea probar?: ");
			canal=teclado.nextInt();
			try{
				channel=channels[canal];
				channel.noteOn(nota,intensity);
				try{
						Thread.sleep(1000);
					}catch(Exception e){
						System.out.println("ERROR: en sleep.");
					}

				channel.noteOff(nota);
				System.out.print("Desea checar con otro canal?\t1)Si\t0)No\nOpcion: ");
				opc=teclado.nextInt();
			}catch(Exception e){
				e.printStackTrace();
				System.out.println("ERROR: al probar el canal");
			}

		}while(opc!=0);
	}

	public void leerArchivoNotas(String nombreArchivo, int canal){
		MiReproductor mrp = new MiReproductor();
		String cadena = new String();
		try(
			FileInputStream fis = new FileInputStream(nombreArchivo);
			DataInputStream din = new DataInputStream(fis);
			BufferedReader br = new BufferedReader(new InputStreamReader(din));
		){
			cadena=br.readLine();
			while(cadena!=null){
				channel = channels[canal];
				channel.noteOn(Integer.parseInt(cadena.substring(0,2)), intensity);
				try{
					Thread.sleep(Integer.parseInt(cadena.substring(3,cadena.length())));
				}catch(Exception e){
					System.out.println("ERROR: en sleep.");
				}
				channel.noteOff(Integer.parseInt(cadena.substring(0,2)));
				cadena=br.readLine();
			}
			br.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public void leerArchivoAcorde3Notas(String nombreArchivo, int canal){
		MiReproductor mrp = new MiReproductor();
		String cadena = new String();
		try(
			FileInputStream fis = new FileInputStream(nombreArchivo);
			DataInputStream din = new DataInputStream(fis);
			BufferedReader br = new BufferedReader(new InputStreamReader(din));
		){
			cadena=br.readLine();
			while(cadena!=null){
				channel = channels[canal];
				channel.noteOn(Integer.parseInt(cadena.substring(0,2)), intensity);
				channel.noteOn(Integer.parseInt(cadena.substring(3,5)), intensity);
				channel.noteOn(Integer.parseInt(cadena.substring(6,8)), intensity);
				try{
					Thread.sleep(Integer.parseInt(cadena.substring(9,cadena.length())));
				}catch(Exception e){
					System.out.println("ERROR: en sleep.");
				}
				channel.noteOff(Integer.parseInt(cadena.substring(0,2)));
				cadena=br.readLine();
			}
			br.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public void finalizar(){
		try{
			synthe.close();

		}catch(Exception e){
			System.out.println("Error: al finalizar el synthe.");
		}
	}


}
