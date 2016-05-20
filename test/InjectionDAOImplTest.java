import dao.InjectionDAO;
import dao.InjectionDAOImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import service.InjectionService;
import service.InjectionServiceImpl;


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
        InjectionDAOImpl i = super.getBean("abc");
        i.save("ffg");
    }


    @Test
    public void testannotion() throws Exception {
//        String bean=getClass().getResource("spring-injection.xml").toString();
//        ApplicationContext ctx=new FileSystemXmlApplicationContext(bean);
//        ApplicationContext factory=new ClassPathXmlApplicationContext("classpath:spring-ioc.xml");
        InjectionServiceImpl i = super.getBean("injectionServiceImpl");
        i.save("ffg");
    }
}