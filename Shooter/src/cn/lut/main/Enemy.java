package cn.lut.main;
/**
 * 所有可以得分的对象都要实现这个接口
 * @author Administrator
 *
 */
public interface Enemy {
	//打掉敌机的时候获取的分数
	
	int getScore();
}
