import com.test.MyEnum.orderStatus;

import java.math.BigDecimal;


/**
 * @author 001
 */
public class Test20200422 {

    public static void main(String[] args) {
//        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
//        for (int element : numbers) {
//            System.out.println(element);
//        }
//        System.out.println("****************lambda**************");
//        numbers.forEach(s->{
//            if (s%2==0){
//                System.out.println(s);
//            }
//
//        });
        float a = 0.125f;
        double b = 0.125d;

        System.out.println((a - b) == 0.0);

        System.out.println(0.0 / 0.0);

        System.out.println(0.8 - 0.7);

        BigDecimal i = new BigDecimal("0.8");
        BigDecimal j = new BigDecimal("0.7");
        System.out.println(i.subtract(j));

        System.out.println(orderStatus.AGREE.getCode());
    }
}
