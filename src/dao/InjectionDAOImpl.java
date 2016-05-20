package dao;


/**
 * Created by liqi7 on 2016/5/19.
 */
public class InjectionDAOImpl implements InjectionDAO {

    @Override
    public void save(String arg) {
        System.out.println("保存数据：" + arg);
    }
}