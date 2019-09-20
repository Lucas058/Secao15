package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reserva;

public class Programa137 {

	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Numero do quarto: ");
		int numeroQuarto = sc.nextInt();
		System.out.print("Data do check-in (dd/mm/aaaa): ");
		Date checkIn = sdf.parse(sc.next());
		System.out.print("Data do check-out (dd/mm/aaaa): ");
		Date checkOut = sdf.parse(sc.next());

		if (!checkOut.after(checkIn)) {
			System.out.println("Erro na reserva: a data do check-out não pode ser anterior a data do check-in.");
		} else {
			Reserva reserva = new Reserva(numeroQuarto, checkIn, checkOut);
			System.out.println("Reserva: " + reserva);
			System.out.println();

			System.out.println("Entre com as datas de atualização da reserva: ");
			System.out.print("Data do check-in (dd/mm/aaaa): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Data do check-out (dd/mm/aaaa): ");
			checkOut = sdf.parse(sc.next());

			Date agora = new Date();
			if (checkIn.before(agora) || checkOut.before(agora)) {
				System.out.println("Erro na reserva: Para aualizas as datas da reserva, tem que ser dartas futuras.");
			} else if (!checkOut.after(checkIn)) {
				System.out.println("Erro na reserva: a data do check-out não pode ser anterior a data do check-in.");
			} else {
				reserva.atualizacaoData(checkIn, checkOut);
				System.out.println("Reserva:" + reserva);
			}
		}
		
		sc.close();
	}

}
