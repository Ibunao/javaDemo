package bean;

import dao.Column;
import dao.Table;

@Table("user")  //添加类的注解，添加的值为将来要查询的表名
public class User {  
      
    @Column("id")  //添加字段的注解，添加的值为将来要查询的列名
    private int id;  
      
    @Column("user_name")  
    private String userName;  
      
    @Column("nick_name")  
    private String nickName;  
      
    @Column("age")  
    private int age;  
      
    @Column("city")  
    private String city;  
      
    @Column("email")  
    private String email;  
      
    @Column("mobile")  
    private String mobile;  
  
    public int getId() {  
        return id;  
    }  
    public void setId(int id) {  
        this.id = id;  
    }  
    public String getUserName() {  
        return userName;  
    }  
    public void setUserName(String userName) {  
        this.userName = userName;  
    }  
    public String getNickName() {  
        return nickName;  
    }  
    public void setNickName(String nickName) {  
        this.nickName = nickName;  
    }  
    public int getAge() {  
        return age;  
    }  
    public void setAge(int age) {  
        this.age = age;  
    }  
    public String getCity() {  
        return city;  
    }  
    public void setCity(String city) {  
        this.city = city;  
    }  
    public String getEmail() {  
        return email;  
    }  
    public void setEmail(String email) {  
        this.email = email;  
    }  
    public String getMobile() {  
        return mobile;  
    }  
    public void setMobile(String mobile) {  
        this.mobile = mobile;  
    }  
}  