package pt.iscte.es2.optimization_job_runner.post_processing;

import java.util.List;

/**
 * The job result abstraction generated by jmetal
 */
public class OptimizationJobResult {
	private final PostProcessingContext context;
	private Long jobId;
	private List<AlgorithmSolutionQuality> bestSolutions;
	private String latexPdf;
	private String rEps;

	/**
	 * Constructor
	 * @param context the context in which the solution was created
	 */
	public OptimizationJobResult(PostProcessingContext context) {
		this.context = context;
		jobId = context.getJob().getJobId();
	}

	/**
	 * @return the context in which the solution was created
	 */
	public PostProcessingContext getContext() {
		return context;
	}

	/**
	 * @return job id
	 */
	public Long getJobId() {
		return jobId;
	}

	/**
	 * @return the best solutions generated
	 */
	public List<AlgorithmSolutionQuality> getBestSolutions() {
		return bestSolutions;
	}

	/**
	 * Set the best solutions
	 * @param bestSolutions the best solutions generated
	 */
	public void setBestSolutions(List<AlgorithmSolutionQuality> bestSolutions) {
		this.bestSolutions = bestSolutions;
	}

	/**
	 * @return LatexPdf location
	 */
	public String getLatexPdf() {
		return latexPdf;
	}

	/**
	 * Set the LatexPdf location
	 * @param latexPdf LatexPdf location
	 */
	public void setLatexPdf(String latexPdf) {
		this.latexPdf = latexPdf;
	}

	/**
	 * @return the R Eps
	 */
	public String getrEps() {
		return rEps;
	}

	/**
	 * Set the R Eps
	 * @param rEps the R eps
	 */
	public void setrEps(String rEps) {
		this.rEps = rEps;
	}
}
