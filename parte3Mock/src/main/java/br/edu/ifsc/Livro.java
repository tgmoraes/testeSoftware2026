package br.edu.ifsc;

import java.time.LocalDate;

public class Livro {
	private int id;
	private String titulo;
	private int paginasLidas;
	private int paginas;
	private boolean reservado;
	private LocalDate dataReserva;

	public Livro(int id, String titulo, int paginas, int pagsLidas, boolean reservado, LocalDate reserva) {
		this.id = id;
		this.paginas = paginas;
		this.titulo = titulo;
		this.reservado = reservado;
		this.dataReserva = reserva;
		this.paginasLidas = pagsLidas;
	}

	public Livro(String titulo, int paginas) {
		this.paginas = paginas;
		this.titulo = titulo;
		this.reservado = false;
		this.dataReserva = null;
		this.paginasLidas = 0;
	}

	public Livro() {
		// TODO Auto-generated constructor stub
	}

	public void ler(int pags) {
		if (this.paginasLidas + pags < this.paginas) {
			paginasLidas = +pags;
		} else {
			this.paginasLidas = this.paginas;
		}

	}
	//retorna qntas paginas faltam
	public int leEGetPagsFaltam(int pgs) {
		this.ler(pgs);
		return this.paginas - this.paginasLidas;
	}
	
	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getPaginasLidas() {
		return this.paginasLidas;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPaginas() {
		return paginas;
	}

	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}

	public boolean isReservado() {
		return reservado;
	}

	public LocalDate getDataReserva() {
		return dataReserva;
	}

	public void reserva() {
		if (!this.reservado) {
			this.dataReserva = LocalDate.now();
			this.reservado = true;
		}
	}
	public void cancelaReserva() {
		if (this.reservado) {
			this.dataReserva = null;
			this.reservado = false;
		}
	}
}
