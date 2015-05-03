package dao;

import model.Account;
import model.DBInfo;

import java.sql.*;

/**
 * Created by RyomaArai on 15/04/12.
 */
public class AccountDAO {
    public String findByFbId(String fbUserId_str) {
        Connection conn = null;
        DBInfo dbInfo = new DBInfo();
        String url = dbInfo.getUrl();
        String user = dbInfo.getUser();
        String password = dbInfo.getPassword();
        String userId;

        try {
            // JDBCドライバを読み込む
            Class.forName("com.mysql.jdbc.Driver");

            // データベースに接続
            conn = DriverManager.getConnection(url, user, password);

            // SELECT文を準備
            String sql = "SELECT id FROM accounts WHERE fb_id=" + fbUserId_str;
            PreparedStatement pSmt = conn.prepareStatement(sql);

            // SECLECT文を実行し、結果表を取得
            ResultSet resultSet = pSmt.executeQuery();

            if (!resultSet.next()) {
                return null;
            } else {
                resultSet.next();
                userId = resultSet.getString("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } finally {
            // データベースを切断
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }
        return userId;
    }

    public String findByTwId(String twUserId_str) {
        Connection conn = null;
        DBInfo dbInfo = new DBInfo();
        String url = dbInfo.getUrl();
        String user = dbInfo.getUser();
        String password = dbInfo.getPassword();
        String userId;

        try {
            // JDBCドライバを読み込む
            Class.forName("com.mysql.jdbc.Driver");

            // データベースに接続
            conn = DriverManager.getConnection(url, user, password);

            // SELECT文を準備
            String sql = "SELECT id FROM accounts WHERE tw_id=" + twUserId_str;
            PreparedStatement pSmt = conn.prepareStatement(sql);

            // SECLECT文を実行し、結果表を取得
            ResultSet resultSet = pSmt.executeQuery();

            if (!resultSet.next()) {
                return null;
            } else {
                resultSet.next();
                userId = resultSet.getString("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } finally {
            // データベースを切断
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }
        return userId;

    }

    public String findByEmail(String email, String accountPassword) {
        Connection conn = null;
        DBInfo dbInfo = new DBInfo();
        String url = dbInfo.getUrl();
        String user = dbInfo.getUser();
        String password = dbInfo.getPassword();
        String userId = "";

        try {
            // JDBCドライバを読み込む
            Class.forName("com.mysql.jdbc.Driver");
            // データベースに接続
            conn = DriverManager.getConnection(url, user, password);

            // SELECT文を準備
            String sql = String.format("SELECT id FROM accounts WHERE mail= \"%s\" AND pass= \"%s\"", email, accountPassword);
            PreparedStatement pSmt = conn.prepareStatement(sql);

            // SECLECT文を実行し、結果表を取得
            ResultSet resultSet = pSmt.executeQuery();

            if (!resultSet.next()) {
                System.out.println("指定のユーザーは存在しませんでした。nullを返します。");
                return null;
            } else {
                resultSet.next();
                userId = resultSet.getString("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } finally {
            // データベースを切断
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }
        return userId;
    }
}
