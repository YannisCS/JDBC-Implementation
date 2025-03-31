package game.model;

import java.util.Objects;

public class Currencies {
	private String currencyName;
	private float cap; 
	private float weeklyCap;
	
	public Currencies(String currencyName, float cap, float weeklyCap) {
		this.currencyName = currencyName;
		this.cap = cap;
		this.weeklyCap = weeklyCap;
	}

	public String getCurrencyName() {
		return currencyName;
	}

	public void setCurrencyName(String currencyName) {
		this.currencyName = currencyName;
	}

	public float getCap() {
		return cap;
	}

	public void setCap(float cap) {
		this.cap = cap;
	}

	public float getWeeklyCap() {
		return weeklyCap;
	}

	public void setWeeklyCap(float weeklyCap) {
		this.weeklyCap = weeklyCap;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cap, currencyName, weeklyCap);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Currencies other = (Currencies) obj;
		return Float.floatToIntBits(cap) == Float.floatToIntBits(other.cap)
				&& Objects.equals(currencyName, other.currencyName)
				&& Float.floatToIntBits(weeklyCap) == Float.floatToIntBits(other.weeklyCap);
	}

	@Override
	public String toString() {
		return "Currencies [ currencyName=" + currencyName + ", cap=" + cap
				+ ", weeklyCap=" + weeklyCap + "]";
	}
	
	

}
