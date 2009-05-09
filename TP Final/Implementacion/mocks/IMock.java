package mocks;


public interface IMock<T> {
	
	public T get(int id);
	public void add(T entity);

}
