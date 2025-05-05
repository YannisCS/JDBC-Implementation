package game.model;

import java.util.Objects;

public class CharacterUnlockedJob{
	private Characters character;
	private String jobName;
	private Integer jobLevel;
	private Integer xP;
	
	public CharacterUnlockedJob(Characters character, String jobName, Integer jobLevel, Integer xP) {
		super();
		this.character = character;
		this.jobName = jobName;
		this.jobLevel = jobLevel;
		this.xP = xP;
	}

	public CharacterUnlockedJob(Characters character, String jobName) {
		super();
		this.character = character;
		this.jobName = jobName;
		this.jobLevel = null;
		this.xP = null;
	}
	
	public Characters getCharacter() {
		return character;
	}

	public void setCharacter(Characters character) {
		this.character = character;
	}

	public String getJob() {
		return jobName;
	}

	public void setJob(String jobName) {
		this.jobName = jobName;
	}

	public Integer getJobLevel() {
		return jobLevel;
	}

	public void setJobLevel(int jobLevel) {
		this.jobLevel = jobLevel;
	}

	public Integer getxP() {
		return xP;
	}

	public void setxP(int xP) {
		this.xP = xP;
	}
	
	
    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) {
        return false;
      }
      CharacterUnlockedJob characterUnlockedJob = (CharacterUnlockedJob) o;
      return
    	Objects.equals(character, characterUnlockedJob.character) &&
    	Objects.equals(jobName, characterUnlockedJob.jobName) &&
    	Objects.equals(jobLevel, characterUnlockedJob.jobLevel) &&
        Objects.equals(xP, characterUnlockedJob.xP);
    }

    @Override
    public int hashCode() {
      throw new UnsupportedOperationException("hashing not supported");
    }

	@Override
	public String toString() {
		return "CharacterUnlockedJob [character=" + character + ", jobName=" + jobName + ", jobLevel=" + jobLevel + ", xP=" + xP
				+ "]";
	}
	
}