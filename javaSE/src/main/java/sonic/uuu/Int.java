package sonic.uuu;
/**
 * <strong> 自定义一些Int方法</strong><br />
 *
 *
 * @author Sonic
 *
 */
public class Int {
	/**
     * 传入两个整型数组,按照传入顺序合并,并返回合并后的整型数组<br />
     * 2014-04-25
     * @param a
     *            要合并的第一个整型数组
     * @param b
     *            要合并的第二个整型数组
     * @return 合并后的整型数组
     */
    public static int[] cancat(int[] a, int[] b) {       
          // 创建两个值用来接收传入数组的长度
          int aL = a.length;
          int bL = b.length;
          // 创建一个接收合并的数组,长度等于两数组相加
          int[] c = new int[aL + bL];
          // 把第一个数组复制到新数组的起始位置
          System.arraycopy(a, 0, c, 0, aL);
          // 把第二个数组从第一个数组的长度位开始复制到新数组
          System.arraycopy(b, 0, c, aL, bL);         
          return c;
    }
}

