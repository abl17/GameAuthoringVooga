package authoring.model.properties;

/**
 * @author Austin
 * @param <T>
 */
public interface IProperty<T> {
	/**
	 * @return The value of the property (a generic)
	 */
	public T getValue();
	/**
	 * @param value The value of the property
	 */
	public void setValue(T value);
}
