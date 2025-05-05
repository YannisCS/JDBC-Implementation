package game.model;

import java.math.BigDecimal;
import java.util.Objects;

public class CharacterWealth {
	private Characters character;
	private Currencies currency;
	private BigDecimal amount;
	private BigDecimal weeklyAcquired;
	
	public CharacterWealth(Characters character, Currencies currency, BigDecimal amount, BigDecimal weeklyAcquired) {
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

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public BigDecimal getWeeklyAcquired() {
		return weeklyAcquired;
	}

	public void setWeeklyAcquired(BigDecimal weeklyAcquired) {
		this.weeklyAcquired = weeklyAcquired;
	}

	@Override
	public int hashCode() {
		return Objects.hash(amount, character, currency, weeklyAcquired);
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
		return Objects.equals(amount, other.amount) && Objects.equals(character, other.character)
				&& Objects.equals(currency, other.currency) && Objects.equals(weeklyAcquired, other.weeklyAcquired);
	}

	@Override
	public String toString() {
		return "CharacterWealth [player=" + character + ", currency=" + currency + ", amount=" + amount
				+ ", weeklyAcquired=" + weeklyAcquired + "]";
	}
	
	
}
