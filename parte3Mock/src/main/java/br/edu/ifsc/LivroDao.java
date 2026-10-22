package br.edu.ifsc;

import java.util.ArrayList;
import java.util.List;

public class LivroDao implements IDao<Livro> {
	@Override
	public void inserir(Livro l) {
		
	}
	@Override
	public void deletar(int id) {
		
	}
	@Override
	public void alterar(Livro l) {
		
	}
	@Override
	public Livro get(int id) {
		return new Livro();
	}
	@Override
	public List<Livro> listar(int limit, int offset){
		return new ArrayList<Livro>();
	}
	
	public List<Livro> listarReservados(){
		return new ArrayList<Livro>();
	}
}
