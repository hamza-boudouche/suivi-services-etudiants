package DAO;

import java.util.List;
/**
 * Interface qui controle la structure des classes DAO
 * Exige des methodes d'ajout (insertion), recherche, mise a jour, suppression et recherche de tous les elements existants
 */
public interface DAO<T>{
	
	public boolean insert(T t);

	public T get(int id);

	public List<T> getAll();

	public boolean update(T t);

	public boolean delete(int id);

}