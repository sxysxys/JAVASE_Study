package initandclean.EnumInit;

/**
 * @Author: shenge
 * @Date: 2020-03-31 11:43
 * 枚举类型可以当做一个普通的静态类来用，只不过他具有一些特性，可以套在一些常量才能使用的场合进行使用。
 */


public class EnumTest {
    Color color;
    public EnumTest(Color color){
        this.color=color;
    }
    public void describe(){
        System.out.println("The color is:");
        switch (color){
            case RED:
                System.out.println("redha");
                break;
            case BLACK:
                System.out.println("blackha");
                break;
            case YELLOW:
                System.out.println("搞黄色？");
                break;
            default:
                System.out.println("gg咯");
        }
    }
    public void showEnum(){
        for (Color o : Color.values()) {
            System.out.println(o);
        }
    }

    public static void main(String[] args) {
        EnumTest enumTest = new EnumTest(Color.WHITE);
        enumTest.showEnum();
        System.out.println("-------------");
        EnumTest black = new EnumTest(Color.BLACK);
        EnumTest red = new EnumTest(Color.RED);
        EnumTest yellow = new EnumTest(Color.YELLOW);
        EnumTest white = new EnumTest(Color.WHITE);
        black.describe();
        red.describe();
        yellow.describe();
        white.describe();
        System.out.println("--------");
    }
}
