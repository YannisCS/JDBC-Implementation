package game.model;

import java.util.Objects;

public class Clans {
	public enum Races {
		DWARF, ELF, GOBLIN, HUMAN, ORC
	}
	 
	private String clanName;
	private Races race;
	
	public Clans(String clanName, Races race) {
		super();
		this.clanName = clanName;
		this.race = race;
	}
	
	public String getClanName() {
		return clanName;
	}
	
	public void setClanName(String clanName) {
		this.clanName = clanName;
	}
	
	public Races getRace() {
		return race;
	}
	
	public void setRace(Races race) {
		this.race = race;
	}

	@Override
	public int hashCode() {
	    throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Clans other = (Clans) obj;
		return Objects.equals(clanName, other.clanName) && Objects.equals(race, other.race);
	}

	@Override
	public String toString() {
		return String.format(
				"Clans [clanName=%s, race=%s]", 
				clanName, race);
	}
	
	
	
	 
	 
}
