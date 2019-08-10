import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Student {

    //instance variables
    private int id;
    private String name;
    private String nic;
    private int sub1;
    private int sub2;
    private int sub3;
    private int total;
    private double average;

    //default Constructor
    public Student(){}

    //getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getNic() {
        return nic;
    }

    public int getSub1() {
        return sub1;
    }

    public int getSub2() {
        return sub2;
    }

    public int getSub3() {
        return sub3;
    }

    public int getTotal() {
        return total;
    }

    public double getAverage() {
        return average;
    }

    //setters
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public void setSub1(int sub1) {
        this.sub1 = sub1;
    }

    public void setSub2(int sub2) {
        this.sub2 = sub2;
    }

    public void setSub3(int sub3) {
        this.sub3 = sub3;
    }

    public void setTotal() {
        this.total = this.sub1+this.sub2+this.sub3;
    }

    public void setAverage() {
        this.average = this.total/3;
    }

    //get by id
    public void selectId(int id){
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try{
            connection = ConnectionConfig.getConnection();
            ps = connection.prepareStatement("SELECT * FROM results WHERE StudentID = ?");
            ps.setInt(1,id);
            rs = ps.executeQuery();

            while (rs.next()) {
                this.setId(rs.getInt("StudentID"));
                this.setName(rs.getString("Name"));
                this.setNic(rs.getString("NIC"));
                this.setSub1(rs.getInt("Subject1"));
                this.setSub2(rs.getInt("Subject2"));
                this.setSub3(rs.getInt("Subject3"));

                this.setTotal();
                this.setAverage();
            }

        }catch(Exception e){
            e.printStackTrace();
        }finally {
            if(rs != null){
                try{
                    rs.close();
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
            if (ps != null) {
                try{
                    ps.close();
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try{
                    connection.close();
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }
    }//get by id

}//class Student
