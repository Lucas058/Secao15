package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;


public class Reserva {

	private Integer numeroQuarto;
	private Date checkIn;
	private Date checkOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reserva(Integer numeroQuarto, Date checkIn, Date checkOut) {
		this.numeroQuarto = numeroQuarto;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getNumeroQuarto() {
		return numeroQuarto;
	}

	public void setNumeroQuarto(Integer numeroQuarto) {
		this.numeroQuarto = numeroQuarto;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}
	
	public long duracao() {
		long dif = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(dif, TimeUnit.MILLISECONDS);
	}
	
	public String atualizacaoData(Date checkIn, Date checkOut) {
		Date agora = new Date();
		if (checkIn.before(agora) || checkOut.before(agora)) {
			return "Erro na reserva: Para aualizas as datas da reserva, tem que ser dartas futuras.";
		} 
		if (!checkOut.after(checkIn)) {
			return "Erro na reserva: a data do check-out não pode ser anterior a data do check-in.";
		}
		
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		return null;
	}
	
	@Override
	public String toString() {
		return "Quarto " + numeroQuarto + ", check-in: " + sdf.format(checkIn)
			    + ", check-out: " + sdf.format(checkOut) + ", " + duracao() + " noites";
 	}
	
}
