package com.bjsxt.service.impl;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

import com.bjsxt.pojo.Account;
import com.bjsxt.pojo.Log;
import com.bjsxt.service.AccountService;

public class AccountServicetImpl implements AccountService {
	public static Logger logger= Logger.getLogger(AccountServicetImpl.class);
	@Override
	public int transfer(Account accOut, Account accIn) throws IOException {
		InputStream is = Resources.getResourceAsStream("mybatis.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		SqlSession session = factory.openSession();
		Account accOutSel = session.selectOne("com.bjsxt.mapper.AccountMapper.selIdPwd", accOut);
		if(accOutSel!=null){
			//判断余额
			if(accOut.getBalance() <= accOutSel.getBalance()){
				//判断收款人账号和姓名
				Account accInSel = session.selectOne("com.bjsxt.mapper.AccountMapper.selIdName", accIn);
				if(accInSel!=null){
					//转账操作
					accOut.setBalance(-accOut.getBalance());
					int index = session.update("com.bjsxt.mapper.AccountMapper.updBal", accOut);
					index += session.update("com.bjsxt.mapper.AccountMapper.updBal", accIn);
					if(index==2){
						Log log = new Log();
						log.setOutId(accOut.getId());
						log.setInId(accIn.getId());
						log.setBalance(accIn.getBalance());
						//记录转账日志到日志表中
						int result = session.insert("com.bjsxt.mapper.LogMapper.insLog", log);
						if(result>0){
							logger.error(accOutSel.getName()+"向"+accIn.getName()+"转账"+accIn.getBalance()+"元");
						} 
						
						//事务提交
						session.commit();
						session.close();
						return SUCCESS;
					}else{
						//事务回滚
						session.rollback();
						session.close();
						return FAILED;
					}
					
				}else{
					session.close();
					return ID_NAME_NOT_MATCHED;
				}
			}else{
				session.close();
				return BALANCE_NOT_ENOUGH;
			}
		} else {
			session.close();
			return ID_PWD_NOT_MATCHED;
		}
	}

}
