package game.model;

import java.util.Objects;

public class CharacterStatistics {
	private Characters character;
	private Statistics statistics;
	private int value;
	
	
	public CharacterStatistics(Characters character, Statistics statistics, int value) {
		this.character = character;
		this.statistics = statistics;
		this.value = value;
	}


	public Characters getCharacter() {
		return character;
	}


	public void setCharacter(Characters character) {
		this.character = character;
	}


	public Statistics getStatistics() {
		return statistics;
	}


	public void setStatistics(Statistics statistics) {
		this.statistics = statistics;
	}


	public int getValue() {
		return value;
	}


	public void setValue(int value) {
		this.value = value;
	}


	@Override
	public int hashCode() {
		return Objects.hash(character, statistics, value);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CharacterStatistics other = (CharacterStatistics) obj;
		return Objects.equals(character, other.character) && Objects.equals(statistics, other.statistics)
				&& value == other.value;
	}


	@Override
	public String toString() {
		return "CharacterStatistics [character=" + character + ", statistics=" + statistics + ", value=" + value + "]";
	}	
}
