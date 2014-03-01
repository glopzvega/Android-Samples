package mx.com.listacompras;

public class Venta {

	private int id;
	private String folio;
	private String numero;	
	private String hora;
	private String monto;
		
	public Venta() {
	
	}

	public Venta(int id, String folio, String numero, String hora, String monto) {
	
		this.id = id;
		this.folio = folio;
		this.numero = numero;
		this.monto = monto;
		this.hora = hora;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getFolio() {
		return folio;
	}
	public void setFolio(String folio) {
		this.folio = folio;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getMonto() {
		return monto;
	}
	public void setMonto(String monto) {
		this.monto = monto;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}

	@Override
	public String toString() {
		return "Venta [folio=" + folio + ", numero=" + numero + ", monto="
				+ monto + ", hora=" + hora + "]";
	}
	
	
	
	
}
