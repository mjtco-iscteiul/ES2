package pt.iscte.es2.dto;

/**
 * DTO of the OptimizationConfigurationObjectives
 */
public class OptimizationConfigurationObjectives {

	private Integer id;
	private OptimizationConfiguration optimizationConfiguration;
	private String name;

	public OptimizationConfigurationObjectives() {

	}

	public OptimizationConfigurationObjectives(String name) {
		this.name = name;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public OptimizationConfiguration getOptimizationConfiguration() {
		return optimizationConfiguration;
	}

	public void setOptimizationConfiguration(OptimizationConfiguration optimizationConfiguration) {
		this.optimizationConfiguration = optimizationConfiguration;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}