package sonic.i.inter;

//IAb继承了接口A和接口B,实现接口IAb的类必须实现接口A和B的方法
public interface IAb extends IA, IB {
	//接口iab的方法
	void iab();
}
