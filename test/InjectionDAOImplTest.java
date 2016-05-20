import dao.InjectionDAO;
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
        super("classpath*:spring-injection.xml");
    }

    @Test
    public void aa() throws Exception {
//        String bean=getClass().getResource("spring-injection.xml").toString();
//        ApplicationContext ctx=new FileSystemXmlApplicationContext(bean);
//        ApplicationContext factory=new ClassPathXmlApplicationContext("classpath:spring-ioc.xml");
        InjectionServiceImpl i = super.getBean("injectionService");
        i.save("ffg");
    }
}