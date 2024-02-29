package es.iessoterohernandez.daw.endes.ej4_test;

public class Subscripcion {
	
	private int precio;
	private int periodo;

	public Subscripcion(int p, int n) {
		precio = p ;
		periodo = n ;
	}

	public double precioPorMes() {
		if (periodo <= 0 || precio <= 0)
			return 0;
		double r = (double) precio / (double) periodo;
		double resto = r % 1;
		if (resto > 0)
			return r + 1;
		else
			return r;
	}

	public void cancel() {
		periodo = 0;
	}
	
}