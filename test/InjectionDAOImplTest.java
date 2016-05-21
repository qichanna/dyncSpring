import org.junit.Test;

import liqi.dao.InjectionDAO;
import liqi.service.InjectionServiceImpl;


/**
 * Created by liqi7 on 2016/5/19.
 */
public class InjectionDAOImplTest extends UnitTestBase{

    public InjectionDAOImplTest() {
        super("classpath*:spring-beanannotation.xml");
    }

    @Test
    public void aa() throws Exception {
//        String bean=getClass().getResource("spring-injection.xml").toString();
//        ApplicationContext ctx=new FileSystemXmlApplicationContext(bean);
//        ApplicationContext factory=new ClassPathXmlApplicationContext("classpath:spring-ioc.xml");
        InjectionServiceImpl i = super.getBean("injectionService");
        i.save("ffg");
    }

    @Test
    public void bb(){
        InjectionDAO i = super.getBean("injectionDAOImpl");
        i.save("hh");
    }

    @Test
    public void cc(){
        InjectionServiceImpl i = super.getBean("injectionServiceImpl");
        i.save("hh");
    }
}