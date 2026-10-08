package br.edu.ifsc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class IntervaloTest {
    private final Intervalo intervalo = new Intervalo(2,65,70); // 3:06:10

    @Test
    @DisplayName(value="teste1: criacao e chamada de segundos")
    public void testeSegundos(){

        Assertions.assertEquals(10, intervalo.segundos());

    }
    
    @Test
    @DisplayName(value="teste2: criacao e chamada de minutos")
    public void testeMinutos(){

        Assertions.assertEquals(6, intervalo.minutos());

    }
    
    @Test
    @DisplayName(value="teste3: criacao e chamada de horas")
    public void testeHoras(){

        Assertions.assertEquals(3, intervalo.horas());

    }

    @Test
    @DisplayName(value="teste4: chamada de totalSegundos")
    public void testeTotalSegundos(){

        Assertions.assertEquals(11170, intervalo.totalSegundos());

    }

    @Test
    @DisplayName(value="teste5: chamada de totalMinutos")
    public void testeTotalMinutos(){

        Assertions.assertEquals(186, intervalo.totalMinutos());

    }

//    @Test
//    @DisplayName(value="deve retornar total de minutos")
//    public void testeTotalMinutos(){
//    
//    }
}
