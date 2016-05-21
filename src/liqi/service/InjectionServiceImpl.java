package liqi.service;


import liqi.dao.InjectionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class InjectionServiceImpl implements InjectionService {

	@Autowired
	public InjectionDAO injectionDAO;

	//构造器注入
	@Autowired
	public InjectionServiceImpl(InjectionDAO injectionDAO1) {
		this.injectionDAO = injectionDAO1;
	}
	
	//设值注入
	@Autowired
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
