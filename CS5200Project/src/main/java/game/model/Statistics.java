package game.model;

import java.util.Objects;

public class Statistics {
	private String statsName;
	private String description;
	
	
	public Statistics(String statsName, String description) {
		this.statsName = statsName;
		this.description = description;
	}


	public String getStatsName() {
		return statsName;
	}


	public void setStatsName(String statsName) {
		this.statsName = statsName;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	@Override
	public int hashCode() {
		return Objects.hash(description, statsName);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Statistics other = (Statistics) obj;
		return Objects.equals(description, other.description) && Objects.equals(statsName, other.statsName);
	}


	@Override
	public String toString() {
		return "Statistics [statsName=" + statsName + ", description=" + description + "]";
	}
}
