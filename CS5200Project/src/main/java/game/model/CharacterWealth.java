package game.model;

import java.util.Objects;

public class CharacterWealth {
	private Characters character;
	private Currencies currency;
	private float amount;
	private float weeklyAcquired;
	
	public CharacterWealth(Characters character, Currencies currency, float amount, float weeklyAcquired) {
		this.character = character;
		this.currency = currency;
		this.amount = amount;
		this.weeklyAcquired = weeklyAcquired;
	}

	public Characters getCharacter() {
		return character;
	}

	public void setPlayer(Characters character) {
		this.character = character;
	}

	public Currencies getCurrency() {
		return currency;
	}

	public void setCurrency(Currencies currency) {
		this.currency = currency;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public float getWeeklyAcquired() {
		return weeklyAcquired;
	}

	public void setWeeklyAcquired(float weeklyAcquired) {
		this.weeklyAcquired = weeklyAcquired;
	}

	@Override
	public int hashCode() {
		return Objects.hash(amount, currency, character, weeklyAcquired);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CharacterWealth other = (CharacterWealth) obj;
		return Float.floatToIntBits(amount) == Float.floatToIntBits(other.amount)
				&& Objects.equals(currency, other.currency) && Objects.equals(character, other.character)
				&& Float.floatToIntBits(weeklyAcquired) == Float.floatToIntBits(other.weeklyAcquired);
	}

	@Override
	public String toString() {
		return "CharacterWealth [player=" + character + ", currency=" + currency + ", amount=" + amount
				+ ", weeklyAcquired=" + weeklyAcquired + "]";
	}
	
	
}
