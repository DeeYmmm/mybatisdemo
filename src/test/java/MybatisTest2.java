import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import ym.mybatis.domain.Person;
import ym.mybatis.mapper.PersonMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MybatisTest2 {

    public SqlSessionFactory getSqlSessionFactory() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        return new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void test1() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            PersonMapper personMapper = sqlSession.getMapper(PersonMapper.class);
//            Map<String, Person> map = personMapper.getPersonWithNameReturnMap("%a%");
            Map<String, Object> map = personMapper.getPersonByIdReturnMap(37);
            System.out.println(map);
        }finally {
            sqlSession.close();
        }
    }

    @Test
    public void test2() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            PersonMapper mapper = sqlSession.getMapper(PersonMapper.class);
            List<Person> persons = mapper.getPersonWithNameLike("%a%");
            System.out.println(persons);
        }finally {
            sqlSession.close();
        }
    }

    @Test
    public void test3() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            PersonMapper mapper = sqlSession.getMapper(PersonMapper.class);
            Map<String,Object> map=new HashMap<>();
            map.put("table","person");
            map.put("id",40);
            map.put("name","电棍");
            Person person = mapper.getPersonByMap(map);
            System.out.println(person);
        }finally {
            sqlSession.close();
        }
    }

    @Test
    public void test4() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            PersonMapper mapper = sqlSession.getMapper(PersonMapper.class);
            Person person = mapper.getPersonByIdAndName(40, "电棍");
            System.out.println(person);
        }finally {
            sqlSession.close();
        }
    }
}
