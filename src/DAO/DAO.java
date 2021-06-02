package DAO;

import java.util.List;

public interface DAO<T>{
	
	public boolean insert(T t);

	public T get(int id);

	public List<T> getAll();

	public boolean update(T t);

	public boolean delete(int id);

}