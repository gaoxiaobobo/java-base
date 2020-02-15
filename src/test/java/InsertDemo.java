import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by VULCAN on 2018/8/29.
 */
public class InsertDemo {

    private static String user = "root";
    //    private static String pass = "root1234%";
    private static String pass = "123456";
    //    private static String URL = "jdbc:mysql://127.0.0.1:3306/demo?characterEncoding=utf8&useSSL=true";
    private static String URL = "jdbc:mysql://127.0.0.1:3306/demo?useSSL=false";
    private static String SQL_PATH = "product_info.sql";
    private static String DROP_SQL = "DROP TABLE IF EXISTS `product_info`";
    private static String CREATE_SQL = " CREATE TABLE `product_info` (" +
            "  `id` int(11) NOT NULL," +
            "  `product_name` varchar(150) NOT NULL DEFAULT ''," +
            "  `desc` varchar(255) DEFAULT NULL," +
            "  `age` int(11) DEFAULT NULL," +
            "  KEY `product_name` (`age`,`product_name`) USING BTREE" +
            ") ENGINE=InnoDB DEFAULT CHARSET=utf8";

    @Before
    public void before() throws Exception {
        System.out.println("before");
        Connection conn = DriverManager.getConnection(URL, user, pass);

        try {
            Statement ps = conn.createStatement();
            ps.addBatch(DROP_SQL);
            ps.addBatch(CREATE_SQL);
            ps.executeBatch();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        conn.close();
    }

    /**
     * 正则表达式匹配两个指定字符串中间的内容
     *
     * @param soap
     * @return
     */
    public static List<String> getSubUtil(String soap, String rgex) {
        List<String> list = new ArrayList<String>();
        Pattern pattern = Pattern.compile(rgex);// 匹配的模式
        Matcher m = pattern.matcher(soap);
        while (m.find()) {
            int i = 1;
            list.add(m.group(i));
            i++;
        }
        return list;
    }

    @Test
    public void testReadList() {
        List<String> items = new ArrayList<>();

        items.add("coins");
        items.add("pens");
        items.add("keys");
        items.add("sheets");

        items.forEach(name -> {
            System.out.println(name);
        });
    }

    @Test
    public void testReadSql() throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(SQL_PATH));
        br.lines().forEach(sql -> {
            System.out.println(sql);
        });
        br.close();
        String str = "INSERT INTO `product_info` VALUES ('1', '苍井空娃娃', '送电池', '15')";
//        String str = "abc3443abcfgjhgabcgfjabc";
        String rgex = "'(.*?)'";//取参数
        System.out.println(getSubUtil(str, rgex));


    }

    @Test
    public void testMol() {
        System.out.println(0 % 2);
        System.out.println(1 % 2);
        System.out.println(2 % 2);

    }

    @Test
    public void test1() throws Exception {
        long startTime = System.currentTimeMillis();   //获取开始时间
        BufferedReader br = new BufferedReader(new FileReader("product_info.sql"));
        Connection conn = DriverManager.getConnection(URL, user, pass);

        LocalDateTime now = LocalDateTime.now();
        /******/
        System.out.println(now);
        br.lines().forEach(sql -> {
            try {
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.executeUpdate();
                ps.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        br.close();
        conn.close();

        LocalDateTime now2 = LocalDateTime.now();
        System.out.println(now2);

        long endTime = System.currentTimeMillis(); //获取结束时间
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() +
                "程序运行时间： " + (endTime - startTime) + "ms");
    }

    int i = 0;

    @Test
    public void test2() throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(SQL_PATH));
        Connection conn = DriverManager.getConnection(URL, user, pass);

        long startTime = System.currentTimeMillis();   //获取开始时间
        conn.setAutoCommit(false);
        String tmpSql = "INSERT INTO `product_info` VALUES (?, ?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(tmpSql);
        String rgex = "'(.*?)'";//取''之间的参数
        br.lines().forEach(sql -> {
            try {
//                PreparedStatement ps = conn.prepareStatement(sql);
                List<String> subUtil = getSubUtil(sql, rgex);
                ps.setInt(1, Integer.parseInt(subUtil.get(0)));
                ps.setString(2, subUtil.get(1));
                ps.setString(3, subUtil.get(2));
                ps.setInt(4, Integer.parseInt(subUtil.get(3)));
                ps.addBatch();
                if (i == 0 || (i % 3 != 0 && i <= 2097152)) {//2000
                    i++;
                } else {
                    ps.executeBatch();
                    conn.commit();
                    i = 0;
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        br.close();
        conn.close();

        LocalDateTime now2 = LocalDateTime.now();
        System.out.println(now2);
        long endTime = System.currentTimeMillis(); //获取结束时间
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() +
                "程序运行时间： " + (endTime - startTime) + "ms");

    }


    String str = "INSERT INTO `product_info` VALUES ";

    @Test
    public void test3() throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("product_info.sql"));
        Connection conn = DriverManager.getConnection(URL, user, pass);

        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        conn.setAutoCommit(false);

        br.lines().forEach(sql -> {
            try {
                str = str + sql.split("VALUES")[1].replace(";", ",");

                if ((i % 2000) != 0 && i <= 2097152) {
                    i++;
                } else {
                    i++;
                    str = str.substring(0, str.length() - 1);
                    // System.out.println(str);
                    PreparedStatement ps = conn.prepareStatement(str);
                    ps.executeUpdate();
                    str = "INSERT INTO `product_info` VALUES ";
                    conn.commit();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        br.close();
        conn.close();

        LocalDateTime now2 = LocalDateTime.now();
        System.out.println(now2);


//        2018-08-29T22:46:50.861
//        2018-08-29T22:48:30.347

//        2018-08-30T09:54:47.041
//        2018-08-30T09:56:21.848


    }
}