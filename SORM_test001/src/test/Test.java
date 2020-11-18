package test;

import java.util.List;

import com.bjsxt.sorm.core.Query;
import com.bjsxt.sorm.core.QueryFactory;
import com.bjsxt.sorm.core.TableContext;
import com.bjsxt.test.po.Emp;
import com.bjsxt.test.vo.EmpVo;



public class Test {

	public static void testInsert(){
		Emp emp = new Emp();
		emp.setEmpname("欧成金");
		emp.setAge(18);
		emp.setSalary(10000000.0);
		QueryFactory.getFactory().createQuery().insert(emp);
		
	}
	public static void testDelete(){
		Emp emp = new Emp();
		emp.setEmpname("欧成金");
		emp.setAge(18);
		emp.setSalary(10000000.0);
		emp.setId(4);
		QueryFactory.getFactory().createQuery().delete(emp);
	}
	public static void testUpdate(){
		Emp emp = new Emp();
		emp.setEmpname("欧成金");
		emp.setAge(18);
		emp.setSalary(10000000.0);
		emp.setId(3);
		QueryFactory.getFactory().createQuery().update(emp, new String[]{"empname","age","salary"});
	}
	
	public static void testSelect(){
		Number queryNumber = QueryFactory.getFactory().createQuery().queryNumber("select count(*) from emp where "
				+ "salary>?", new Object[]{100});
		System.out.println(queryNumber);
	}
	public static void testSelectUniqueRow(){
		Query query = QueryFactory.getFactory().createQuery();
		Emp queryUniqueRow = (Emp) query.queryUniqueRow("select * from emp where id = ?", Emp.class, new Object[]{1});

		System.out.println(queryUniqueRow.getEmpname());
	}
	public static void testSelectRows(){
		Query query = QueryFactory.getFactory().createQuery();
		List<Emp> queryRows = query.queryRows("select * from emp where id > ?", Emp.class, new Object[]{1});
		
		for (Emp object : queryRows) {
			System.out.println(object.getEmpname()+"--"+object.getSalary());
			
		}
	}
	
	public static void testSelectRowsDuoTables(){
		Query query = QueryFactory.getFactory().createQuery();
		List<EmpVo> queryRows = query.queryRows("select e.id,e.empname,e.age,d.dname 'deptName',d.address 'deptAddr' from emp e inner join dept d on e.deptId = d.id", EmpVo.class, new Object[]{});
		
		for (EmpVo object : queryRows) {
			System.out.println(object.getEmpname()+"--"+object.getAge()+"--"+object.getDeptName()+"--"+object.getDeptAddr());
			
		}
	}
	public static void testQueryById(){
		Query query = QueryFactory.getFactory().createQuery();
		Emp object = (Emp) query.queryById(Emp.class, 1);
		System.out.println(object.getEmpname()+"--"+object.getSalary());
	}
	public static void main(String[] args) {
		/**
		 * 通过这个方法可以生成po类
		 */
//		TableContext.updateJavaPOFile();
//		testSelect();
//		testDelete();
//		testUpdate();
//		testSelectUniqueRow();
//		testSelectRows();
//		testSelectRowsDuoTables();
//		testQueryById();
	}

}
