import br.edu.ifsc.Carro;
import br.edu.ifsc.CarroException;
import org.junit.jupiter.api.*;

public class CarroTest {
    private Carro car;

    //exemplo de teste com mais de uma assertiva
    @BeforeAll
    public static void fazAntes() {
    	System.out.println("fazendo antes");
    }
    
    @AfterAll
    public static void fazDepois() {
    	System.out.println("fazendo depois");
    }

    @BeforeEach
    public void fazAntesDeCada() {
    	System.out.println("fazendo antes de cada metoddynho");
    }
    
    @AfterEach
    public void fazDepoisDeCada() {
    	System.out.println("fazendo depois de cada metoddynho");
    }

    
	@Test
	@DisplayName("teste de subida de marcha")
    public void testaUpMarcha() {
		System.out.println("teste01");
		car = new Carro("Palio");
				
		car.upMarcha();
		car.upMarcha();
		Assertions.assertTrue('2'== car.getMarcha());

	}
	@Test
	@DisplayName("teste de aceleração")
    public void testaUpVelocidade() {
		System.out.println("teste02");
		car = new Carro("Palio");
		car.liga();		
		car.upMarcha();
		car.acelera(15);
		Assertions.assertEquals(15, car.getVelocidade());

	}
	
	@Test
	@DisplayName("teste de aceleração acima limite")
    public void testaUpVelocidade2() {
		System.out.println("teste03");

		car = new Carro("Palio");
		car.liga();		
		car.upMarcha();
		car.acelera(25);
		
		var vel1 = car.getVelocidade();
		
		car.upMarcha();
		car.acelera(25);
		
		var vel2 = car.getVelocidade();

		
		Assertions.assertAll(
				() -> Assertions.assertEquals(20, vel1),
				() -> Assertions.assertEquals(40, vel2)
		);
	}
	
	@Test
	@DisplayName("teste excecao ao ligar o carro")
	public void testeException() {
		car = new Carro("Palio");
		car.upMarcha();
		Assertions.assertThrows(CarroException.class, ()-> car.liga());		
	}

}
