package lambdalab;

import java.util.*;
import java.util.function.IntBinaryOperator;

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
		//I used an anonymous class here because it's a little more concise.
		//If you wanted to, you could have made your own subclass of IntBinding (such as "ConstantIntBinding")
		//that always returns the same value from get(). You don't need to worry about listeners,
		//because the value will never change.
		return new IntBinding() {
			
			@Override
			public int get() {
				return value;
			}
			
		};
	}
	
	private List<IntChangeListener> listeners;
	
	/**
	 * Creates a new {@link IntBinding} with no {@link IntChangeListener IntChangeListeners}. The {@link ReadableInt#get() value}
	 * of the created {@code IntBinding} is undefined.
	 */
	public IntBinding() {
		listeners = new ArrayList<>(); //If you wanted to be more memory efficient, you could initially set
		//'listeners' to 'null' and only create the ArrayList object when a change listener is actually
		//added. This way we don't waste memory creating a list of change listeners to something that will
		//likely never have change listeners added to it (like a constant, for example).
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
		if(oldValue != newValue)
			for(IntChangeListener listener : listeners)
				listener.changed(oldValue, newValue);
	}
	
	@Override
	public void addChangeListener(IntChangeListener listener) {
		listeners.add(listener);
	}

	@Override
	public boolean removeChangeListener(IntChangeListener listener) {
		return listeners.remove(listener);
	}
	
	/**
	 * Returns a new {@link IntBinding}, different from {@code this}, whose {@link ReadableInt#get() value} is the product of
	 * the value of {@code this} and {@code multiplier}.
	 */
	public IntBinding multiply(final int multiplier) {
		return multiply(of(multiplier));
	}
	
	/**
	 * Returns a new {@link IntBinding}, different from {@code this} and {@code multiplier},
	 * whose {@link ReadableInt#get() value} is the product of the value of {@code this} and the value of {@code multiplier}.
	 */
	public IntBinding multiply(final IntBinding multiplier) {
		return fromOperator((a, b) -> a * b, multiplier);
	}
	
	/**
	 * Returns a new {@link IntBinding}, different from {@code this}, whose {@link ReadableInt#get() value} is equal to
	 * the value of {@code this} divided by {@code divisor}.
	 */
	public IntBinding divide(final int divisor) {
		return divide(of(divisor));
	}
	
	/**
	 * Returns a new {@link IntBinding}, different from {@code this} and {@code divisor}, whose {@link ReadableInt#get() value}
	 * is equal to the value of {@code this} divided by the value of {@code divisor}.
	 */
	public IntBinding divide(final IntBinding divisor) {
		return fromOperator((a, b) -> a / b, divisor);
	}
	
	/**
	 * Returns a new {@link IntBinding}, different from {@code this}, whose {@link ReadableInt#get() value} is the sum
	 * of the value of {@code this} and {@code addend}.
	 */
	public IntBinding add(final int addend) {
		return add(of(addend));
	}
	
	/**
	 * Returns a new {@link IntBinding}, different from {@code this} and {@code addend}, whose {@link ReadableInt#get() value}
	 * is the sum of the value of {@code this} and the value of {@code addend}.
	 */
	public IntBinding add(final IntBinding addend) {
		return fromOperator((a, b) -> a + b, addend);
		//You could also write the above line as:
		//return fromOperator(Integer::sum, addend);
	}
	
	/**
	 * Returns a new {@link IntBinding}, different from {@code this}, whose {@link ReadableInt#get() value} is equal to the
	 * value of {@code this} minus {@code subtrahend}.
	 */
	public IntBinding subtract(final int subtrahend) {
		return subtract(of(subtrahend));
	}
	
	/**
	 * Returns a new {@link IntBinding} whose {@link ReadableInt#get() value} is equal to the value of {@code this} minus
	 * the value of {@code subtrahend}.
	 */
	public IntBinding subtract(final IntBinding subtrahend) {
		return fromOperator((a, b) -> a - b, subtrahend);
	}
	
	//In the spirit of lambdas (and also in saving a lot of unnecessary code) I decided to implement my "multiply",
	//"add", "subtract", etc. methods using a functional interface. The fromOp() method takes the operation (such as
	//addition, subtraction, etc.) and the second operand to that operation as an IntBinding. This way I can implement
	//all four of the mathematical operator methods in a single (anonymous) class.
	
	private IntBinding fromOperator(IntBinaryOperator op, IntBinding second) {
		//again, you could have written your own class here, but I decided to do it anonymously.
		return new IntBinding() {
			//I'm using an instance initializer to do some preliminary "construction" of the object:
			{	
				//The change listeners will be called for two reasons:
				//	1) When the first operand (the enclosing instance of this anonymous class) changes
				//	2) When the second operand ('second') changes.
				IntBinding.this.addChangeListener((o, n) -> runChangeListeners(op.applyAsInt(o, second.get()), get()));
				//'IntBinding.this' refers to the enclosing class (the non-anonymous one). If I just used
				//'this', it would refer to the anonymous class that this comment is in.
				second.addChangeListener((o, n) -> runChangeListeners(op.applyAsInt(IntBinding.this.get(), o), get()));
				//Note that I'm recomputing what the "old value" was on demand, which could be avoided if we stored
				//the old value in an instance variable or something. I decided not to go with that approach.
			}

			@Override
			public int get() {
				//the result is computed live when get() is called.
				return op.applyAsInt(IntBinding.this.get(), second.get());
				//Alternatively, we could compute the new value of this IntBinding whenever it changes, store it in an instance
				//variable, and return it here. That would likely be more efficient, at the cost of some extra memory.
				//I just went with the simple approach here.
			}
			
		};
	}

}
