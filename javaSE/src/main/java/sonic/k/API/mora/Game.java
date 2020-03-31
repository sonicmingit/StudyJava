package sonic.k.API.mora;

/**
 * ��Ϸ��
 * @author Administrator
 *
 */
public class Game {
	//��������
	Computer com;
	//�������
	Person p;

	//��Ϸ�Ĺ��췽��
	public Game(Computer com, Person p) {
		super();
		this.com = com;
		this.p = p;
	}

	//��ķ���
	public void play() {
		// ��ҳ�ȭ
		int j = p.getI();
		// ������ȭ
		int i = com.check();
		// ��ȭ���бȽ� 
		if (j - i == 1 || i - j == 2) {
			System.out.println("���ӮӮӮӮӮӮ");
		}
		else if (i - j == 1 || j - i == 2) {
			System.out.println("����ӮӮӮӮӮӮ");

		} else {
			System.out.println("ƽ��");
		}
	}
}
