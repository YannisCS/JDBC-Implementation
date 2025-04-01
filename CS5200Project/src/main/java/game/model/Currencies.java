package game.model;

import java.math.BigDecimal;
import java.util.Objects;

public class Currencies {
	private String currencyName;
	private BigDecimal cap; 
	private BigDecimal weeklyCap;
	
	public Currencies(String currencyName, BigDecimal cap, BigDecimal weeklyCap) {
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

	public BigDecimal getCap() {
		return cap;
	}

	public void setCap(BigDecimal cap) {
		this.cap = cap;
	}

	public BigDecimal getWeeklyCap() {
		return weeklyCap;
	}

	public void setWeeklyCap(BigDecimal weeklyCap) {
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
		return Objects.equals(cap, other.cap) && Objects.equals(currencyName, other.currencyName)
				&& Objects.equals(weeklyCap, other.weeklyCap);
	}

	@Override
	public String toString() {
		return "Currencies [ currencyName=" + currencyName + ", cap=" + cap
				+ ", weeklyCap=" + weeklyCap + "]";
	}
	
	

}
