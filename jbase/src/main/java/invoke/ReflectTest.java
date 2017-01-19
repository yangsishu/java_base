package invoke;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Field;
 
public class ReflectTest {
	//直接调用
	public static int numAdd(int loops){
		int val=0;
		long startTime=0;
		for(int i=0;i<loops;i++){
			if(i==0){startTime=System.nanoTime();}
			val+=i;
		}
		long totalTime=System.nanoTime()-startTime;
		System.out.println("直接调用总的纳秒时间：\t\t"+totalTime);
		return val;
	}
	//引用调用字段
	public static int numAddReference(int loops){
		User user=new User();
		long startTime=0;
		for(int i=0;i<loops;i++){
			if(i==0){startTime=System.nanoTime();}
			user.num+=i;
		}
		long totalTime=System.nanoTime()-startTime;
		System.out.println("引用调用字段总的纳秒时间：\t"+totalTime);
		return user.num;
	}
	//反射调用字段
	public static int numAddReflection(int loops) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{
		User user=new User();
		Class<?> cUser=user.getClass();
		long startTime=0;
		for(int i=0;i<loops;i++){
			if(i==0){startTime=System.nanoTime();}
			Field field=cUser.getField("num");
			field.set(user, field.getInt(user)+i);
		}
		long totalTime=System.nanoTime()-startTime;
		System.out.println("反射调用字段总的纳秒时间：\t"+totalTime);
		return user.num;
	}
	//方法句柄
	public static int numAddMethodHandle(int loops) throws Throwable{
		User user=new User();
		MethodHandles.Lookup lookkup=MethodHandles.lookup();
		MethodHandle mthGet=lookkup.findGetter(User.class, "num", int.class);
		MethodHandle mthSet=lookkup.findSetter(User.class, "num", int.class);
		long startTime=0;
		for(int i=0;i<loops;i++){
			if(i==0){startTime=System.nanoTime();}
			mthSet.invokeExact(user,(int)mthGet.invokeExact(user)+i);
		}
		long totalTime=System.nanoTime()-startTime;
		System.out.println("方法句柄调用字段总的纳秒时间：\t"+totalTime);
		return user.num;
	}
	
	public static void main(String[] args) throws Throwable{ 
		int loops=1000000;
		numAdd(loops);
		numAddReference(loops);
		numAddReflection(loops);
		numAddMethodHandle(loops);
	}
}
class User{
	public int num;
}
