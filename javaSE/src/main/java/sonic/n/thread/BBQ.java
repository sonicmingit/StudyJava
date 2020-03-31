package sonic.n.thread;

import java.util.ArrayList;

public class BBQ {
	// �ѿ��ò�Ʒ
	private ArrayList<String> menu = new ArrayList<String>();
	// ���깲������
	public static int count;

	// �ϲ�
	public String serving() {
		// ������Ͳ�����
		if (count > 11) {
			System.out.println("��������տ�������~����������!");
			return "";
			// ��û����,��ȴ�
		} else if (menu.isEmpty()) {
			System.out.println("�˻�û����,���Ե�");
			return "";
		} else {
			return menu.remove(0);
		}
	}

	// ��ӿ��õĲ�
	public void add(String name) {
		menu.add(name);

	}

	// ��ȡ�ѿ��ò�Ʒ��
	public int getCount() {
		return menu.size();
	}

}
