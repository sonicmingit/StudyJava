package win.sonic.a.datatype;

public class cars{
       //��ɫ
            String color;
       //�۸�
            int price;
       //Ʒ��
            String brand;
       //�޲α��ܵķ���
            void run(){
            System.out.println("����������ɫ�ǣ�"+color+"; �������ļ۸��ǣ�"+price+"; ��������Ʒ���ǣ�"+brand );
       }
       //�вα��ܵķ���2
            void run(int speed){
           System.out.println("����������ɫ�ǣ�"+color+"; �������ļ۸��ǣ�"+price+"; ��������Ʒ���ǣ�"+brand +"; ���������ٶ�Ϊ��"+speed+"km/h");
       }
       //���еķ���
            void run(String go){
            switch (go){
            	case "go" : System.out.println("��ʼǰ��");
            	break;
            	case "back" : System.out.println("��ʼ����");
            	break;
            	default :System.out.println("�������");
            }
            }
       
       //�ж��Ƿ�Ϊ�ó�
            void price(){
            	System.out.println(price>20000?"����һ������":"�⳵һ��");
            }
       //�������޲ι��췽��
         public cars(){
            System.out.println("����һ����");
       }
       //�������вι��췽��
            public cars(String color,int price,String brand ){
            this.color=color;
            this.price=price;
            this.brand=brand;
       }
       }
