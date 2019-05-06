import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import ym.mybatis.domain.Person;
import ym.mybatis.mapper.PersonMapper;

import java.io.IOException;
import java.io.InputStream;

public class MybatisTest {

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
            Person person = personMapper.getPersonById(13);
            System.out.println(person);
        }finally {
            sqlSession.close();
        }
    }

    /**
     * 默认打开的openSession是不自动提交的，增删改必须要手动提交，或者使用sqlSessionFactory.openSession(true)
     * @throws IOException
     */
    @Test
    public void test2() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        try {
            PersonMapper personMapper = sqlSession.getMapper(PersonMapper.class);
            Person person=new Person("电棍","man");
            boolean b = personMapper.insertPerson(person);
            System.out.println(b);
            System.out.println(person);
        }finally {
            sqlSession.close();
        }
    }
}
