package Delete;

import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;       

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.JTableHeader;

public class Homedelete_tea extends JFrame implements ActionListener{
	
     JScrollPane scpDemo;
      JFrame  Add;
    JTableHeader jth;
    JTable tabDemo;   
    JTextField text,Addbh,Addname,Addxingbie,Addxl,Addzw,Addzc,Addschool,Addjc,Addzzxx,Addbmbh;
    JLabel 编号,姓名,性别,学历,职务,职称,毕业院校,奖惩,在职信息,部门编号;
    JButton anShow,anSet,anSelsct,Addyes,Addno;
    String SQLbh,SQLname,SQLxingbie,SQLxl,SQLzw,SQLzc,SQLschool,SQLjc,SQLzzxx,SQLbmbh;
    String a[]={SQLbh,SQLname,SQLxingbie,SQLxl,SQLzw,SQLzc,SQLschool,SQLjc,SQLzzxx,SQLbmbh};
 public Homedelete_tea(){  
       super("人事管理系统");
       this.setSize(400,500);
       this.setLayout(null);
       this.setLocation(400,100);
       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       this.setVisible(true);
       this.setResizable(false);//钉死
     	JLabel a= new JLabel (new ImageIcon("C:\\Users\\Administrator\\Desktop\\1.jpg"));
	a.setBounds(new Rectangle(0,0,1500,680));

       this.text=new JTextField();
       this.text.setBounds(10, 20,200, 25);
       this.anSelsct=new JButton("查询");
       this.anSelsct.setBounds(230,20,70,25);
       this.anShow=new JButton("刷新");
       this.anShow.setBounds(310,20,70,25);
    
       this.anSet=new JButton("删除");
       this.anSet.setBounds(100,435,70,25);
       
       this.scpDemo = new JScrollPane(); //滚动条
       this.scpDemo.setBounds(10,50,365,380);
    Addbh=new JTextField();
       Addname=new JTextField();
       Addxingbie=new JTextField();
       Addxl=new JTextField();
       Addzw=new JTextField();
       Addzc=new JTextField();
       Addschool=new JTextField();
       Addjc=new JTextField();
       Addzzxx=new JTextField();
       Addbmbh=new JTextField();
      
       编号=new JLabel(" 编号");
       姓名=new JLabel("姓名");
       性别=new JLabel("性别");               
       学历=new JLabel("学历");
       职务=new JLabel("职务");
       职称=new JLabel("职称");
       毕业院校=new JLabel("毕业院校");
       奖惩=new JLabel("奖惩");
      在职信息=new JLabel("在职信息");
      部门编号=new JLabel("部门编号");
     
     Addyes=new JButton("确定");
       Addno=new JButton("取消");
      //添加窗口的创建
         Add=new  JFrame();                    
       Add.setTitle("添加");
       Add.setSize(350,400);
       Add.setLocation(100, 260);
       Add.setLayout(new GridLayout(8,2));
      
       Add.add(编号);Add.add(Addbh);
       Add.add(姓名);Add.add(Addname);
       Add.add(性别);Add.add(Addxingbie);
       Add.add(学历);Add.add(Addxl);
       Add.add(职务);Add.add(Addzw);
       Add.add(职称);Add.add(Addzc);
       Add.add(毕业院校);Add.add(Addschool);
       Add.add(奖惩);Add.add(Addjc);
       Add.add(在职信息);Add.add(Addzzxx);
       Add.add(部门编号);Add.add(Addbmbh);
     
     
       Add.add(Addyes); Add.add(Addno);
          Addyes.addActionListener(this);
       Addno.addActionListener(this);
    
       anShow.addActionListener(this);
       anSet.addActionListener(this);
       anSelsct.addActionListener(this);
       
       this.scpDemo.getViewport().add(tabDemo); //给控件，滚动条、、 设置可见、、增加配件
        
        add(this.scpDemo);
        add(this.text);
        add(this.anSelsct);
        add(this.anShow);     
     
        add(this.anSet);
         this.remove(this);//刷新
        this.repaint();//重绘component的方法，component中已有的图形发生变化后不会立刻显示，须使用repaint方法
        
        try{
           // 获得连接
           Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433; DatabaseName=人事管理系统","sa","123456");
        // 建立查询条件
       String sql="select * from 转出教师";

         //从chapiao表中寻找相关信息
      
        PreparedStatement pstm = conn.prepareStatement(sql);
        // 执行查询
        ResultSet rs = pstm.executeQuery();
        // 计算有多少条记录
        int count = 0;
        while(rs.next()){
        count++;
        }
        rs = pstm.executeQuery();
        // 将查询获得的记录数据，转换成适合生成JTable的数据形式
        Object[][] info = new Object[count][10];
        count = 0;
        while(rs.next()){
            
        info[count][0] = rs.getString("编号");
        info[count][1] = rs.getString("姓名");
        info[count][2] = rs.getString("性别");
        info[count][3] = rs.getString("学历") ;
        info[count][4] = rs.getString("职务");
        info[count][5] = rs.getString("职称");
        info[count][6] = rs.getString("毕业院校");
        info[count][7] = rs.getString("奖惩");
        info[count][8] = rs.getString("在职信息");
        info[count][9] = rs.getString("部门编号");
      
        count++;
         }
        // 定义表头
        String[] title = {"编号","姓名","性别","学历","职务","职称","毕业院校","奖惩","在职信息","部门编号"};
        // 创建JTable
        this.tabDemo = new JTable(info,title);
        // 显示表头
        this.jth = this.tabDemo.getTableHeader();
        // 将JTable加入到带滚动条的面板中
        this.scpDemo.getViewport().add(tabDemo); 
        }catch(ClassNotFoundException cnfe){
        JOptionPane.showMessageDialog(null,"数据源错误","错误",JOptionPane.ERROR_MESSAGE);
        }catch(SQLException sqle){
        JOptionPane.showMessageDialog(null,"数据操作错误","错误",JOptionPane.ERROR_MESSAGE);
        }
         
   }
     deletetea_chaxun re=new deletetea_chaxun();
     int f=0;
   @Override
  public void actionPerformed(ActionEvent e) {
        
      if(e.getSource()==(anSelsct)){//查询
            f=1;
    //        System.out.println(f);
           String 编号=this.text.getText().trim();
           String sql="select * from 转出教师  where 编号='"+编号+"'";
           deletetea_chaxun aa=new deletetea_chaxun(sql);
            
           tabDemo.setModel(aa);
                        
       }
        if(e.getSource()==anShow){//刷新
        	deletetea_chaxun re=new deletetea_chaxun();
           tabDemo.setModel(re);
           f=0;
       }
     
       else if(e.getSource()==anSet&&f==0){//修改

           int j=this.tabDemo.getSelectedRow();
       //     System.out.println("wei");
           deletetea_chaxun re=new deletetea_chaxun();
            clear_tea a=new clear_tea(0);     
           re=new deletetea_chaxun();
           tabDemo.setModel(re);
       }
       else if(e.getSource()==anSet&&f==1)
       {
    	   int j=this.tabDemo.getSelectedRow();
     //      System.out.println("yi");
           String 编号=this.text.getText().trim();
           String sql="select * from 转出教师  where 编号='"+编号+"'";
           re=new deletetea_chaxun(sql);
           clear_tea a=new clear_tea(0);  
          tabDemo.setModel(re);
         
       }
   }
   
   }
   