package lambdalab;

/**
 * <p>An object that refers to some {@code int}, which can be retrieved from the {@link #get()} method. This
 * {@code int} value may change, so {@code ReadableInts} also allow {@link IntChangeListener IntChangeListeners} to be
 * {@link #addChangeListener(IntChangeListener) added} and {@link #removeChangeListener(IntChangeListener) removed}. These
 * listeners will be fired whenever the {@link #get() value} changes.
 *
 */
public interface ReadableInt {
	
	/**
	 * Returns the value of this {@link ReadableInt}, as an {@code int}.
	 * @return the value of this {@link ReadableInt}.
	 */
	int get();
	
	/**
	 * Adds an {@link IntChangeListener} that listens to this {@link ReadableInt}. This listener will be fired
	 * whenever the {@link #get() value} of this {@code ReadableInt} changes. The listeners currently
	 * listening to this {@code ReadableInt} are fired in the order they were added (via this method).
	 * @param listener the {@link IntChangeListener} that will listen to this {@link ReadableInt}.
	 */
	void addChangeListener(final IntChangeListener listener);
	
	/**
	 * Removes the given {@link IntChangeListener} from this {@link ReadableInt}. The listener will no longer be fired when this
	 * {@code ReadableInt's} {@link #get() value} changes. Returns {@code false} if {@code listener} is not currently listening
	 * to this {@code ReadableInt}; otherwise, returns {@code true} and removes the listener from this {@code ReadableInt}.
	 * @param listener the {@link IntChangeListener} to be removed.
	 * @return {@code true} if {@code listener} was listening to this {@link ReadableInt} and has been removed, {@code false} otherwise.
	 */
	boolean removeChangeListener(final IntChangeListener listener);
	
}