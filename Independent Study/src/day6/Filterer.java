package day6;

@FunctionalInterface
public interface Filterer<T> {
	boolean satisfies(T item);
}