package lambdalab;

/**
 * <p>A property that is represented by an {@code int}. This property can have a literal value, which can be set using the 
 * {@link #set(int)} method. Alternatively, it can be {@link #bind(IntBinding) bound} to an {@link IntBinding} such that its
 * {@link ReadableInt#get() value} is always the same as that {@code IntBinding}, even if the value of that {@code IntBinding}
 * changes.</p>
 *
 */
public class IntProperty extends IntBinding {
	
	private int value; //the int value of this IntProperty whenever it's not bound.
	private IntBinding bound; //the IntBinding that this IntProperty is bound to, if it is bound.
	private IntChangeListener boundListener; //the listener that will be added to 'bound' so that this
	//IntProperty can run its change listeners whenever its bound changes.
	
	/**
	 * Creates a new {@link IntProperty} with a {@link ReadableInt#get() value} of {@code 0}.
	 */
	public IntProperty() {
		this(0);
	}
	
	/**
	 * Creates a new {@link IntProperty} with a {@link ReadableInt#get() value} of {@code value}.
	 */
	public IntProperty(final int value) {
		this.value = value;
		
		boundListener = (oldValue, newValue) -> this.runChangeListeners(oldValue, newValue);
		//you could also write the above line as:
		//boundListener = this::runChangeListeners;
		//We will talk about that later :)
		
		bound = null; //I use "null" to represent the absence of a bound. You might also do this with a boolean value that
		//you update in the bind/unbind methods and return in the isBound() method.
	}
	
	/**
	 * Returns {@code true} if this {@link IntProperty} is bound to another {@link IntBinding}, {@code false} otherwise.
	 */
	public boolean isBound() {
		//when bound is null, that means this IntProperty is not bound.
		return bound != null;
	}
	
	@Override
	public int get() {
		if(isBound())
			return bound.get();
		return value;
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
		if(isBound())
			throw new IllegalArgumentException("Cannot set a bound value");
		final int oldValue = value;
		value = newValue;
		//runChangeListeners doesn't do anything if oldValue==value, so there's no need to do an if check beforehand.
		runChangeListeners(oldValue, value); //Also note that we call runChangeListeners AFTER the value is changed,
		//as per the specification of ReadableInt.
	}
	
	/**
	 * Binds this {@link IntProperty} to the given {@link IntBinding}. The {@link ReadableInt#get() value} of this
	 * {@code IntProperty} will be the same as {@code bound's} unless it is later {@link #unbind() unbound} or bound to
	 * another {@code IntBinding}.
	 * @param newBound the {@link IntBinding} that this {@link IntProperty} will be bound to.
	 */
	public void bind(final IntBinding newBound) {
		final int oldValue = get();
		if(isBound()) //we have to do the isBound() check because 'bound' might be null.
			bound.removeChangeListener(boundListener); //make sure to remove the listener from the old bound!
		newBound.addChangeListener(boundListener);
		bound = newBound;
		runChangeListeners(oldValue, get());
	}
	
	/**
	 * Unbinds this {@link IntProperty} from its bound. The {@link ReadableInt#get() value} of this {@code IntProperty}
	 * will return to whatever it was before it was {@link #bind(IntBinding) bound}. If this {@code IntProperty} is not
	 * bound, throws an exception.
	 * @throws IllegalArgumentException if this {@link IntProperty} is not {@link #isBound() bound}.
	 */
	public void unbind() {
		if(!isBound())
			throw new IllegalArgumentException("Cannot unbind an IntProperty that is not bound");
		final int oldValue = get();
		bound.removeChangeListener(boundListener);
		bound = null;
		runChangeListeners(oldValue, get());
	}
	
}
