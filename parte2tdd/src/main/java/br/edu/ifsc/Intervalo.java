package br.edu.ifsc;

public class Intervalo {
	private int seg;
	//private int min;
	//private int hor;
	
    public Intervalo(int horas, int minutos, int segundos) {
    	this.seg = segundos + minutos*60 + horas*60*60;
    	
    //	this.seg = segundos%60;
    //	this.min = segundos/60 + minutos;
   // 	this.hor = this.min/60 + horas;
    //	this.min = this.min%60;
    }

    public int horas() {
    	return this.seg/3600;
    }

    public int minutos() {
    	return this.totalMinutos()%60;
    }

    public int segundos() {
    	return this.seg%60 ;
    }
    
    public int totalSegundos() {
    	return this.seg;
    }

	public int totalMinutos() {
		// TODO Auto-generated method stub
		return this.seg/60;
	}

//    public int totalMinutos() {
//        return 0;
//    }
}
