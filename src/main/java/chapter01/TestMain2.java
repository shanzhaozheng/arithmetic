package chapter01;

/**
 * 进制间转换
 */
public class TestMain2 {

    public static void main(String[] args) {
        // 1001
        System.out.println(dToB(100));
        // 53
        System.out.println(btoD(1,1,0,0,1,0,0));
        // AEC95
        System.out.println(dToH(715925));
        // 715925
        System.out.println(hToD("C","B"));

        System.out.println(BtoH(1,1,0,0,1,0,1,1));

        // 11001011
        System.out.println(HtoB("C", "B"));

    }


    /**
     * 十进制转二进制
     * @return
     */
    public static int dToB(int num){
        String sb= "";
        for (int i = num; i > 0 ; i/=2) {
            sb=(i%2)+sb;
        }
        return Integer.valueOf(sb);
    }

    /**
     *  二进制转10进制
     * @param num
     * @return
     */
    public static double btoD(int ... num){
        double sum = 0;
        for (int i = num.length - 1; i >= 0; i--) {
            sum = sum + num[i] * Math.pow(2,num.length - 1 - i);
        }
        return sum;
    }


    /**
     * 十进制转十六进制
     * @param num
     * @return
     */
    public static String dToH(int num){
        String str = "";
        for (int i = num; i > 0 ; i/=16) {
            int number = i%16;
            if (number < 10){
                str = number + str;
            }else {
                switch (number){
                    case 10:
                        str = "A" + str;
                        break;
                    case 11:
                        str = "B" + str;
                        break;
                    case 12:
                        str = "C" + str;
                        break;
                    case 13:
                        str = "D" + str;
                        break;
                    case 14:
                        str = "E" + str;
                        break;
                    case 15:
                        str = "F" + str;
                        break;
                }
            }
        }
        return str;

    }


    /**
     * 十六进制转10进制
     * @param num
     * @return
     */
    public static double hToD(String ... num){
        double sum = 0;
        for (int i = num.length - 1; i >= 0; i--) {
            switch (num[i]){
                case "A":
                    sum = sum + 10*Math.pow(16,num.length - 1 -i);
                    break;
                case "B":
                    sum = sum + 11*Math.pow(16,num.length - 1 -i);
                    break;
                case "C":
                    sum = sum + 12*Math.pow(16,num.length - 1 -i);
                    break;
                case "D":
                    sum = sum + 13*Math.pow(16,num.length - 1 -i);
                    break;
                case "E":
                    sum = sum + 14*Math.pow(16,num.length - 1 -i);
                    break;
                case "F":
                    sum = sum + 15*Math.pow(16,num.length - 1 -i);
                    break;
                default:
                    sum = sum + Integer.valueOf(num[i]) * Math.pow(16,num.length - 1 -i);
                    break;
            }
        }
        return sum;
    }


    /**
     * 二进制转十六进制
     * @param num
     * @return
     */
    public static String BtoH(int ... num){
        String sum = "";
        int tmp = 0;
        int count = 0;
        int len = num.length;
        for (int i = len - 1; i >= 0; i--) {
            tmp = tmp + num[i] * (int)Math.pow(2,len - 1 - i);
            if (++count == 4){
                if (tmp < 10){
                    sum = tmp + sum;
                }else {
                    switch (tmp){
                        case 10:
                            sum = "A" + sum;
                            break;
                        case 11:
                            sum = "B" + sum;
                            break;
                        case 12:
                            sum = "C" + sum;
                            break;
                        case 13:
                            sum = "D" + sum;
                            break;
                        case 14:
                            sum = "E" + sum;
                            break;
                        case 15:
                            sum = "F" + sum;
                            break;
                    }
                }
                len -= count;
                count = 0;
                tmp = 0;
            }
        }
        return tmp + sum;

    }


    /**
     * 十六进制转二进制
     * @param num
     * @return
     */
    public static String HtoB(String ... num){
        String sum = "";
        for (int i = num.length - 1; i >= 0; i--) {
            switch (num[i]){
                case "A":
                    int i1 = dToB(10);
                    String tmp = i1+"";
                    for (int j1 = 0; j1 < 4 - LengthNum(i1); j1++) {
                        tmp = 0 + tmp;
                    }
                    sum = tmp + sum;
                    break;
                case "B":
                    int i2 = dToB(11);
                    String tmp2 = i2+"";
                    for (int j1 = 0; j1 < 4 - LengthNum(i2); j1++) {
                        tmp2 = 0 + tmp2;
                    }
                    sum = tmp2 + sum;
                    break;
                case "C":
                    int i3 = dToB(12);
                    String tmp3 = i3+"";
                    for (int j1 = 0; j1 < 4 - LengthNum(i3); j1++) {
                        tmp3 = 0 + tmp3;
                    }
                    sum = tmp3 + sum;
                    break;
                case "D":
                    int i4 = dToB(13);
                    String tmp4 = i4+"";
                    for (int j1 = 0; j1 < 4 - LengthNum(i4); j1++) {
                        tmp4 = 0 + tmp4;
                    }
                    sum = tmp4 + sum;
                    break;
                case "E":
                    int i5 = dToB(14);
                    String tmp5 = i5+"";
                    for (int j1 = 0; j1 < 4 - LengthNum(i5); j1++) {
                        tmp5 = 0 + tmp5;
                    }
                    sum = tmp5 + sum;
                    break;
                case "F":
                    int i6 = dToB(15);
                    String tmp6 = i6+"";
                    for (int j1 = 0; j1 < 4 - LengthNum(i6); j1++) {
                        tmp6 = 0 + tmp6;
                    }
                    sum = tmp6 + sum;
                    break;
                default:
                    int i7 = dToB(Integer.valueOf(num[i]));
                    String tmp7 = i7+"";
                    for (int j1 = 0; j1 < 4 - LengthNum(i7); j1++) {
                        tmp7 = 0 + tmp7;
                    }
                    sum = tmp7 + sum;
                    break;
            }
        }
        return sum;
    }


    /**
     * 获取整数位数
     * @param num
     * @return
     */
    public static int LengthNum(int num) {
        int count=0; //计数
        while(num>=1) {
            num/=10;
            count++;
        }
        return count;
    }
}
