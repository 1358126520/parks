package park;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CCC {

	
	// Jdk1.7�Ժ��Դ���ȫ��log�������������FileHandler������д���ļ���־��
	protected static Logger sysLog = Logger.getGlobal();
	static {
		// ����jdk�Դ���ȫ��logû��д���ļ��Ĺ��ܣ��������ֶ�������ļ�handler
		LogUtil.addFileHandler(sysLog, Level.INFO,LogUtil.LOG_FOLDER + File.separator + "sys.log");
	}

}
