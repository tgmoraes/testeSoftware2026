package br.edu.ifsc;

public class CarroTeste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Carro uno = new Carro("Uno de Firma");
		
		System.out.println("Carro: "+uno);
		
		uno.liga();
		
		uno.upMarcha();
		uno.acelera(10);
		uno.upMarcha();
		uno.acelera(10);
		
		System.out.println("Carro: "+uno);
		
		System.out.println("Teste1 ligado: "+(uno.isLigado()==true));
		System.out.println("Teste2 marcha: "+(uno.getMarcha()=='2'));
		System.out.println("Teste3 velocidad: "+(uno.getVelocidade()==20));

	}

}
