package park;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CCC {

	
	// Jdk1.7以后自带的全局log（后面我添加了FileHandler，用于写入文件日志）
	protected static Logger sysLog = Logger.getGlobal();
	static {
		// 由于jdk自带的全局log没有写入文件的功能，我这里手动添加了文件handler
		LogUtil.addFileHandler(sysLog, Level.INFO,LogUtil.LOG_FOLDER + File.separator + "sys.log");
	}

}
