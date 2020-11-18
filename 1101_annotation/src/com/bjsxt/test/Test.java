package com.bjsxt.test;

import org.apache.ibatis.session.SqlSession;
import com.bjsxt.mapper.TeacherMapper;
import com.bjsxt.pojo.Teacher;
import com.bjsxt.util.MybatisUtil;

public class Test {

	public static void main(String[] args) {
		SqlSession session = MybatisUtil.getSqlSession();
		TeacherMapper mapper = session.getMapper(TeacherMapper.class);
		/*List<Teacher> list = mapper.selAll();
		for (Teacher teacher : list) {
			System.out.println(teacher);
			
		}*/
		Teacher teacher = new Teacher();
		teacher.setId(5);
		teacher.setName("扁鹊");
//		int index = mapper.add(teacher);
//		int index = mapper.upd(teacher);
		int index = mapper.del(5);
		if(index>0){
			session.commit();
			System.out.println("成功");
		}
		MybatisUtil.close();
		
		
	}

}
