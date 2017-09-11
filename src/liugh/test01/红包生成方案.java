package liugh.test01;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import com.alibaba.fastjson.JSONObject;

public class 红包生成方案 {
	 /**
     * 计算每个红包的金额,并生成集合
     *
     * @param redPacketAmount
     * @param redPacketSize
     * @return
     */
    public static List<BigDecimal> getEachAmount(BigDecimal redPacketAmount, int redPacketSize) {
        List<BigDecimal> redPacketList = new LinkedList<BigDecimal>();
        //算平均值
        BigDecimal singleAmount = redPacketAmount.divide(new BigDecimal(redPacketSize),5,BigDecimal.ROUND_HALF_UP);
        //设置保底最小值
        BigDecimal min = new BigDecimal("0.01");
        //如果平均值等于0.01,所有红包为一分
        int compareTo = singleAmount.compareTo(min);
        if (compareTo == 0) {
            for (int i = 0; i < redPacketSize; i++) {
                redPacketList.add(min);
            }
            return  redPacketList;
            //如果平均值大于0.01,所有红包先保底0.01,总红包减去所有保底,然后再去分
        }else if(compareTo == 1){
            redPacketAmount = redPacketAmount.subtract(new BigDecimal(String.valueOf(redPacketSize)).multiply(min));
            //如果小于0.01，说明红包的钱和红包的数量输入不合法
        }else{
            throw new RuntimeException("最小红包不能少于0.01");
        }
        //如果红包数量为1或分到最后一个分到的就是剩下的所有钱加上保底0.01
        while (redPacketSize > 0) {
            if (redPacketSize == 1) {
                redPacketSize--;
                redPacketAmount = redPacketAmount.add(min).setScale(2, BigDecimal.ROUND_HALF_UP);
                redPacketList.add(redPacketAmount);
                return redPacketList;
            }
            Random random = new Random();
            //剩余红包钱求平均数乘以2，为最大值
            BigDecimal max = redPacketAmount.divide(new BigDecimal(redPacketSize), BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal("2"));
            //最大值乘以一个随机数，得到红包值
            BigDecimal money = new BigDecimal(String.valueOf(random.nextDouble())).multiply(max);
            //判断生成的红包是否保底
            int i = money.compareTo(min);
            if (i == -1 || i == 0) {
                money = min;
                redPacketList.add(money);
            //大于保底值 则加上保底 得到当前红包值
            }else {
                redPacketAmount = redPacketAmount.subtract(money);
                money = money.add(min).setScale(2,BigDecimal.ROUND_HALF_UP);
                redPacketList.add(money);
            }
            redPacketSize--;
        }
        return redPacketList;
    }


    public static void main(String[] args) {
        BigDecimal redPacketAmount = new BigDecimal(99.99);
        int redPacketSize = 10;
        List<BigDecimal> redPacketList = getEachAmount(redPacketAmount, redPacketSize);
        BigDecimal sum = BigDecimal.ZERO;
        for (BigDecimal bigDecimal : redPacketList) {
            sum = sum.add(bigDecimal);
        }
        System.out.println(JSONObject.toJSONString(redPacketList));
        System.out.println(sum);
        BigDecimal count=BigDecimal.ZERO;
        for(BigDecimal bigDecimal : redPacketList){
            count = count.add(bigDecimal);
        }
        System.out.println(count.toString());

    }
}
