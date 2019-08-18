package com.jxau.bank.dao;

/**
 * 持久层实现，通过工厂模式创建本类对象
 * @version 1.9 2019-7-19
 * @author 黄游迎
 */
import com.jxau.bank.entity.LogBean;
import com.jxau.bank.entity.UserBean;
import com.jxau.bank.util.*;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class MySQLDaoImpl implements IMySQLDao {
    private String sql = null;
    double balance;
    private MD5 md5 = new MD5();
    private DBUtil db = new DBUtil();
    private Connection conn;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    /**
     * 从数据库根据用户id获取账户余额
     * @param userid 用户id
     * @return balance 账户余额
     * */
    public double getBalance(int userid) {
        sql = "select balance from t_user where user_id=?";
        try{
            conn = db.getConn();
            ps = conn.prepareStatement(sql);
            ps.setInt(1,userid);
            rs= ps.executeQuery();
            if(rs.next()){
                balance = rs.getDouble("balance");
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally {
            DBUtil.close(conn, ps, rs);
        }
        return balance;
    }

     /**
     * @Override
     * 登录,根据输入的登录名和密码去查找信息，若查无结果，则返回的UserBean对象是null
     * @param loginame
     * @return user 查找结果
     */
    public UserBean login(String loginame) {
        UserBean user = null;
        sql = "select * from t_user where user_name=?";
        try {
            conn = db.getConn();
            ps = conn.prepareStatement(sql);
            ps.setString(1, loginame);
            rs = ps.executeQuery();
            if(rs.next()){
                user = new UserBean();
                user.setUserid(rs.getInt("user_id"));
                user.setUsername(loginame);
                user.setPassword(rs.getString("user_password"));
                user.setFlag(rs.getInt("user_flag"));
                user.setBalance(rs.getDouble("balance"));
                user.setRegistime(rs.getString("registime"));
                user.setAdmin(rs.getInt("admin"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            DBUtil.close(conn, ps, rs);
        }
        return user;
    }
    /**
     * @Override
     * 注册
     * @param ub 封装了注册信息的UserBean
     * */
    public boolean register(UserBean ub){
        String username = ub.getUsername();
        String password = md5.encode(ub.getPassword().getBytes());

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long currentTimeMillis = System.currentTimeMillis();
        Date currentTimeDate = new Date(currentTimeMillis);
        String currentTime = sdf.format(currentTimeDate);
        sql = "insert into t_user (user_name,user_password,balance,user_flag,registime) " +
                "value ('" + username + "','" + password + "','" + balance + "','" + 1 + "','" + currentTime + "')";

        try{
            conn = db.getConn();
            ps = conn.prepareStatement(sql);
            int flag = ps.executeUpdate(sql);
            if(flag == 1){
                return true;
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            DBUtil.close(conn, ps, rs);
        }
        return false;
    }

    /**
     * 存款功能实现
     * @param money 存款金额
     * @param id 用户id
     * */
    public boolean deposit(double money, int id){
        double balance = getBalance(id);
        sql = "update t_user set balance=? where user_id=?";
        try{
            conn = db.getConn();
            ps = conn.prepareStatement(sql);
            ps.setDouble(1,balance + money);
            ps.setInt(2, id);
            int flag = ps.executeUpdate();
            if(flag == 1){
                return true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtil.close(conn, ps, rs);
        }
        return false;
    }

    /**
     * 取款功能实现
     * @param money 取款金额
     * @param id 用户id
     * */
    public boolean withdraws(double money, int id){
        double balance = getBalance(id);
        sql = "update t_user set balance=? where user_id=?";
        try{
            conn = db.getConn();
            ps = conn.prepareStatement(sql);
            ps.setDouble(1,balance - money);
            ps.setInt(2, id);
            int flag = ps.executeUpdate();
            if(flag == 1){
                return true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtil.close(conn, ps, rs);
        }
        return false;
    }

    /**
     * @Override
     * 根据用户名查找用户信息
     * @param username 用户名
     */
    public UserBean selectUserByName(String username) {
        UserBean user = null;
        sql = "select * from t_user where user_name=?";
        try {
            conn = db.getConn();
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            rs = ps.executeQuery();
            if(rs.next()){
                user = new UserBean();
                user.setUserid(rs.getInt("user_id"));
                user.setUsername(rs.getString("user_name"));
                user.setPassword(rs.getString("user_password"));
                user.setFlag(rs.getInt("user_flag"));
                user.setBalance(rs.getDouble("balance"));
                user.setRegistime(rs.getString("registime"));
                user.setAdmin(rs.getInt("admin"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            DBUtil.close(conn, ps, rs);
        }
        return user;
    }

    /**
     *@Override
     * 转账
     * @param money 转账金额
     * @param toUserId 转入账户id
     * @param selfId 自身账户id
     */
    public boolean transfer(double money, int toUserId, int selfId) {

        if(deposit(money, toUserId) && withdraws(money, selfId)){
            return true;
        }
        return false;
    }

    /**
     * 根据用户id查找用户的其他信息
     * @param userid 需要查找的用户id
     * */
    public UserBean selectUserById(int userid){
        UserBean user = null;
        sql = "select * from t_user where user_id=?";
        try{
            conn = db.getConn();
            ps = conn.prepareStatement(sql);
            ps.setInt(1,userid);
            rs = ps.executeQuery();
            if(rs.next()){
                user = new UserBean();
                user.setUserid(userid);
                user.setUsername(rs.getString("user_name"));
                user.setPassword(rs.getString("user_password"));
                user.setFlag(rs.getInt("user_flag"));
                user.setBalance(rs.getDouble("balance"));
                user.setRegistime(rs.getString("registime"));
                user.setAdmin(rs.getInt("admin"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            DBUtil.close(conn, ps, rs);
        }
        return user;
    }

    /**
     * 向t_log表中插入用户的操作记录信息
     * @param type 操作类型
     * @param money 金额
     * @param id 当前登录用户的id
     * */
    public boolean addrecord(String type, double money, int id){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long currentTimeMillis = System.currentTimeMillis();
        Date currentTimeDate = new Date(currentTimeMillis);
        String currentTime = sdf.format(currentTimeDate);
        balance = getBalance(id);
        sql = "insert into t_log (log_type,log_amount,userid,time,user_balance) values (?,?,?,?,?)";
        try{
            conn = db.getConn();
            ps = conn.prepareStatement(sql);
            ps.setString(1,type);
            ps.setDouble(2,money);
            ps.setInt(3,id);
            ps.setString(4,currentTime);
            ps.setDouble(5,balance);
            int flag = ps.executeUpdate();
            if(flag == 1){
                return true;
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            DBUtil.close(conn, ps, rs);
        }
        return false;
    }

    /**
     * 根据登录用户的id查找该用户在t_log中的操作记录
     * @param userid 当前登录用户的id
     * @return List<LogBean>
     * */
    public List<LogBean> selectLogByUserId(int userid){
        List<LogBean> logs=new ArrayList<LogBean>();
        sql = "select * from t_log where userid=?";
        try{
            conn = db.getConn();
            ps = conn.prepareStatement(sql);
            ps.setInt(1,userid);
            rs = ps.executeQuery();
            while(rs.next()){
                LogBean log = new LogBean();
                log.setLog_id(rs.getInt("log_id"));
                log.setLog_type(rs.getString("log_type"));
                log.setMoney(rs.getDouble("log_amount"));
                log.setUserid(rs.getInt("userid"));
                log.setTime(rs.getString("time"));
                log.setUser_balance(rs.getDouble("user_balance"));
                logs.add(log);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            DBUtil.close(conn, ps, rs);
        }
        return logs;
    }

    /**
     * 在t_user表中查找所有的用户信息
     * @return List<UserBean>
     * */
    public List<UserBean> selectAllUsers(){
        List<UserBean> users = new ArrayList<UserBean>();
        sql = "select * from t_user where admin=0";
        try{
            conn = db.getConn();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                UserBean user = new UserBean();
                user.setUserid(rs.getInt("user_id"));
                user.setUsername(rs.getString("user_name"));
                user.setPassword(rs.getString("user_password"));
                user.setFlag(rs.getInt("user_flag"));
                user.setBalance(rs.getDouble("balance"));
                user.setRegistime(rs.getString("registime"));
                user.setAdmin(rs.getInt("admin"));
                users.add(user);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            DBUtil.close(conn, ps, rs);
        }
        return users;
    }

    /**
     * 根据登录用户的id查找冻结该用户
     * @param userid 用户id
     * */
    public boolean freeze(int userid){
        sql = "update t_user set user_flag=? where user_id=? ";
        try{
            conn = db.getConn();
            ps = conn.prepareStatement(sql);
            ps.setInt(1,0);
            ps.setInt(2,userid);
            int flag = ps.executeUpdate();
            if(flag == 1){
                return true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtil.close(conn, ps, rs);
        }
        return false;
    }

    /**
     * 根据登录用户的id解冻账户
     * @param userid 用户id
     * */
    public boolean thaw(int userid){
        sql = "update t_user set user_flag=? where user_id=? ";
        try{
            conn = db.getConn();
            ps = conn.prepareStatement(sql);
            ps.setInt(1,1);
            ps.setInt(2,userid);
            int flag = ps.executeUpdate();
            if(flag == 1){
                return true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtil.close(conn, ps, rs);
        }
        return false;
    }
}
