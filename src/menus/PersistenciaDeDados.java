package menus;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OptionalDataException;
import java.io.StreamCorruptedException;

import eventos.Evento;

public class PersistenciaDeDados {

	public static void salvarEventos() {
		File nomeArq = new File("Eventos.bin");
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(nomeArq));) {
			
			for(Evento evento : Menu2.eventos) out.writeObject(evento);
			
		} catch (SecurityException e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		} catch (InvalidClassException e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		} catch (NotSerializableException e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		} catch (IOException e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		} finally {
			System.out.println("Fim do salvarEventos()");
		}
	}

	public static void lerEventos() {

		File nomeArq = new File("Eventos.bin");
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(nomeArq));) {
			
			while(true)	Menu2.eventos.add((Evento) in.readObject());

		} catch (ClassCastException e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		} catch (UnsupportedOperationException e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		} catch (OptionalDataException e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		} catch (InvalidClassException e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		} catch (StreamCorruptedException e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		} catch (SecurityException e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		} catch (EOFException e) {
			System.out.println("EOFException -> leitura do arquivo de dados correta");
		} catch (IOException e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		} finally {
			System.out.println("Fim do lerEventos()");
		}
	}

}
