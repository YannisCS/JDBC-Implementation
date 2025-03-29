package blog.model;

import java.util.Objects;

public class JobsForGear {
	private Gears gear;
	private AvailableJobs job;
	
	public JobsForGear(Gears gear, AvailableJobs job) {
		super();
		this.gear = gear;
		this.job = job;
	}

	public Gears getGear() {
		return gear;
	}

	public void setGear(Gears gear) {
		this.gear = gear;
	}

	public AvailableJobs getJob() {
		return job;
	}

	public void setJob(AvailableJobs job) {
		this.job = job;
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
		return "JobsForGear [job=" + job + "]";
	}
	
}