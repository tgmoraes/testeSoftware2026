package br.edu.ifsc;

public class Carro implements Comparable<Carro>{
	private final String nome;
	private char marcha;
	private boolean ligado;
	private double velocidade;

	
	public Carro(String nome) {
		this.marcha = 0;
		this.ligado = false;
		this.velocidade = 0;
		this.nome = nome;
	}
	
	public Carro(String nome, char marcha, boolean ligado, double vel) {
		this.marcha = 0;
		this.nome = nome;
		this.ligado = false;
		this.velocidade = vel;
	}
	public String getNome() {
		return nome;
	}
	public char getMarcha() {
		if (this.marcha == 0)
			return 'N';
		else
			return (char) (this.marcha + 48);
	}
	public void upMarcha() {
		if (this.marcha <= 4)
			this.marcha++;
	}
	public void downMarcha() {
		if (this.marcha >= 1) this.marcha--;
	}
	public boolean isLigado() {
		return ligado;
	}
	public void liga() {
		if(this.marcha!=0 && !this.ligado) 
			throw new CarroException("Carro engatado, para ligar coloque no Neutro");
		this.ligado = true;
	}
	public void desliga() {
		this.ligado = false;
	}
	public double getVelocidade() {
		return velocidade;
	}
	public void acelera(double velocidade) {
		if (this.ligado && this.marcha > 0) {
			int limSup = 20 * (this.marcha);
			if (this.velocidade + velocidade < limSup) this.velocidade += velocidade;
			else this.velocidade = limSup;
		} else {
			throw new CarroException("Para carro andar"
					+ " deve estar ligado e com marcha engatada! Status atual: ligado:"+
					this.isLigado()+", marcha:"+this.getMarcha());
		}
	}
	public void freia(double velocidade) {
		if(velocidade<0)
			throw new CarroException("parametro de freia nao deve ser negativo");
		if (this.velocidade - velocidade <= 0)
			this.velocidade = 0;
		else
			this.velocidade -= velocidade;
	}
	@Override
	public String toString() {
		String lig = this.isLigado()? "Ligado": "Desligado";
		return String.format("%s -> (%s, marcha: %c, %.1f km/h)", 
				this.getNome(),lig, this.getMarcha(),this.getVelocidade());
	}
	@Override
	public int compareTo(Carro o) {
		int retorno = this.nome.compareTo(o.nome);
		
		if(retorno==0) {
			if (this.marcha>o.marcha) return 1;
			if (this.marcha<o.marcha) return -1;
		}
		return retorno;
	}
}
