package br.edu.ifsc;

import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

public class GerenciadorLivroTest {
	@Test
    @DisplayName(value="cancelarReservas deve chamar os metodos listarReservados e alterar do dao")
	public void deveCancelarLivros() {
		//mocka o dao
		
		LivroDao daoLivroMockado = mock(LivroDao.class);
		
		ArrayList<Livro> livrosReservados = new ArrayList<>();
		
		livrosReservados.add(new Livro(1,"sr dos aneis",100,0,
                true,LocalDate.now().minusDays(8)));
		livrosReservados.add(new Livro(2,"hobbit",150,0,
                true,LocalDate.now().minusDays(6)));
		livrosReservados.add(new Livro(3,"harry potter",200,0,
                true,LocalDate.now().minusDays(10)));
		//criar a gerenciador
		when(daoLivroMockado.listarReservados()).thenReturn(livrosReservados);

        GerenciadorLivro gl = new GerenciadorLivro(daoLivroMockado);

		//testar o gerenciador
		gl.cancelarReservas();
		
		verify(daoLivroMockado).listarReservados();
		verify(daoLivroMockado, times(1)).alterar(livrosReservados.get(0));
		verify(daoLivroMockado, times(1)).alterar(livrosReservados.get(2));
		
	}
	@Test
    @DisplayName(value="deve tratar exception lançada p/ método inserir do dao")
	public void deveTratarException() {
        //mocka o livroDao
		IDao<Livro> daoLivroMockado = mock(IDao.class);
		//LivroDao daoLivroMockado = mock(LivroDao.class);
		//faz com que a chamada de inserir do dao com parametro=null gere exception
        doThrow(new RuntimeException()).when(daoLivroMockado).inserir(null);
        // cria o gerenciador que depende do dao
		GerenciadorLivro gl = new GerenciadorLivro(daoLivroMockado);
        //se a excecao foi tratada corretamente entao deve retornar false
		Assertions.assertEquals(false, gl.salvaLivro(null));
	}
	
}
