package day5;

public interface Self<T extends Self<T>> {
	
}

//We could not put something like "implements Self<Object>" here because of the self-bounded type variable.
class Imp implements Self<Imp> {
	
}
