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
            Person person1 = mapper.getPersonById(40);
            System.out.println(person1);
            System.out.println(person==person1);
        } finally {
            sqlSession.close();
        }
    }
}
