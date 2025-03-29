package blog.model;

public class AvailableJobs {
	private String jobName;

	public AvailableJobs(String jobName) {
		this.jobName = jobName;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	
	
    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) {
        return false;
      }
      AvailableJobs job = (AvailableJobs) o;
      return
        jobName == job.jobName;
    }

    @Override
    public int hashCode() {
      throw new UnsupportedOperationException("hashing not supported");
    }

	@Override
	public String toString() {
		return "AvaliableJobs [jobName=" + jobName + "]";
	}

}