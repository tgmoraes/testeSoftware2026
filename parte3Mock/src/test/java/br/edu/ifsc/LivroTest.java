package br.edu.ifsc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class LivroTest {

	@Test
	@DisplayName("testa leitura positiva")
	public void testaLerPos() {
		Livro l = new Livro("Harry Potter 1", 300);
		l.ler(10);
		Assertions.assertEquals(10, l.getPaginasLidas());
	}

	@Test
	@DisplayName("testa leitura positiva de muitas paginas")
	public void testaLerPos2() {
		Livro l = new Livro("Harry Potter 1", 300);
		l.ler(350);
		Assertions.assertEquals(300, l.getPaginasLidas());

	}

	@Test
	@DisplayName("teste simples de sintaxe do mockito")
	public void testaMockito() {
		// import static org.mockito.Mockito.*;
		Livro livroFalso = mock(Livro.class);
		
		String titulo = "senhor dos aneis";
		livroFalso.setTitulo(titulo);
		System.out.println("chamada ates simular get:"+livroFalso.getTitulo());
		
		//simulando a chamada de getTitulo()
		when(livroFalso.getTitulo()).thenReturn(titulo);
		
		
		
		
		System.out.println("chamada apos simular get:"+livroFalso.getTitulo());
		
		//simulando a chamada de leEGetPagsFaltam()
		when(livroFalso.leEGetPagsFaltam(10)).thenReturn(100);
		
		
		System.out.println("chamada de leEGetPagsFaltam sem um parâmetro simulado:"
		+livroFalso.leEGetPagsFaltam(5));
		
		System.out.println("chamada de leEGetPagsFaltam com um parâmetro simulado:"
		+livroFalso.leEGetPagsFaltam(10));

		//verifica se o metodo getTitulo foi chamado duas vezes
		verify(livroFalso, times(2)).getTitulo();
        //no maximo duas vezes getTitulo foi chamado
        verify(livroFalso, atMost(2)).getTitulo();
        //no minimo duas vezes gettitulo foi chamado
        verify(livroFalso, atLeast(3)).getTitulo();
    }

}
