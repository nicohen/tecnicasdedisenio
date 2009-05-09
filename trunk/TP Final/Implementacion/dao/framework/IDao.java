package dao.framework;

public interface IDao<T> {

	public T get(int id);

	public int add(T entity);

}
