package com.greedystar.generator.db;


import com.greedystar.generator.entity.ColumnInfo;
import com.greedystar.generator.utils.ConfigUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Author GreedyStar
 * Date   2018/4/19
 */
public class ConnectionUtil {
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;

    /**java.sql.Types 对应的值**/
    public final static int BIT   =  -7;
    public final static int TINYINT  =  -6;
    public final static int SMALLINT =   5;
    public final static int INTEGER  =   4;
    public final static int BIGINT   =  -5;
    public final static int FLOAT   =   6;
    public final static int REAL   =   7;
    public final static int DOUBLE   =   8;
    public final static int NUMERIC  =   2;
    public final static int DECIMAL  =   3;
    public final static int CHAR  =   1;
    public final static int VARCHAR  =  12;
    public final static int LONGVARCHAR  =  -1;
    public final static int DATE   =  91;
    public final static int TIME   =  92;
    public final static int TIMESTAMP  =  93;
    public final static int BINARY  =  -2;
    public final static int VARBINARY  =  -3;
    public final static int LONGVARBINARY  =  -4;
    public final static int NULL  =   0;
    public final static int OTHER  = 1111;
    public final static int JAVA_OBJECT         = 2000;
    public final static int DISTINCT            = 2001;
    public final static int STRUCT              = 2002;
    public final static int ARRAY               = 2003;
    public final static int BLOB                = 2004;
    public final static int CLOB                = 2005;
    public final static int REF                 = 2006;
    public final static int DATALINK = 70;
    public final static int BOOLEAN = 16;
    public final static int ROWID = -8;
    public static final int NCHAR = -15;
    public static final int NVARCHAR = -9;
    public static final int LONGNVARCHAR = -16;
    public static final int NCLOB = 2011;
    public static final int SQLXML = 2009;
    /**
     * 初始化数据库连接
     *
     * @return
     */
    public boolean initConnection() {
        try {
            Class.forName(DriverFactory.getDriver(ConfigUtil.getConfiguration().getDb().getUrl()));
            String url = ConfigUtil.getConfiguration().getDb().getUrl();
            String username = ConfigUtil.getConfiguration().getDb().getUsername();
            String password = ConfigUtil.getConfiguration().getDb().getPassword();
            connection = DriverManager.getConnection(url, username, password);
            return true;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 获取表结构数据
     *
     * @param tableName 表名
     * @return 包含表结构数据的列表
     */
    public List<ColumnInfo> getMetaData(String tableName) throws SQLException {
        ResultSet tempResultSet = connection.getMetaData().getPrimaryKeys(null, null, tableName);
        String primaryKey = null;
        if (tempResultSet.next()) {
            primaryKey = tempResultSet.getObject(4).toString();
        }
        List<ColumnInfo> columnInfos = new ArrayList<>();
        statement = connection.createStatement();
        String sql = "SELECT * FROM " + tableName + " WHERE 1 != 1";
        resultSet = statement.executeQuery(sql);
        ResultSetMetaData metaData = resultSet.getMetaData();
        for (int i = 1; i <= metaData.getColumnCount(); i++) {
            ColumnInfo info;
            if (metaData.getColumnName(i).equals(primaryKey)) {
                info = new ColumnInfo(metaData.getColumnName(i), metaData.getColumnType(i), true);
            } else {
                info = new ColumnInfo(metaData.getColumnName(i), metaData.getColumnType(i), false);
            }
            columnInfos.add(info);
        }
        statement.close();
        resultSet.close();
        return columnInfos;
    }

    public void close() {
        try {
            if (!connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



}
