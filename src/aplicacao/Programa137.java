package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reserva;
import model.exceptions.DomainExceptions;

public class Programa137 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		try {
			System.out.print("Numero do quarto: ");
			int numeroQuarto = sc.nextInt();
			System.out.print("Data do check-in (dd/mm/aaaa): ");
			Date checkIn = sdf.parse(sc.next());
			System.out.print("Data do check-out (dd/mm/aaaa): ");
			Date checkOut = sdf.parse(sc.next());
	
			Reserva reserva = new Reserva(numeroQuarto, checkIn, checkOut);
			System.out.println("Reserva: " + reserva);
			System.out.println();
	
			System.out.println("Entre com as datas de atualização da reserva: ");
			System.out.print("Data do check-in (dd/mm/aaaa): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Data do check-out (dd/mm/aaaa): ");
			checkOut = sdf.parse(sc.next());
	
			reserva.atualizacaoData(checkIn, checkOut);
			System.out.println("Reserva:" + reserva);
		}
		catch(ParseException e) {
			System.out.println("Data invalida");
		}
		catch(DomainExceptions e) {
			System.out.println("Data na reserva " + e.getMessage());
		}
		catch(RuntimeException e) {
			System.out.println("Erro inesperado");
		}
		
		sc.close();
	}

}
