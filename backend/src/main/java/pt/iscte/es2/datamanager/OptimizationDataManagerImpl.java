package pt.iscte.es2.datamanager;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pt.iscte.es2.dao.*;
import pt.iscte.es2.dto.*;
import pt.iscte.es2.jpa.*;

import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class OptimizationDataManagerImpl implements OptimizationDataManager {

	@Autowired
	private FileUploadDao fileUploadDao;

	@Autowired
	private OptimizationConfigurationDao optimizationConfigurationDao;

	@Autowired
	private OptimizationConfigurationVariablesDao optimizationConfigurationVariablesDao;

	@Autowired
	private OptimizationConfigurationObjectivesDao optimizationConfigurationObjectivesDao;

	@Autowired
	private OptimizationConfigurationAlgorithmsDao optimizationConfigurationAlgorithmsDao;

	@Autowired
	private OptimizationConfigurationRestrictionsDao optimizationConfigurationRestrictionsDao;

	@Autowired
	private OptimizationConfigurationUserSolutionsDao optimizationConfigurationUserSolutionsDao;

	@Autowired
	private Mapper mapper;

	/**
	 * @see OptimizationDataManager#searchFilePathBySessionId(String)
	 */
	public String searchFilePathBySessionId(String sessionId) {
		return fileUploadDao.findBySessionId(sessionId).getFilePath();
	}

	/**
	 * @see OptimizationDataManager#saveOptimization(OptimizationConfiguration)
	 */
	public OptimizationConfiguration saveOptimization(OptimizationConfiguration optimizationConfiguration) {
		OptimizationConfigurationEntity entity = mapper.map(optimizationConfiguration, OptimizationConfigurationEntity.class);
		OptimizationConfigurationEntity savedOptimizationConfigurationEntity = optimizationConfigurationDao.saveAndFlush(entity);
		OptimizationConfiguration savedOptimizationConfiguration = mapper.map(savedOptimizationConfigurationEntity, OptimizationConfiguration.class);

		optimizationConfiguration.getVariables()
			.forEach(optimizationConfigurationVariables -> {
				OptimizationConfigurationVariablesEntity variableEntity = mapper.map(optimizationConfigurationVariables, OptimizationConfigurationVariablesEntity.class);
				variableEntity.setOptimizationConfiguration(savedOptimizationConfigurationEntity);
				savedOptimizationConfiguration
					.getVariables()
					.add(mapper.map(
						optimizationConfigurationVariablesDao.saveAndFlush(variableEntity), OptimizationConfigurationVariables.class));
			});

		optimizationConfiguration.getAlgorithms()
			.forEach(optimizationConfigurationAlgorithms -> {
				OptimizationConfigurationAlgorithmsEntity algorithmsEntity = mapper.map(optimizationConfigurationAlgorithms, OptimizationConfigurationAlgorithmsEntity.class);
				algorithmsEntity.setOptimizationConfiguration(savedOptimizationConfigurationEntity);
				savedOptimizationConfiguration
					.getAlgorithms()
					.add(mapper.map(
						optimizationConfigurationAlgorithmsDao.saveAndFlush(algorithmsEntity), OptimizationConfigurationAlgorithms.class));
			});

		optimizationConfiguration.getObjectives()
			.forEach(optimizationConfigurationObjectives -> {
				OptimizationConfigurationObjectivesEntity objectivesEntity = mapper.map(optimizationConfigurationObjectives, OptimizationConfigurationObjectivesEntity.class);
				objectivesEntity.setOptimizationConfiguration(savedOptimizationConfigurationEntity);
				savedOptimizationConfiguration
					.getObjectives()
					.add(mapper.map(
						optimizationConfigurationObjectivesDao.saveAndFlush(objectivesEntity), OptimizationConfigurationObjectives.class));
			});

		optimizationConfiguration.getRestrictions()
			.forEach(optimizationConfigurationRestrictions -> {
				OptimizationConfigurationRestrictionsEntity restrictionsEntity = mapper.map(optimizationConfigurationRestrictions, OptimizationConfigurationRestrictionsEntity.class);
				restrictionsEntity.setOptimizationConfiguration(savedOptimizationConfigurationEntity);
				savedOptimizationConfiguration
					.getRestrictions()
					.add(mapper.map(
						optimizationConfigurationRestrictionsDao.saveAndFlush(restrictionsEntity), OptimizationConfigurationRestrictions.class));
			});

		optimizationConfiguration.getUserSolutions()
			.forEach(optimizationConfigurationUserSolutions -> {
				OptimizationConfigurationUserSolutionsEntity userSolutionsEntity = mapper.map(optimizationConfigurationUserSolutions, OptimizationConfigurationUserSolutionsEntity.class);
				userSolutionsEntity.setOptimizationConfiguration(savedOptimizationConfigurationEntity);
				savedOptimizationConfiguration
					.getUserSolutions()
					.add(mapper.map(
						optimizationConfigurationUserSolutionsDao.saveAndFlush(userSolutionsEntity), OptimizationConfigurationUserSolutions.class));
			});
		return savedOptimizationConfiguration;
	}


	/**
	 * @see OptimizationDataManager#saveFileUpload(String, String)
	 */
	public FileUpload saveFileUpload(String sessionId, String filePath) {
		FileUploadEntity entity = new FileUploadEntity();
		entity.setSessionId(sessionId);
		entity.setFilePath(filePath);
		FileUploadEntity savedFileUploadEntity = fileUploadDao.saveAndFlush(entity);
		return new FileUpload(savedFileUploadEntity.getId().intValue(), entity.getSessionId(), entity.getFilePath());
	}

}
