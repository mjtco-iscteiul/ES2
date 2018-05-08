package pt.iscte.es2.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * DTO for the Optimization Job Executions
 */
public class OptimizationJobExecutions {

	private OptimizationConfiguration optimizationConfiguration;
	private Date startDate;
	private Date endDate;
	private Enum<State> state;
	private List<OptimizationJobSolutions> optimizationJobSolutions;

	public OptimizationConfiguration getOptimizationConfiguration() {
		return optimizationConfiguration;
	}

	public void setOptimizationConfiguration(OptimizationConfiguration optimizationConfiguration) {
		this.optimizationConfiguration = optimizationConfiguration;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Enum<State> getState() {
		return state;
	}

	public void setState(Enum<State> state) {
		this.state = state;
	}

	public List<OptimizationJobSolutions> getOptimizationJobSolutions() {
		if (optimizationJobSolutions == null) {
			optimizationJobSolutions = new ArrayList<>();
		}
		return optimizationJobSolutions;
	}

	public void setOptimizationJobSolutions(List<OptimizationJobSolutions> optimizationJobSolutions) {
		this.optimizationJobSolutions = optimizationJobSolutions;
	}
}