package lambdalab;

/**
 * <p>A property that is represented by an {@code int}. This property can have a literal value, which can be set using the 
 * {@link #set(int)} method. Alternatively, it can be {@link #bind(IntBinding) bound} to an {@link IntBinding} such that its
 * {@link ReadableInt#get() value} is always the same as that {@code IntBinding}, even if the value of that {@code IntBinding}
 * changes.</p>
 *
 */
public class IntProperty extends IntBinding {
	
	/**
	 * Creates a new {@link IntProperty} with a {@link ReadableInt#get() value} of {@code 0}.
	 */
	public IntProperty() {
		//TODO
	}
	
	/**
	 * Creates a new {@link IntProperty} with a {@link ReadableInt#get() value} of {@code value}.
	 */
	public IntProperty(final int value) {
		//TODO
	}
	
	/**
	 * Returns {@code true} if this {@link IntProperty} is bound to another {@link IntBinding}, {@code false} otherwise.
	 */
	public boolean isBound() {
		return false; //TODO
	}
	
	@Override
	public int get() {
		return Integer.MIN_VALUE; //TODO
	}
	
	/**
	 * Sets the {@link ReadableInt#get() value} of this {@link IntProperty} to {@code newValue}. The
	 * {@link IntChangeListener IntChangeListeners} listening to this {@code IntProperty} will be fired <b>only</b> if
	 * the current value does not equal {@code newValue}. Throws an exception if this {@code IntProperty}
	 * {@link #isBound() is bound}.
	 * @throws IllegalArgumentException if this {@link IntProperty} {@link #isBound() is bound}.
	 * @param newValue the new value of this {@link IntProperty}.
	 */
	public void set(final int newValue) {
		//TODO
	}
	
	/**
	 * Binds this {@link IntProperty} to the given {@link IntBinding}. The {@link ReadableInt#get() value} of this
	 * {@code IntProperty} will be the same as {@code bound's} unless it is later {@link #unbind() unbound} or bound to
	 * another {@code IntBinding}.
	 * @param bound the {@link IntBinding} that this {@link IntProperty} will be bound to.
	 */
	public void bind(final IntBinding bound) {
		//TODO
	}
	
	/**
	 * Unbinds this {@link IntProperty} from its bound. The {@link ReadableInt#get() value} of this {@code IntProperty}
	 * will return to whatever it was before it was {@link #bind(IntBinding) bound}. If this {@code IntProperty} is not
	 * bound, throws an exception.
	 * @throws IllegalArgumentException if this {@link IntProperty} is not {@link #isBound() bound}.
	 */
	public void unbind() {
		//TODO
	}
	
}
