package sonic.m.IO.file;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;

public class Filter_java implements FileFilter, FilenameFilter {

	@Override //FilenameFilter
	public boolean accept(File file, String arg1) {
		//过滤.java文件
		if (arg1.endsWith(".txt")) {
			return true;
		} else {
			return false;
		}
	}

	@Override //FileFilter
	public boolean accept(File arg0) {
		//过滤空文件
		if (arg0.getPath()=="File测试文件.txt") {
			return true;
		} else {
			return false;
		}
	}

}
