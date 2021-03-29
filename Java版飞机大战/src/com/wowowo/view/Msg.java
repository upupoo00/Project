package com.wowowo.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Msg extends JFrame  {


    public BaseFrame mainFrame;

    public JLabel msgLabel;

    public JButton confirmButtom;

    public JButton cancelButton;

    public Msg(BaseFrame mainFrame)
    {
    	
    	this.mainFrame=mainFrame;

        this.setTitle("��Ϸ����");
        this.confirmButtom=new JButton("������Ϸ");
        this.cancelButton=new JButton("�˳�");
        this.msgLabel=new JLabel("Game Over����");


        setLayout(new GridLayout(2, 1));
        JPanel jp1 = new JPanel();
        jp1.add(msgLabel);
        this.add(jp1);

        JPanel jp2 = new JPanel();
        jp2.add(confirmButtom);
        jp2.add(cancelButton);
        this.add(jp2);

        this.setSize(300,200);
        this.setVisible(true);

        this.setLocationRelativeTo(mainFrame);

        confirmButtom.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            	//�ر�ԭ��Ϸ����
               Msg.this.mainFrame.dispose();
              
               Msg.this.dispose();
               
               Msg.this.setVisible(false);
               
               //�¿���Ϸ����
               
               new GameFrame();
               
             
            }
        });


        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                System.exit(0);
            }
        });

    }



}
