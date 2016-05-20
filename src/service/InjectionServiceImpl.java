package service;


import dao.InjectionDAO;
import org.springframework.stereotype.Component;

@Component
public class InjectionServiceImpl implements InjectionService {
	
	private InjectionDAO injectionDAO;

	//构造器注入
	public InjectionServiceImpl(InjectionDAO injectionDAO1) {
		this.injectionDAO = injectionDAO1;
	}
	
	//设值注入
	public void setInjectionDAO2(InjectionDAO injectionDAO2) {
		this.injectionDAO = injectionDAO2;
	}

	public void save(String arg) {
		//模拟业务操作
		System.out.println("Service接收参数：" + arg);
		arg = arg + ":" + this.hashCode();
		injectionDAO.save(arg);
	}
	
}
