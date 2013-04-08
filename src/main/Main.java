/*
 * 这个一个排序类的可视化程序
 * 包括的功能有：
 * 1、可以手动输入待排序的整数
 * 2、可以从文件输入待排序的整数
 * 3、待排序的整数输入之后就会显示出来
 * 4、排好序之后，整数又可以显示 出来
 */
package main;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.*;
import setPanel_Frame.SortWindow;

public class Main {

    public static void main(String args[]) {

        SortWindow f = new SortWindow("吴建杰20102100035可视化排序程序");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //改变小图标
        Image icon = Toolkit.getDefaultToolkit().getImage("apple.png");
        f.setIconImage(icon);

        //窗口出现在屏幕的位置
        f.setLocation(400, 150);

        //窗口是可见的
        f.setVisible(true);

    }
}
