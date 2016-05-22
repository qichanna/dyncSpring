package liqi.transation.dao;

/**
 * Created by liqi on 2016/5/22.
 */
public interface AccountDao {

    public void outMoney(String out,Double money);

    public void inMoney(String out,Double money);
}
