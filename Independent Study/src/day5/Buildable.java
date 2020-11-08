package day5;

public interface Buildable<T extends Buildable<T>> {
	T build();
}
