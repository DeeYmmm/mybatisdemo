import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import ym.mybatis.domain.Person;
import ym.mybatis.domain.PersonClass;
import ym.mybatis.mapper.PersonClassMapper;
import ym.mybatis.mapper.PersonMapperPlus;

import java.io.IOException;
import java.io.InputStream;

public class MybatisTest3 {
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
            PersonMapperPlus mapper = sqlSession.getMapper(PersonMapperPlus.class);
            /*Person person = mapper.getPersonAndClass(40);
            System.out.println(person);*/
            Person person1 = mapper.getPersonByIdStep(40);
            System.out.println(person1.getName());
            System.out.println(person1.getPersonClass());
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void test2() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            PersonClassMapper mapper = sqlSession.getMapper(PersonClassMapper.class);
            PersonClass personClass = mapper.getClassByClassIdStep(2);
            System.out.println(personClass);
            System.out.println(personClass.getPersons());
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void test3() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            PersonClassMapper mapper = sqlSession.getMapper(PersonClassMapper.class);
            PersonClass personClass = mapper.getPersonClassByIdPlus(2);
            System.out.println(personClass.getPersons());
        } finally {
            sqlSession.close();
        }
    }
}
