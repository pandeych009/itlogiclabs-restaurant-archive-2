package com.itlogiclab.order.utils;

import static com.itlogiclab.order.utils.EvaluationConstants.FAILED_FILE_PATH;
import static com.itlogiclab.order.utils.EvaluationConstants.IN_PROGRESS_FILE_PATH;
import static com.itlogiclab.order.utils.EvaluationConstants.PROCESSED_FILE_PATH;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.itlogiclab.order.exception.EvaluationFileHandlingException;

@Service
public class EvaluationFileUtils {

	private static Logger logger = LogManager.getLogger(EvaluationFileUtils.class); 
	
	
	@Value("${evaluate.file.location: D://Users//cpandey//Desktop//Evaluations//Interviews//New}")
	private String location; 
	
	@Value("${evaluate.file.name.content:Candidate_Evaluation_Scoring}")
	private String fileContent; 
	
	@Value("${evaluate.file.extension.content:xlsx}")
	private String fileExtension; 
	
	@Value("${evaluate.output.file.location: D:\\Users\\cpandey\\Desktop\\Evaluations\\Interviews\\New\\GeneratedFiles}")
	private String outFileLocation;
	
	@Value("${evaluate.output.file.fileNamePattern:Incentive_Summary}")
	private String fileNamePattern; 
	
	
	public boolean moveFile(String sourceLocation, String destLocation) throws EvaluationFileHandlingException{
		File sourceDir = new File(sourceLocation);
		File destDir = new File(destLocation);

		try {
			FileUtils.moveDirectory(sourceDir, destDir);
		} catch (IOException e) {
			logger.error("Error occured while moving file from src: "+ sourceLocation +" to destination: "+destLocation);
			throw new EvaluationFileHandlingException("Error occured while moving file from src: "+ sourceLocation +" to destination: "+destLocation);
		}
		return true;
	}

	
	public void moveFileToInProgressDir(){
		String destination =  location+IN_PROGRESS_FILE_PATH;
		File sourceDir = new File(location);
		moveFilesToDir(sourceDir, destination);
		logger.debug("File  : "+sourceDir.getName() + " is moved to in processed dir");
	}
	
	public void moveFileToInProgressDir(String location){
		String destination =  location+IN_PROGRESS_FILE_PATH;
		File sourceDir = new File(location);
		moveFilesToDir(sourceDir, destination);
		logger.debug("File  : "+sourceDir.getName() + " is moved to in processed dir");
	}
	

	public void moveFileToFailedDir(File sourceDir){
		String destination = location+FAILED_FILE_PATH; 
		//moveFilesToDir(sourceDir, destination);
		moveFilesToDir(sourceDir, new File(destination));
		logger.debug("File  : "+sourceDir.getName() + " is moved to failed dir");
	}
	
	public void moveFileToProcessedDir(File sourceDir){
		String destination = location+PROCESSED_FILE_PATH; 
		//moveFilesToDir(sourceDir, destination);
		moveFilesToDir(sourceDir, new File(destination));
		logger.debug("File  : "+sourceDir.getName() + " is moved to processed dir");
	}
	
	
	
	public void moveFileToDestinationDir(File sourceDir, File destination){
		moveFilesToDir(sourceDir, destination);
		logger.debug("File  : "+sourceDir.getName() + " is moved to in processed dir");
	}
	

	private void moveFilesToDir(File sourceDir, String destination) {
		try {
			List<File> files = Files.list(Paths.get(sourceDir.getAbsolutePath()))
					.map(Path::toFile)
					.filter(file -> file.isFile())
					.collect(Collectors.toList());
			
			files.stream().forEach(inputFile -> {
				logger.debug("Start Moving file "+inputFile.getName()+" "+inputFile.getParent());
				moveFilesToDir(inputFile, new File(destination));
			});
			
		} catch (IOException e1) {
			logger.error("Error occured while moving files from sourceDir "+sourceDir.getPath()+" to destination: "+destination+" "+e1.getMessage());
		}
		
	}
	
	
	private void moveFilesToDir(File inputFile, File destination) {
		try {
			FileUtils.moveFileToDirectory(inputFile, destination, true);
		} catch (IOException e) {
			logger.error("Error occured while moving files from sourceDir  "+inputFile.getPath()+" to destination: "+e.getMessage());
		}
	}
	
	
	public List<File> getAllFilesInInProgressDir() throws IOException{
		List<Predicate<File>> predicates = new ArrayList<Predicate<File>>();
		predicates.add(file -> file.isFile());
		predicates.add(file -> file.getName().contains(fileContent) );
		predicates.add(file -> FilenameUtils.getExtension(file.getName()).equals(fileExtension));
		
		List<File> files = Files.list(Paths.get(location+IN_PROGRESS_FILE_PATH))
				.map(Path::toFile)
				.filter(predicates.stream().reduce(predicate -> true, Predicate::and))
				.collect(Collectors.toList());
		
		return files;
	}
	
	
	
	public void generateOutFile() throws IOException{
		
		SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyyHHmmss");
		formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
		String formattedDate = formatter.format(Calendar.getInstance().getTime());
		
		OutputStream oos = new FileOutputStream(outFileLocation+File.separator+fileNamePattern+formattedDate+"."+fileExtension);
		//workbook.write(oos);
	}

}
