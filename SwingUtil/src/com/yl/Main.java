package com.yl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.regex.Pattern;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
 
public class Main extends JFrame implements ActionListener 
{ 
  private JPanel jp = new JPanel(); 
  JLabel b = new JLabel("b");  
  JLabel kbL = new JLabel("kb");
  JLabel mbL = new JLabel("mb");
  JLabel show = new JLabel(""); 
  JButton transForm = new JButton("ת��"); 
  JButton reset = new JButton("����"); 
  private JTextField jBytes= new JTextField(); 
  private JTextField jKb = new JTextField(); 
  private JTextField jMb = new JTextField(); 
  public Main() 
  {
    jp.setLayout(null); 
    b.setBounds(30,20+40*0,180,20);
    kbL.setBounds(30,20+40*1,180,20);
    mbL.setBounds(30,20+40*2,180,20);
    
    transForm.setBounds(30+110*0,130,80,20);      transForm.addActionListener(this); 
    reset.setBounds(30+110*1,130,80,20); reset.addActionListener(this);
    jp.add(b);jp.add(transForm);jp.add(kbL);jp.add(reset);jp.add(mbL);
    
    
    jBytes.setBounds(130,15,100,20); 
    jp.add(jBytes); 
    jBytes.addActionListener(this); 
    jKb.setBounds(130,60,100,20); 
    jKb.setEditable(false);
    jp.add(jKb); 
    jKb.addActionListener(this); 
    jMb.setBounds(130,105,100,20); 
    jMb.setEditable(false);
    jp.add(jMb); 
    jMb.addActionListener(this); 
//    jpass.setEchoChar('*'); 
    show.setBounds(10,180,270,20); 
    jp.add(show); 
    this.add(jp); 
    this.setBounds(100,100,300,300); 
    this.setAlwaysOnTop(true);
    this.setVisible(true); 
    this.setTitle("byteTransformer"); 
    ImageIcon icon=new ImageIcon("pen.ico");  //xxx����ͼƬ���·����2.pngͼƬ���Ƽ���ʽ  
    this.setIconImage(icon.getImage());  
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
  } 
  @Override
  public void actionPerformed(ActionEvent a) 
  {
    if(a.getSource()==jBytes) 
    { 
      jKb.requestFocus(); 
    } 
    else if(a.getSource()==reset) 
    { 
      show.setText(""); 
      jBytes.setText(""); 
      jKb.setText(""); 
      jMb.setText(""); 
      jBytes.requestFocus(); 
    } 
    else  
    { 
    	if(jBytes.getText() == null || "".equals(jBytes.getText())){
    		show.setText("ֻ֧���ֽ�ת�����ֽ���Ϊ��");
    		return;
    	}
//    	if((!isInteger(jBytes.getText()))){
//    		show.setText("�������");
//    		return;
//    	}
    	
    	String b = transNotationInt(jBytes.getText());
    	BigDecimal i = null ;
    	try{
    		i = new BigDecimal(b);
    	}catch (Exception e) {
    		show.setText("����������Ϣ��ʽ" + e);
    		return;
		}
    	String kbText = String.valueOf(i.doubleValue()/1024.0);
    	String mbText = String.valueOf(i.doubleValue()/1024.0/1024.0);
    	jKb.setText(transNotationDouble(kbText));
    	jMb.setText(transNotationDouble(mbText));
//      if(jname.getText().equals("1")&&String.valueOf(jpass.getPassword()).equals("1")) 
//      { 
//        jl[2].setText("��¼�ɹ�����ӭ���ĵ���!"); 
//      } 
//      else 
//      { 
//        jl[2].setText("�Բ�������������û�������"); 
//      } 
    } 
  } 
  
  //����ǿ�ѧ��������ת��Ϊ��ͨdouble
  private String transNotationDouble(String s) {
	  if(s.indexOf("E")>-1){
		  Double num = Double.parseDouble(s);
		  String result = new DecimalFormat("0.000").format(num);
		  return result;
	  }else{
		  Double num = Double.parseDouble(s);
		  String result = new DecimalFormat("0.000").format(num);
		  return result;
	  }
}
  
  private String transNotationInt(String s){
	  BigDecimal bd = new BigDecimal(s);  
	  return bd.toPlainString();
  }
  
  /*���������Ƽ����ٶ����
   * �ж��Ƿ�Ϊ���� 
   * @param str ������ַ��� 
   * @return ����������true,���򷵻�false 
 */

   public static boolean isInteger(String str) { 
         Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");  
         return pattern.matcher(str).matches();  
   }
public static void main(String args[]) 
  { 
    new Main(); 
  } 
} 