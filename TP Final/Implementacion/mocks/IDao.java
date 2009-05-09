package mocks;


public interface IDao<T> {
	
	public T get(int id);
	public void add(T entity);

}
