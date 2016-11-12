package test.com.yuan;

import sun.java2d.cmm.CMSManager;

import java.util.Date;
import java.util.Scanner;

/**
 * Created by Administrator on 2016/11/12.
 */
public class Hello {

    private int i;
    static int temp;
    public String string;

    public int getI() {
        return i;
    }
/**
 * @Author:Yuan XiaoLei
 * @Date:2016/11/12
 * @Time:19:36
 */
    public void setI(int i) {
        this.i = i;
    }

    public static int getTemp() {
        return temp;
    }

    public static void setTemp(int temp) {
        Hello.temp = temp;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public static void main(String[] args)
    {

    }
}
