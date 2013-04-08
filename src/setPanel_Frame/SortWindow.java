package setPanel_Frame;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import javax.swing.*;
import MySort.*;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

public class SortWindow extends JFrame {

    Data_Panel p = null;
    JFileChooser chooseFile = null;
    Integer[] number = null;
    BaseSort as = null;
    JLabel label = new JLabel("输入整数：");
    JLabel label2 = new JLabel("从文件读入整数：");
    JButton bStart = new JButton("                                                               开始排序                                                          ");
    JButton bSure = new JButton("确定");
    JButton fileInput = new JButton("            文件输入           ");
    JTextField textField = new JTextField("输入整数，整数之间以一个空格隔开", 26);
    JRadioButton[] r = {new JRadioButton("冒泡"), new JRadioButton("插入"), new JRadioButton("选择")};
    ButtonGroup bg = new ButtonGroup();
    JLabel[] labelCount = {new JLabel("比较次数："), new JLabel("交换次数："), new JLabel("探测次数：")};
    JTextField[] count = {new JTextField(null, 6), new JTextField(null, 6), new JTextField(null, 6)};

    public SortWindow(String s) {
        setTitle(s);
        setBounds(100, 100, 480, 580);
        setBackground(Color.yellow);
        p = new Data_Panel();
        p.setPreferredSize(new Dimension(450, 400));

        Container c = getContentPane();
        setLayout(new FlowLayout());
        c.add(label);
        c.add(textField);
        c.add(bSure);
        c.add(label2);
        c.add(fileInput);
        for (int i = 0; i < r.length; i++) {
            c.add(r[i]);
            bg.add(r[i]);
            r[i].setSelected(false);
        }

        for (int i = 0; i < count.length; i++) {
            c.add(labelCount[i]);
            c.add(count[i]);
        }

        c.add(new JScrollPane(p));
        c.add(bStart);

        fileInput.addActionListener(
                new ActionListener() {

                    public void actionPerformed(ActionEvent e) {
                        chooseFile = new JFileChooser();
                        chooseFile.showOpenDialog(null);
                        File fl = chooseFile.getSelectedFile();

                        try {
                            LineNumberReader br = new LineNumberReader(new FileReader(fl));
                            Integer x;
                            x = Integer.parseInt(br.readLine());
                            number = new Integer[x];
                            int i = 0;
                            while (i < x) {
                                int num = Integer.parseInt(br.readLine());
                                number[i] = num;
                                i++;
                            }
                            br.close();
                            choiceSort();

                        } catch (IOException e1) {
                            e1.printStackTrace();
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                });

        bSure.addActionListener(
                new ActionListener() {

                    public void actionPerformed(ActionEvent e) {


                        //用来判断用户是否输入整型数据
                        String boolString = textField.getText();
                        String str[] = (textField.getText()).split(" ");
                        number = new Integer[str.length];
                        for (int i = 0; i < str.length; i++) {
                            number[i] = Integer.parseInt(str[i]);
                        }

                        choiceSort();
                    }
                });

        bStart.addActionListener(
                new ActionListener() {

                    public void actionPerformed(ActionEvent e) {
                        as.sort();
                        p.setASort(as);
                        count[0].setText(""+as.getM().compare_count);
                        count[1].setText(""+as.getM().exchange_count);
                        count[2].setText(""+as.getM().probe_count);
                    }
                });

    }

    public void choiceSort() {
        if (r[0].isSelected()) {
            as = new BubbleSort(number);
        }

        if (r[1].isSelected()) {
            as = new InsertSort(number);
        }

        if (r[2].isSelected()) {
            as = new SelectSort(number);
        }
        p.setASort(as);
    }
}
