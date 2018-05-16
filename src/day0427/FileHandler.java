package day0427;


import com.sun.deploy.util.StringUtils;
import sun.swing.StringUIClientPropertyKey;

import java.io.*;
import java.util.*;

/**
 * 文件内容处理
 *
 * @author chen ming hui
 * @version V1.0
 * @date 2018/5/4 17:00
 * @modificationHistory Who           When                 What
 * ------------------   ------     ------------      ------------------
 */
public class FileHandler {
    static HashMap<String, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        top5("C:\\Users\\Administrator\\Downloads\\mobiles_15.txt", "C:\\Users\\Administrator\\Downloads\\mobiles_16.txt");
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\Administrator\\Downloads\\jstop5.txt");
        for (Map.Entry<String, Integer> entry : entries) {
            String mobile = entry.getKey();
            if (entry.getValue() >= 5) {
                String str = "mobile:" + mobile + ",times:" + entry.getValue();
                str += "\r\n";
                fileOutputStream.write(str.getBytes());
            }
            if (entry.getValue() == 156) {
                System.out.println("max mobile:" + mobile + ",times:" + entry.getValue());
            }
        }
        fileOutputStream.flush();
        fileOutputStream.close();
        Integer max = Collections.max(map.values());
        System.out.println(max);
        System.out.println(map.size());
    }

    static void top5(String filePath, String filePath2) throws IOException {
        //BufferedReader是可以按行读取文件
        FileInputStream inputStream = new FileInputStream(filePath);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        printA(bufferedReader);
        inputStream.close();
        System.out.println("-----111-----" + map.size());
        inputStream = new FileInputStream(filePath2);
        bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        printA(bufferedReader);
        System.out.println("-----222-----" + map.size());
        inputStream.close();
    }

    private static void printA(BufferedReader bufferedReader) throws IOException {
        String str = null;
        while ((str = bufferedReader.readLine()) != null) {
            str = str.replace("[", "").replace("]", "");
            List<String> mobiles = Arrays.asList(str.split(","));
            for (String mobile : mobiles) {
                mobile = mobile.trim();
                if (mobile.equals("")) {
                    continue;
                }
                String carrier = PhoneUtil.getCarrier(mobile, "86");
                if (carrier.contains("江苏")) {
                    if (map.containsKey(mobile)) {
                        Integer integer = map.get(mobile);
                        integer += 1;
                        map.put(mobile, integer);
                    } else {
                        map.put(mobile, 1);
                    }
                }
            }
        }
    }


    void bb() throws IOException {
        //BufferedReader是可以按行读取文件
        FileInputStream inputStream = new FileInputStream("C:\\Users\\Administrator\\Downloads\\js.txt");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        HashSet<String> set = new HashSet<String>();
        String str = null;
        while ((str = bufferedReader.readLine()) != null) {
            str = str.replace("[", "").replace("]", "").trim();
            List<String> mobiles = Arrays.asList(str.split(","));
            set.addAll(mobiles);
        }
        System.out.println(set.size());
        Iterator<String> iterator = set.iterator();
        FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\Administrator\\Downloads\\js2.txt");
        while (iterator.hasNext()) {
            String next = iterator.next();
            if (next == null || next.length() == 0) {
                continue;
            }
            next += "\r\n";
            fileOutputStream.write(next.getBytes());
        }
        fileOutputStream.flush();
        fileOutputStream.close();
        //close
        inputStream.close();
    }

    static void aa() throws IOException {
        //BufferedReader是可以按行读取文件
        FileInputStream inputStream = new FileInputStream("C:\\Users\\Administrator\\Downloads\\mobiles_15.txt");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        HashSet<String> set = new HashSet<String>();
        String str = null;
        while ((str = bufferedReader.readLine()) != null) {
            str = str.replace("[", "").replace("]", "");
            List<String> mobiles = Arrays.asList(str.split(","));
            for (String mobile : mobiles) {
                mobile = mobile.trim();
                if (mobile.equals("")) {
                    continue;
                }
                set.add(mobile);
            }
        }

        inputStream = new FileInputStream("C:\\Users\\Administrator\\Downloads\\mobiles_16.txt");
        bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        while ((str = bufferedReader.readLine()) != null) {
            str = str.replace("[", "").replace("]", "");
            List<String> mobiles = Arrays.asList(str.split(","));
            for (String mobile : mobiles) {
                mobile = mobile.trim();
                if (mobile.equals("")) {
                    continue;
                }
                set.add(mobile);
            }
        }
        set.addAll(set);
        System.out.println(set.size());
        ArrayList<String> js = new ArrayList<>();
        Iterator<String> iterator = set.iterator();
        FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\Administrator\\Downloads\\js.txt");
        while (iterator.hasNext()) {
            String next = iterator.next();
            if (next == null || next.length() == 0) {
                continue;
            }
            String carrier = PhoneUtil.getCarrier(next.trim(), "86");
            if (carrier.contains("江苏")) {
                js.add(next);
                next += "\r\n";
                fileOutputStream.write(next.getBytes());
            }
        }
        fileOutputStream.flush();
        fileOutputStream.close();
        System.out.println(js.size());
        //close
        inputStream.close();
    }

    private static void fetionSms() throws IOException {
        File file = new File("X:\\doc\\b飞信\\11111");
        File[] files = file.listFiles();
        if (Objects.isNull(files)) {
            return;
        }
        for (File file1 : files) {
            if (file1.isDirectory()) {
                ArrayList<Integer> integers = new ArrayList<>();
                File[] files1 = file1.listFiles();
                if (Objects.isNull(files1)) {
                    return;
                }
                for (File file2 : files1) {
                    integers.add(result(file2));
                }
                int result = 0;
                for (Integer num : integers) {
                    result += num;
                }
                System.out.println(file1.getName() + "==" + result);
            }
        }
    }

    private static int result(File path) throws IOException {
        FileInputStream inputStream = new FileInputStream(path);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        int result = 0;
        String str = null;
        while ((str = bufferedReader.readLine()) != null) {
            result = Integer.parseInt(str);
            //System.out.println(path.getName()+"-"+str);
        }
        //close
        inputStream.close();
        return result;
    }
}
