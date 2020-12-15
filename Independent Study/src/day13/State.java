package day13;

import java.util.Objects;

public class State {
	
	private final String name;
	private final Country country;
	
	public State(String name, Country country) {
		super();
		this.name = name;
		this.country = country;
	}

	public String getName() {
		return name;
	}

	public Country getCountry() {
		return country;
	}

	@Override
	public int hashCode() {
		return Objects.hash(country, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		State other = (State) obj;
		return Objects.equals(country, other.country) && Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "State [name=" + name + ", country=" + country + "]";
	}
	
	
	
}
