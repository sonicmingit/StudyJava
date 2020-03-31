
package sonic.i.inter.school;

/**
 * <h3>作业题目</h3>
 * <h4>为不同身份的人提供不同的吃饭住宿方式</h4>
 * <table border="1px">
 * <tr>
 * <th>身份</th>
 * <th>住宿</th>
 * <th>吃饭</th>
 * </tr>
 * <tr>
 * <td>学生</td>
 * <td>宿舍</td>
 * <td>食堂</td>
 * </tr>
 * <tr>
 * <td>老师</td>
 * <td>教工宿舍</td>
 * <td>食堂</td>
 * </tr>
 * <tr>
 * <td>学生家长</td>
 * <td>招待所</td>
 * <td>招待所</td>
 * </tr>
 * </table>
 * 
 * @author 郝一鸣
 *
 */
public class Identity implements IEat,IStay {
	IEat eat;
	IStay stay;

	/**
	 * @param eat
	 *            要设置的 eat
	 */
	public void setEat(IEat eat) {
		this.eat = eat;
	}

	/**
	 * @param stay
	 *            要设置的 stay
	 */
	public void setStay(IStay stay) {
		this.stay = stay;
	}

	public void whereStay() {
		stay.whereStay();
	}


	public void WhereEat() {
		eat.WhereEat();
	}

	
	public void WhatEat() {
		eat.WhatEat();
	}

}
