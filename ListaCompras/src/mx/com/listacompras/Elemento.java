package mx.com.listacompras;

public class Elemento {

	private int id;
	private String nombre;
	private String imagen;

	public Elemento(int id, String nombre, String imagen) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.imagen = imagen;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	@Override
	public String toString() {
		return "Elemento [id=" + id + ", nombre=" + nombre + ", imagen="
				+ imagen + "]";
	}
	
	

}
