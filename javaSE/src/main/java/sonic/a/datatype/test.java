package sonic.a.datatype;


public class test {
	public static void main(String[] args) {
        cars BMW = new cars();
        BMW.run();
        BMW.run("go");
        BMW.run("b");
        BMW.run("1");
        cars BenZ = new cars("红色",500000,"奔驰");
        BenZ.run(245);
        BenZ.price();
 }

}
