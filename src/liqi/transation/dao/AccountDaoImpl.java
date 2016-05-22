package liqi.transation.dao;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

/**
 * Created by liqi on 2016/5/22.
 */
public class AccountDaoImpl extends JdbcDaoSupport implements AccountDao {
    @Override
    public void outMoney(String out, Double money) {
        String sql = "update account set money = money - ? where name = ?";
        this.getJdbcTemplate().update(sql,money,out);
    }

    @Override
    public void inMoney(String out, Double money) {
        String sql = "update account set money = money + ? where name = ?";
        this.getJdbcTemplate().update(sql,money,out);
    }
}
