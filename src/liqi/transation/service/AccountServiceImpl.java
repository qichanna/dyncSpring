package liqi.transation.service;

import liqi.transation.dao.AccountDao;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by liqi on 2016/5/22.
 */

/**
 *  @Transactional注解中的属性:
 *   propagation  : 事物的传播行为
 *   isolation    : 事物的隔离级别
 *   readOnly     : 只读
 *   rollbackFor  : 发生哪些异常回滚
 *   noRollbackFor: 发生哪些异常不回滚
 *
 */

@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT)
public class AccountServiceImpl implements AccountService {

    private AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public void transfer(String out, String in, Double money) {
        accountDao.outMoney(out,money);
        int i = 1/ 0;
        accountDao.inMoney(in,money);
    }
}
