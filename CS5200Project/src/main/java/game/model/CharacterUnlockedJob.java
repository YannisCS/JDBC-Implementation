package game.model;

import java.util.Objects;

public class CharacterUnlockedJob{
	private Characters character;
	private String jobName;
	private int jobLevel;
	private int xP;
	
	public CharacterUnlockedJob(Characters character, String jobName, int jobLevel, int xP) {
		super();
		this.character = character;
		this.jobName = jobName;
		this.jobLevel = jobLevel;
		this.xP = xP;
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

	public int getJobLevel() {
		return jobLevel;
	}

	public void setJobLevel(int jobLevel) {
		this.jobLevel = jobLevel;
	}

	public int getxP() {
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
    	jobLevel == characterUnlockedJob.jobLevel &&
    	xP == characterUnlockedJob.xP;
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