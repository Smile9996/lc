package com.smile.lc;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.*;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@SpringBootTest
class LcApplicationTests {

    @Test
    void Tets(){
        String s = "keep";
        String s1= "brother";
        System.out.println(s.hashCode());
        System.out.println(s1.hashCode());
        Long i = -129L;
        Long j = -129L;

        System.out.println(s==s1);
        System.out.println(i.equals(j));
        Map<Integer, Integer> map = new ConcurrentHashMap<>();
        Map<Integer, Integer> map1= Collections.synchronizedMap(map);
        Map<Integer, Integer> map2 = new HashMap<>();
        System.out.println(map.toString());
        System.out.println(map1.toString());
        System.out.println(map2);
        System.out.println(map.equals(map1));
    }

    @Test
    void test11(){

        long t1 = System.currentTimeMillis();
        for( int i = 0; i < 10000000; i ++) {
            com.smile.lc.Test test = new com.smile.lc.Test();
        }
        System.out.println("用时:" + (System.currentTimeMillis() - t1) + "ms");
        try{
            Thread.sleep(10000000);
        }catch (Exception e){

        }
        int[] nums1 = new int[100];
        Arrays.fill(nums1, 1);
        int[] nums2 = new int[100];
        Arrays.fill(nums2, 100000);
        System.out.println(ters(nums1, nums2));
    }

    // 活跃分钟数
    int[] tests(int[][] logs, int k){
        int[] answer = new int[k];
        //  ID          活跃分钟    次数
        Map<Integer,Map<Integer, Integer>> mapMap = new HashMap<>();
        for (int[] subLog : logs) {
            if (!mapMap.containsKey(subLog[0])){
                Map<Integer, Integer> map = new HashMap<>();
                map.put(subLog[1], 1);
                mapMap.put(subLog[0], map);
            }else {
                Map<Integer, Integer> map = mapMap.get(subLog[0]);
                int key = subLog[1];
                if (!map.containsKey(key)){
                    map.put(key, 1);
                    mapMap.replace(subLog[0], map);
                }
            }
        }
        for (Integer id : mapMap.keySet()) {
            int result = 0;
            Map<Integer, Integer> map = mapMap.get(id);
            for (Integer minute : map.keySet()) {
                result += map.get(minute);
            }
            answer[result-1] += 1;
        }
        return answer;
    }

    int ters(int[] nums1, int[] nums2) {
        // 保留两个数组的每个列上的绝对值总和
        int result = 0;
        //找出差值绝对值
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i < nums1.length; i ++) {
            int abs = Math.abs(nums1[i] - nums2[i]);
            result = (int) ((result + abs) % (Math.pow(10, 9) +7));
            map.put(i, abs);
        }
        if (result == 0) {
            return 0;
        }
        Map<Integer, Integer> sortMapByValues = sortMapByValues(map);
        Map.Entry<Integer, Integer> next = sortMapByValues.entrySet().iterator().next();
        int maxSeat = next.getKey();
        int num1Max = nums1[maxSeat];
        int num2Max = nums2[maxSeat];
        // 保留两个数相减的绝对值
        int comRe1 = Math.abs(nums1[0] - num2Max);
        int comRe2 = Math.abs(nums2[0] - num1Max);
        if (num1Max > num2Max) {
            for (int i=0; i < nums1.length ; i ++) {
                if (nums1[i] >= num1Max || i == maxSeat) {
                    continue;
                }
                if (comRe1 > Math.abs(nums1[i] - num2Max)) {
                    comRe1 = Math.abs(nums1[i] - num2Max);
                }
            }
        }else {
            for (int i=0; i < nums2.length ; i ++) {
                if (nums2[i] >= num2Max || i == maxSeat) {
                    continue;
                }
                if (comRe2 > Math.abs(nums2[i] - num1Max)) {
                    comRe2 = Math.abs(nums2[i] - num1Max);
                }
            }
        }
        int comRe = Math.min(comRe1, comRe2);
        result = (int)((result - Math.abs(num1Max - num2Max) + comRe) % (Math.pow(10, 9) +7));
        return result ;
    }

    //根据value排序
    static <K extends Comparable, V extends Comparable> Map<K, V> sortMapByValues(Map<K, V> aMap) {
        HashMap<K, V> finalOut = new LinkedHashMap<>();
        aMap.entrySet()
                .stream()
                .sorted((p1, p2) -> p2.getValue().compareTo(p1.getValue()))
                .collect(Collectors.toList()).forEach(ele -> finalOut.put(ele.getKey(), ele.getValue()));
        return finalOut;
    }

    int test111() {
        int r = 0;
        int count = 0;
        int[] nums = new int[]{432835222,112141211,5408045,456281503,283322436,414281561,37773,286505682};
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i =0, k = n-1; i < k; i ++, k--) {

            for (int j = i + 1; j<= n-1 ; j ++) {
                count ++;
                StringBuffer str1 = new StringBuffer().append(nums[i]);
                StringBuffer str2 = new StringBuffer().append(nums[j]);
                if (nums[i] + Integer.parseInt(str2.reverse().toString()) == nums[j] + Integer.parseInt(str1.reverse().toString())) {
                    r++;
                }
            }
            for (int l = k-1; l >= 0; l--) {
                count ++;
                StringBuffer str3= new StringBuffer().append(nums[k]);
                StringBuffer str4= new StringBuffer().append(nums[l]);
                if (nums[k] + Integer.parseInt(str3.reverse().toString()) == nums[l] + Integer.parseInt(str4.reverse().toString())) {
                    r ++;
                }
            }
        }
        System.out.println(count);
        return (int) (r%(Math.pow(10,9) + 7));
    }

    boolean test() {
        String s1="My name is Haley";
        String s2="My is Haley";
        String[] ss1 = s1.split(" ");
        String[] ss2 = s2.split(" ");
        if (ss1.length > ss2.length){
            for (int i = 1; i <ss2.length-1; i ++) {

            }
        }

        if (ss1.length > ss2.length){
            if (ss2[0].equals(ss1[0]) && ss2[ss2.length -1].equals(ss1[ss1.length-1])) {
                for (int i = 1; i <ss2.length-1; i ++) {
                    if (ss2[i].equals(ss1[i]) && ss2[ss2.length - 1 - i].equals(ss1[ss1.length - 1 -2])) {
                        if (i == ss2.length -2) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }else if (ss1.length < ss2.length) {

        }else {
            if (s1.equals(s2)) {
                return true;
            }
            return false;
        }
        return false;
    }

    @Test
    void test1() throws InterruptedException {
        long l = Runtime.getRuntime().totalMemory() / 1024 / 1024;
        long l1 = Runtime.getRuntime().maxMemory() / 1024 / 1024;
        System.out.println(l + "M");
        System.out.println(l1 + "M");
        //Thread.sleep(1000000);
    }


    void contextLoads() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException, ClassNotFoundException {
        String test = "com.smile.lc.Test";
        Class<?> c = Class.forName(test);
        System.out.println(c.getName());
        Object o = c.newInstance();

        //获取所有构造方法
//        Constructor<?>[] declaredConstructors = name.getDeclaredConstructors();
//        for (Constructor<?> c : declaredConstructors) {
//            System.out.println(Modifier.toString(c.getModifiers()));
//            Class<?>[] parameterTypes = c.getParameterTypes();
//            for (int i = 0; i < parameterTypes.length; i ++) {
//                System.out.print(parameterTypes[i].getName() + "\t");
//            }
//        }
        //获取指定参数类型的构造方法
//        Class[] c = new Class[]{String.class, int.class};
//
//        Constructor<?> declaredConstructor = name.getDeclaredConstructor(c);
//        System.out.println(Modifier.toString(declaredConstructor.getModifiers()));
//        System.out.println(declaredConstructor.getName());
        Class[] p1 = {String.class, int.class};
        Constructor<?> declaredConstructor = c.getDeclaredConstructor(p1);
        declaredConstructor.setAccessible(true);
        declaredConstructor.newInstance("Dog", 20);

        System.out.println("------------------------------------------");
        Class[] p2 = {String.class};
        Method hello = c.getDeclaredMethod("Hello", p2);
        hello.setAccessible(true);
        Object[] args = {"kitty"};
        hello.invoke(o, args);

        System.out.println("*******************************************");
        Field name = c.getDeclaredField("name");
        name.setAccessible(true);
        name.set(o, "KAI");
        System.out.println(name.get(o));

    }


}
