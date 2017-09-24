package win.sonic.a.datatype;

public class cars{
       //颜色
            String color;
       //价格
            int price;
       //品牌
            String brand;
       //无参奔跑的方法
            void run(){
            System.out.println("这辆车的颜色是："+color+"; 这辆车的价格是："+price+"; 这辆车的品牌是："+brand );
       }
       //有参奔跑的方法2
            void run(int speed){
           System.out.println("这辆车的颜色是："+color+"; 这辆车的价格是："+price+"; 这辆车的品牌是："+brand +"; 这辆车的速度为："+speed+"km/h");
       }
       //运行的方法
            void run(String go){
            switch (go){
            	case "go" : System.out.println("开始前进");
            	break;
            	case "back" : System.out.println("开始后退");
            	break;
            	default :System.out.println("输入错误");
            }
            }
       
       //判断是否为好车
            void price(){
            	System.out.println(price>20000?"这是一辆豪车":"这车一般");
            }
       //汽车的无参构造方法
         public cars(){
            System.out.println("这是一辆车");
       }
       //汽车的有参构造方法
            public cars(String color,int price,String brand ){
            this.color=color;
            this.price=price;
            this.brand=brand;
       }
       }
