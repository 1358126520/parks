package park;


public class Stop extends CCC{
	int i=0;
	public int stops(String errorCode) {
		//����ʱ���ر�ˢ��
		switch(Integer.parseInt(errorCode)) {
			case 40001:sysLog.info("ȱ��Ȩ����֤����");i++;break;
			case 40002:sysLog.info("SignУ��ʧ��");i++;break;
			case 40003:sysLog.info("�ӿ�Ȩ����֤ʧ��");i++;break;
			case 40004:sysLog.info("IP��֤ʧ��");i++;break;
			case 40005:sysLog.info("�����յ�������");i++;break;
			case 40006:sysLog.info("����Ƶ������");i++;break;
			case 40007:sysLog.info("�˺��ѹ���");i++;break;
			case 40008:sysLog.info("�޴��û�");i++;break;
			case 41001:sysLog.info("ȱ��URL����");i++;break;
			case 41002:sysLog.info("ȱ�ٲ���");i++;break;
			case 41003:sysLog.info("��������");i++;break;
			case 41004:sysLog.info("�����쳣");i++;break;
			case 41005:sysLog.info("���������쳣");i++;break;
			case -1:sysLog.info("��������");i++;break;
		}
		return i;
	}
	
	
	
	
	
}
