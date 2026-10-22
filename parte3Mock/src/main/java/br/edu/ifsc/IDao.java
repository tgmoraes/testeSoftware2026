package br.edu.ifsc;

import java.util.List;

public interface IDao<T> {

	void inserir(T l);

	void deletar(int id);

	void alterar(T l);

	Livro get(int id);

	List<T> listar(int limit, int offset);

}