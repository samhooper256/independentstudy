package lambdalab;

/**
 * <p>An abstract class that implements {@link ReadableInt} whose value can be bound to (See {@link IntProperty#bind(IntBinding)}, for
 * example). This class provides the skeleton for a {@code ReadableInt} by maintaining the {@link IntChangeListener IntChangeListeners}.
 * It also provides several other useful methods, such as {@link #divide(IntBinding)} or {@link #add(IntBinding)} that
 * create {@code IntBindings} whose value depends on another.</p>
 * 
 * <p>If the value of an {@code IntBinding} <b><i>x</i></b> depends on the value of an {@code IntBinding} <b><i>y</i></b>,
 * this class does not define whether x's change listeners run before y's or y's run before x's. (Note, however,
 * that any change to x is visible to x's listeners and any change to y is visible to y's listeners, as
 * per the specification of {@link ReadableInt}).
 * This rule also applies to all {@code IntBindings} returned by instance methods in this class.</p>
 * 
 * <p>All {@code IntBindings} returned by instance methods in this class (such as {@link #divide(IntBinding)} or
 * {@link #subtract(int)}) are dynamically updated - that is, whenever the value of something they depend on changes,
 * they are automatically updated. Some example code illustrates this:</p>
 * <pre><code>
 * IntProperty x = new IntProperty(3);
 * IntBinding twice = x.multiply(2);
 * System.out.println(twice.get()); //prints "6"
 * x.set(30); //causes the value of twice to be updated, and any listeners listening to twice will be fired.
 * System.out.println(twice.get()); //prints "60"
 * </pre></code>
 *
 */
public abstract class IntBinding implements ReadableInt {
	
	/**
	 * Returns an {@link IntBinding} whose {@link ReadableInt#get() value} is <b>always</b> {@code value}. While
	 * {@link IntChangeListener IntChangeListeners} can be added to the returned {@code IntBinding}, they will never be
	 * fired, since the value of the returned {@code IntBinding} will never change.
	 * @param value the constant {@link ReadableInt#get() value} of the returned {@link IntBinding}.
	 * @return an {@link IntBinding} with a constant {@link ReadableInt#get() value}.
	 */
	public static IntBinding of(final int value) {
		return null; //TODO
	}
	
	/**
	 * Creates a new {@link IntBinding} with no {@link IntChangeListener IntChangeListeners}. The {@link ReadableInt#get() value}
	 * of the created {@code IntBinding} is undefined.
	 */
	public IntBinding() {
		//TODO
	}
	
	/**
	 * <b>If and only if</b> {@code oldValue} does not equal {@code newValue}, fires the {@link IntChangeListener IntChangeListeners}
	 * that have been {@link #addChangeListener(IntChangeListener) added} to this {@link IntBinding}, in the order they were added.
	 * The parameters to this method are the old {@link ReadableInt#get() value} of this {@code IntBinding} and the new (current)
	 * value of this {@code IntBinding}. If {@code oldValue == newValue}, does nothing.
	 * @param oldValue the old value of this {@link IntBinding}
	 * @param newValue the new (current) value of this {@link IntBinding} (if {@link #get()} were called, it would return
	 * {@code newValue}).
	 */
	protected void runChangeListeners(final int oldValue, final int newValue) {
		//TODO
	}
	
	@Override
	public void addChangeListener(IntChangeListener listener) {
		//TODO
	}

	@Override
	public boolean removeChangeListener(IntChangeListener listener) {
		return false; //TODO
	}
	
	/**
	 * Returns a new {@link IntBinding}, different from {@code this}, whose {@link ReadableInt#get() value} is the product of
	 * the value of {@code this} and {@code multiplier}.
	 */
	public IntBinding multiply(final int multiplier) {
		return null; //TODO
	}
	
	/**
	 * Returns a new {@link IntBinding}, different from {@code this} and {@code multiplier},
	 * whose {@link ReadableInt#get() value} is the product of the value of {@code this} and the value of {@code multiplier}.
	 */
	public IntBinding multiply(final IntBinding multiplier) {
		return null; //TODO
	}
	
	/**
	 * Returns a new {@link IntBinding}, different from {@code this}, whose {@link ReadableInt#get() value} is equal to
	 * the value of {@code this} divided by {@code divisor}.
	 */
	public IntBinding divide(final int divisor) {
		return null; //TODO
	}
	
	/**
	 * Returns a new {@link IntBinding}, different from {@code this} and {@code divisor}, whose {@link ReadableInt#get() value}
	 * is equal to the value of {@code this} divided by the value of {@code divisor}.
	 */
	public IntBinding divide(final IntBinding divisor) {
		return null; //TODO
	}
	
	/**
	 * Returns a new {@link IntBinding}, different from {@code this}, whose {@link ReadableInt#get() value} is the sum
	 * of the value of {@code this} and {@code addend}.
	 */
	public IntBinding add(final int addend) {
		return null; //TODO
	}
	
	/**
	 * Returns a new {@link IntBinding}, different from {@code this} and {@code addend}, whose {@link ReadableInt#get() value}
	 * is the sum of the value of {@code this} and the value of {@code addend}.
	 */
	public IntBinding add(final IntBinding addend) {
		return null; //TODO
	}
	
	/**
	 * Returns a new {@link IntBinding}, different from {@code this}, whose {@link ReadableInt#get() value} is equal to the
	 * value of {@code this} minus {@code subtrahend}.
	 */
	public IntBinding subtract(final int subtrahend) {
		return null; //TODO
	}
	
	/**
	 * Returns a new {@link IntBinding} whose {@link ReadableInt#get() value} is equal to the value of {@code this} minus
	 * the value of {@code subtrahend}.
	 */
	public IntBinding subtract(final IntBinding subtrahend) {
		return null; //TODO
	}
	
}
