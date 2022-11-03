package com.itlogiclab.order.utils;

import java.io.File;
import java.util.regex.Pattern;

public class EvaluationConstants {

	public static final String COLON_SAPERATOR = ":";
	public static final Pattern PATTERN_SPLIT_CELL_RANGE = Pattern.compile(COLON_SAPERATOR);
	
	public static final String IN_PROGRESS_FILE_PATH = File.separator+"inprogress"+File.separator;
	public static final String FAILED_FILE_PATH = File.separator+"failed"+File.separator;
	public static final String PROCESSED_FILE_PATH = File.separator+"processed"+File.separator;
	
}
