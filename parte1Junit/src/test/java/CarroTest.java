import br.edu.ifsc.Carro;
import br.edu.ifsc.CarroException;
import org.junit.jupiter.api.*;

public class CarroTest {
    private Carro car;



    //exemplo de teste com mais de uma assertiva
	@Test
	@DisplayName("teste de subida de marcha")
    public void testaUpMarcha() {
		car = new Carro("Palio");
				
		car.upMarcha();
		car.upMarcha();
		Assertions.assertEquals('2', car.getMarcha());

	}

}
