package game.model;

import java.util.Objects;

public class Characters {
	private int charID;
	private Players players;
	private String firstName;
	private String lastName;
	private Clans clan;
	private Weapons weaponWeared;
	
	public Characters(int charID, Players players, String firstName, String lastName, Clans clan, Weapons weaponWeared) {
		super();
		this.charID = charID;
		this.players = players;
		this.firstName = firstName;
		this.lastName = lastName;
		this.clan = clan;
		this.weaponWeared = weaponWeared;
	}

	public int getCharID() {
		return charID;
	}

	public void setCharID(int charID) {
		this.charID = charID;
	}

	public Players getPlayers() {
		return players;
	}

	public void setPlayers(Players players) {
		this.players = players;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Clans getClan() {
		return clan;
	}

	public void setClan(Clans clan) {
		this.clan = clan;
	}

	public Weapons getWeaponWeared() {
		return weaponWeared;
	}

	public void setWeaponWeared(Weapons weaponWeared) {
		this.weaponWeared = weaponWeared;
	}

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) {
        return false;
      }
      Characters characters = (Characters) o;
      return
    	charID == characters.charID &&
    	Objects.equals(players, characters.players) &&
        Objects.equals(firstName, characters.firstName) &&
        Objects.equals(lastName, characters.lastName) &&
        Objects.equals(clan, characters.clan) &&
        Objects.equals(weaponWeared, characters.weaponWeared);
    }
    
    @Override
    public int hashCode() {
      throw new UnsupportedOperationException("hashing not supported");
    }
    
	@Override
	public String toString() {
		return "Characters [charID=" + charID + ", players=" + players + ", firstName=" + firstName + ", lastName="
				+ lastName + "]";
	}

	
}