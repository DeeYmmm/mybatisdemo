import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import ym.mybatis.domain.Person;
import ym.mybatis.mapper.PersonMapper;

import java.io.IOException;
import java.io.InputStream;

public class MybatisTest5 {

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
            PersonMapper mapper = sqlSession.getMapper(PersonMapper.class);
            Person person = mapper.getPersonById(40);
            System.out.println(person);

            //1.SqlSession不同
            /*SqlSession sqlSession1 = sqlSessionFactory.openSession();
            PersonMapper mapper1 = sqlSession1.getMapper(PersonMapper.class);*/

            //2.SqlSession相同，手动清除了缓存(只清除当前SqlSession相同的一级缓存)
            //sqlSession.clearCache();

            //3.SqlSession相同,两次查询之间进行了增删改操作
            /*Person person2=new Person("塞拉斯","男");
            mapper.insertPerson(person2);
            sqlSession.commit();*/
            Person person1 = mapper.getPersonById(40);
            System.out.println(person1);
            System.out.println(person==person1);
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void test2() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        SqlSession sqlSession1 = sqlSessionFactory.openSession();
        try {
            PersonMapper mapper = sqlSession.getMapper(PersonMapper.class);
            PersonMapper mapper1 = sqlSession1.getMapper(PersonMapper.class);

            Person person = mapper.getPersonById(40);
            System.out.println(person);
            sqlSession.close();

            Person person2=new Person("Lux","nv");
            mapper1.insertPerson(person2);
            Person person1 = mapper1.getPersonById(40);
            System.out.println(person1);
        } finally {
            sqlSession1.close();
        }
    }
}
