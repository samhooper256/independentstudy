package lambdalab;

/**
 * A functional interface that allows for an action to be run whenever some {@code int} value changes. The
 * single abstract method of this interface accepts as its parameters the old value and the new value of
 * the {@code int} that has changed.
 * 
 */
@FunctionalInterface
public interface IntChangeListener {

	void changed(int oldValue, int newValue);
	
}