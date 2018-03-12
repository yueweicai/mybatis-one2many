import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.orilore.mapper.DeptMapper;
import com.orilore.mapper.PersonMapper;
import com.orilore.model.Dept;
import com.orilore.model.Person;

public class Test {

	public static void main(String[] args) {
		try{
			Reader reader = Resources.getResourceAsReader("Configuration.xml");
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
			SqlSession session = factory.openSession();
			DeptMapper dm = session.getMapper(DeptMapper.class);
			Dept dept = dm.selectOne(1);
			System.out.println(dept.getName());
			System.out.println("-------------------------------------");
			List<Person> persons = dept.getPersons();
			for (Person person : persons) {
				System.out.println(person.getName()+"\t"+person.getSex());
			}
			
//			PersonMapper mapper = session.getMapper(PersonMapper.class);
//			Person p = mapper.selectOne(6);
//			System.out.println(p.getName()+"\t"+p.getBirthday());
//			Dept d = p.getDept();
//			System.out.println("所属部门是："+d.getName());
//			Person bean = new Person();
//			bean.setName("张王李");
//			bean.setSex("女");
//			bean.setBirthday("1988-08-09");
//			bean.setAddr("秦皇岛市海港区");
//			bean.setPhone("13412345678");
//			mapper.insert(bean);
//			
//			System.out.println(bean.getId());
//			
//			session.commit();
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}

}
