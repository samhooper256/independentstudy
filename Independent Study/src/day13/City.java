package day13;

import java.util.Objects;

public class City {
	
	private final String name;
	private final State state;
	private final int population;
	
	public City(String name, State state, int population) {
		super();
		this.name = name;
		this.state = state;
		this.population = population;
	}

	public String getName() {
		return name;
	}

	public State getState() {
		return state;
	}

	public int getPopulation() {
		return population;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, population, state);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		City other = (City) obj;
		return Objects.equals(name, other.name) && population == other.population && Objects.equals(state, other.state);
	}

	@Override
	public String toString() {
		return "City [name=" + name + ", state=" + state + ", population=" + population + "]";
	}
	
	
}
