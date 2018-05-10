package com.f.test.quote;

/**
 * Created by F on 2016/11/30 11:14.
 */
public class QuoteTest {

    private static void setDouble(Double d) {
        d = 1.0;
    }

    private static void setString(String s) {
        s = "abc";
    }

    private static void setStringBuffer(StringBuffer s) {
        s.append(4);
    }

    private static void setUser(User user){
        user.setAge(100);
        user.setUserName("tom");
    }

    public static void main(String[] args) {
        Double d = 0d;
        setDouble(d);
        System.out.println(d);

        String s = "a.properties";
        setString(s);
        System.out.println(s);

        StringBuffer sb;
        sb = new StringBuffer("1");
        sb.append(2);
        setStringBuffer(sb);
        System.out.println(sb);

        User user = new User();
        user.setUserName("A");
        user.setAge(1);
        setUser(user);
        System.out.println(user.getUserName()+user.getAge());
    }
}





