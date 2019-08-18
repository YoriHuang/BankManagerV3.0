package com.jxau.bank.manager;

/**
 * 业务层实现
 * @version 1.9 2019-7-19
 * @author 黄游迎
 */

import com.jxau.bank.dao.IMySQLDao;
import com.jxau.bank.entity.LogBean;
import com.jxau.bank.entity.UserBean;
import com.jxau.bank.exception.login.*;
import com.jxau.bank.exception.register.UserExistException;
import com.jxau.bank.exception.transfer.ToUserNotExistException;
import com.jxau.bank.exception.withdraws.BalanceNotEnoughException;
import com.jxau.bank.factory.UserDaoFactory;
import com.jxau.bank.util.MD5;

import java.util.List;

public class ManagerImpl implements IManager{

	private static ManagerImpl instance;
	private double money;
	private IMySQLDao MySQLDao;
	private MD5 md5 = new MD5();
	private UserBean userbean;
    private List<LogBean> logs;
    private List<UserBean> users;
/*
	public ManagerImpl(){
        try {
            MySQLDao = UserDaoFactory.getInstance("mysqldaoimpl", IMySQLDao.class);
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
	}
*/

	private ManagerImpl(){
		try {
			MySQLDao = UserDaoFactory.getInstance("mysqldaoimpl", IMySQLDao.class);
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
	}
	public static synchronized ManagerImpl getInstance(){
		if(instance == null){
			instance = new ManagerImpl();
		}
		return instance;
	}

	@Override
	/**
	 * 登录功能实现
	 * @param loginame 登录用户名
	 * @param password 密码
	 */
	public UserBean login(String loginName, String pwd){
            String password = md5.encode(pwd.getBytes());
			userbean = MySQLDao.login(loginName);
			if(userbean == null){
				throw new UserNotExistException();
			}else if(!password.equals(userbean.getPassword())){
				throw new PasswordErrorException();
			}
            return userbean;

	}
	
	@Override
	/**
	 * 注册功能实现
	 * @param username 注册用户名
	 * @param password 密码
	 */
	public boolean register(UserBean userbean){
		boolean flag = false;
		String username = userbean.getUsername();
		UserBean user = MySQLDao.selectUserByName(username);
		if(user != null){
			throw new UserExistException();
		}
		boolean regsFlag = MySQLDao.register(userbean);
		flag = regsFlag;

		return flag;
		
	}
	
	//查询余额功能实现
	@Override
	public double inquiry(int userid){
	    return MySQLDao.getBalance(userid);
	}

	@Override
	/**
	 * 存款功能实现
	 * @param m 存款金额
     * @param userid 当前登录用户id
	 */
	public boolean deposit(String m, int userid){
		boolean flag = false;

		money = Double.parseDouble(m);  //存款金额
		flag = MySQLDao.deposit(money, userid);
		if(flag) {
			MySQLDao.addrecord("存入", money, userid);
		}
		return flag;
	}

	@Override
	/**
	 * 取款功能实现
	 * @param m 取款金额
     * @param userid 当前登录用户id
	 */
	public boolean withdrawals(String m, int userid){
		boolean flag = false;
		money = Double.parseDouble(m);  //取款金额
		double balance = MySQLDao.getBalance(userid);
		if(balance < money){
			throw new BalanceNotEnoughException();
		}

		flag = MySQLDao.withdraws(money, userid);
		if(flag) {
			MySQLDao.addrecord("取出", money, userid);
		}

		return flag;
	}
	
	@Override
	/**
	 * 转账功能实现
	 * @param m 转账金额
	 * @param toUserId 转入账户
     * @param selfId 自身账户
	 */
	public boolean transfer(String m, int toUserId, int selfId){
		boolean flag = false;
		money = Double.parseDouble(m);  //转账金额
		double balance = MySQLDao.getBalance(selfId);  //自身账户余额
		UserBean userbean = selectUserById(toUserId);
		if(userbean == null){
			throw new ToUserNotExistException();
		}
		if(balance < money){
			throw new BalanceNotEnoughException();
		}

		flag = MySQLDao.transfer(money, toUserId, selfId);
		if(flag){
			MySQLDao.addrecord("转出", money, selfId);
			MySQLDao.addrecord("转入", money, toUserId);
		}
		return flag;
	}

	public UserBean selectUserById(int userid){
            userbean = MySQLDao.selectUserById(userid);

	    return userbean;
    }

    public List<LogBean> selectLogByUserId(int userid){
         logs = MySQLDao.selectLogByUserId(userid);
        return logs;
    }

    public List<UserBean> selectAllUsers(){
	    users = MySQLDao.selectAllUsers();
	    return users;
    }

    public boolean freeze(int userId){

		return MySQLDao.freeze(userId);
    }

    public boolean thaw(int userId){
	   return MySQLDao.thaw(userId);

    }

}