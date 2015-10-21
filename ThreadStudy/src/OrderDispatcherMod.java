
 
import java.util.ArrayList;
 
/**
 * Order负载均衡实现类
 *
 */
public class OrderDispatcherMod {
	public static void main(String[] args) {
		for(int i = 0 ; i < 100 ; i++){
			if(i%6==0){
				System.out.println("0----------->"+i);
			}else if(i%6==1){
				System.out.println("1----------->"+i);
			}else if(i%6==2){
				System.out.println("2----------->"+i);
			}else if(i%6==3){
				System.out.println("3----------->"+i);
			}else if(i%6==4){
				System.out.println("4----------->"+i);
			}else if(i%6==5){
				System.out.println("5----------->"+i);
			}
		}
	}
 
}