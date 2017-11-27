package org.smart4j.chapter1.help;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.smart4j.chapter1.Util.PropsUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

/**
 * Created by mysteel-xl on 2017/11/27.
 */
public class DataBaseHelper {

    private static final QueryRunner QUERY_RUNNER = new QueryRunner();

    private static final ThreadLocal<Connection> CONNECTION_THREAD_LOCAL = new ThreadLocal<Connection>();

    private static BasicDataSource DATA_SOURCE;


    private static final String DRIVER;
    private static final String URL;
    private static final String USERNAME;
    private static final String PASSWORD;

    static {
        Properties properties = PropsUtil.loadProps("config.properties");
        DRIVER = properties.getProperty("jdbc.driver");
        URL = properties.getProperty("jdbc.url");
        USERNAME = properties.getProperty("jdbc.username");
        PASSWORD = properties.getProperty("jdbc.password");

        DATA_SOURCE = new BasicDataSource();
        DATA_SOURCE.setDriverClassName(DRIVER);
        DATA_SOURCE.setUrl(URL);
        DATA_SOURCE.setUsername(USERNAME);
        DATA_SOURCE.setPassword(PASSWORD);

        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    /**
     *  @Ps 获取数据库连接
     *  @Date 2017/11/27 11:24
     */
    public static Connection getConnection(){
        Connection con = CONNECTION_THREAD_LOCAL.get();
        if (con == null) {
            try {
                con = DATA_SOURCE.getConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                CONNECTION_THREAD_LOCAL.set(con);
            }
        }
        return con;
    }

    public static void closeConneciton(){
        Connection con = CONNECTION_THREAD_LOCAL.get();
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                CONNECTION_THREAD_LOCAL.remove();
            }
        }
    }

    public static <T> List<T>  queryEntityList(Class<T> entityClass,String sql, Object... param){
        List<T> entityList = null;
        Connection conn = getConnection();
        try {
            entityList = QUERY_RUNNER.query(conn, sql, new BeanListHandler<T>(entityClass), param);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeConneciton();
        }
        return entityList;
    }

    public static <T> T queryEntity(Class<T> entityClass,String sql,Object... param){
        T entity = null;
        Connection con = getConnection();
        try {
            entity = QUERY_RUNNER.query(con,sql,new BeanHandler<T>(entityClass),param);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeConneciton();
        }
        return entity;
    }

    public static int exUpdate(String sql,Object... param){
        int rows = 0;
        Connection con = getConnection();
        try {
            rows = QUERY_RUNNER.update(con,sql,param);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeConneciton();
        }
        return rows;
    }

}
