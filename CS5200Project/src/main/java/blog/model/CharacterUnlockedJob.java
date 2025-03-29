package blog.model;

import java.util.Objects;

public class CharacterUnlockedJob{
	private Characters character;
	private AvailableJobs job;
	private int jobLevel;
	private int xP;
	
	public CharacterUnlockedJob(Characters character, AvailableJobs job, int jobLevel, int xP) {
		super();
		this.character = character;
		this.job = job;
		this.jobLevel = jobLevel;
		this.xP = xP;
	}

	public Characters getCharacter() {
		return character;
	}

	public void setCharacter(Characters character) {
		this.character = character;
	}

	public AvailableJobs getJob() {
		return job;
	}

	public void setJob(AvailableJobs job) {
		this.job = job;
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
      JobsForGear jobsForGear = (JobsForGear) o;
      return
    	Objects.equals(gear, jobsForGear.gear) &&
    	Objects.equals(job, jobsForGear.job);
    }

    @Override
    public int hashCode() {
      throw new UnsupportedOperationException("hashing not supported");
    }

	@Override
	public String toString() {
		return "CharacterUnlockedJob [character=" + character + ", job=" + job + ", jobLevel=" + jobLevel + ", xP=" + xP
				+ "]";
	}
	
}