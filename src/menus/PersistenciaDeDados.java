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
import java.util.List;

import eventos.Evento;

public class PersistenciaDeDados {

	public static void salvarEventos(List<Evento> eventos) {
		File nomeArq = new File("Eventos.bin");
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(nomeArq));) {
			for(Evento evento : eventos) {
				out.writeObject(evento);
			}
		} catch(NullPointerException e) {
			System.out.println("Ponteiro nulo");
		} catch (InvalidClassException e) {
			System.out.println("Classe inválida");
		} catch (NotSerializableException e) {
			System.out.println("Classe não serializável");
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo não encontrado");
		} catch (IOException e) {
			System.out.println("Erro na escrita");
		} finally {
			System.out.println("Fim do salvarEventos()");
		}
	}

	public static void lerEventos() {
		File nomeArq = new File("Eventos.bin");
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(nomeArq));) {

			while(true)	Menu.eventos.add((Evento) in.readObject());

		} catch (FileNotFoundException e) {
			System.out.println("Arquivo não encontrado");
		} catch (EOFException e) {
			System.out.println("Final da leitura");
		} catch (IOException e) {
			System.out.println("Erro na leitura");
		} catch (ClassNotFoundException e) {
			System.out.println("Classe não encontrada");
		} finally {
			System.out.println("Fim do lerEventos()");
		}
	}

}
