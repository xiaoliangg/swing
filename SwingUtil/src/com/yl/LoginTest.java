package com.yl;

import java.awt.event.*; 

import javax.swing.*; 
 
public class LoginTest extends JFrame implements ActionListener 
{ 
  private JPanel jp = new JPanel(); 
  JLabel name = new JLabel("�������û���"); 
  JLabel password = new JLabel("����������"); 
  JLabel show = new JLabel(""); 
  private JLabel[] jl = new JLabel[]{name,password,show}; 
  JButton login = new JButton("��¼"); 
  JButton reset = new JButton("����"); 
  private JButton[] jb = new JButton[]{login,reset}; 
  private JTextField jname= new JTextField(); 
  private JPasswordField jpass = new JPasswordField(); 
  public LoginTest() 
  { 
    jp.setLayout(null); 
    for(int i=0;i<2;i++) 
    { 
      jl[i].setBounds(30,20+40*i,180,20); 
      jb[i].setBounds(30+110*i,100,80,20); 
      jb[i].addActionListener(this); 
      jp.add(jl[i]); 
      jp.add(jb[i]); 
    } 
    jname.setBounds(130,15,100,20); 
    jp.add(jname); 
    jname.addActionListener(this); 
    jpass.setBounds(130,60,100,20); 
    jp.add(jpass); 
    jpass.addActionListener(this); 
    jpass.setEchoChar('*'); 
    jl[2].setBounds(10,180,270,20); 
    jp.add(jl[2]); 
    this.add(jp); 
    this.setBounds(200,200,300,300); 
    this.setVisible(true); 
    this.setTitle("��¼����"); 
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
  } 
  public void actionPerformed(ActionEvent a) 
  { 
    if(a.getSource()==jname) 
    { 
      jpass.requestFocus(); 
    } 
    else if(a.getSource()==jb[1]) 
    { 
      jl[2].setText(""); 
      jname.setText(""); 
      jpass.setText(""); 
      jname.requestFocus(); 
    } 
    else  
    { 
      if(jname.getText().equals("1")&&String.valueOf(jpass.getPassword()).equals("1")) 
      { 
        jl[2].setText("��¼�ɹ�����ӭ���ĵ���!"); 
      } 
      else 
      { 
        jl[2].setText("�Բ�������������û�������"); 
      } 
    } 
  } 
  public static void main(String args[]) 
  { 
    new LoginTest(); 
  } 
} 