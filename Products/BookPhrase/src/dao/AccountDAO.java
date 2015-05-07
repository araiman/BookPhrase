package dao;

import model.Account;
import model.DBInfo;

import java.sql.*;

/**
 * Created by RyomaArai on 15/04/12.
 */
public class AccountDAO {
    // ユーザー検索の処理(FB,TW,EMAIL)
    public String findByFbId(String fbUserId_str) {
        Connection conn = null;
        DBInfo dbInfo = new DBInfo();
        String url = dbInfo.getUrl();
        String user = dbInfo.getUser();
        String dbPassword = dbInfo.getPassword();
        String userId;

        try {
            // JDBCドライバを読み込む
            Class.forName("com.mysql.jdbc.Driver");

            // データベースに接続
            conn = DriverManager.getConnection(url, user, dbPassword);

            // SELECT文を準備
            String sql = "SELECT id FROM accounts WHERE fb_id=" + fbUserId_str;
            PreparedStatement pSmt = conn.prepareStatement(sql);

            // SECLECT文を実行し、結果表を取得
            ResultSet resultSet = pSmt.executeQuery();

            if (!resultSet.next()) {
                return null;
            } else {
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
        String dbPassword = dbInfo.getPassword();
        String userId;

        try {
            // JDBCドライバを読み込む
            Class.forName("com.mysql.jdbc.Driver");

            // データベースに接続
            conn = DriverManager.getConnection(url, user, dbPassword);

            // SELECT文を準備
            String sql = "SELECT id FROM accounts WHERE tw_id=" + twUserId_str;
            PreparedStatement pSmt = conn.prepareStatement(sql);

            // SECLECT文を実行し、結果表を取得
            ResultSet resultSet = pSmt.executeQuery();

            if (!resultSet.next()) {
                return null;
            } else {
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

    public String findByEmail(String email, String userPassword) {
        Connection conn = null;
        DBInfo dbInfo = new DBInfo();
        String url = dbInfo.getUrl();
        String user = dbInfo.getUser();
        String dbPassword = dbInfo.getPassword();
        String userId = "";

        try {
            // JDBCドライバを読み込む
            Class.forName("com.mysql.jdbc.Driver");
            // データベースに接続
            conn = DriverManager.getConnection(url, user, dbPassword);

            // SELECT文を準備
            String sql = String.format("SELECT id FROM accounts WHERE mail= \"%s\" AND pass= \"%s\"", email, userPassword);
            PreparedStatement pSmt = conn.prepareStatement(sql);

            // SECLECT文を実行し、結果表を取得
            ResultSet resultSet = pSmt.executeQuery();

            if (!resultSet.next()) {
                System.out.println("指定のユーザーは存在しませんでした。nullを返します。");
                return null;
            } else {
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

    // ユーザー登録の処理(FB,TW,EMAIL)
    public void registerByEmail(String name, String email, String userPassword) {
        Connection conn = null;
        DBInfo dbInfo = new DBInfo();
        String url = dbInfo.getUrl();
        String user = dbInfo.getUser();
        String dbPassword = dbInfo.getPassword();

        try {
            // JDBCドライバを読み込む
            Class.forName("com.mysql.jdbc.Driver");
            // データベースに接続
            conn = DriverManager.getConnection(url, user, dbPassword);

            // INSERT文を準備
            String sql = String.format("INSERT INTO accounts(name,mail,pass) values(\"%s\",\"%s\",\"%s\")", name, email, userPassword);
            PreparedStatement pSmt = conn.prepareStatement(sql);

            pSmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return;
        } finally {
            // データベースを切断
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    return;
                }
            }
        }
    }

    // TODO テスト用のメソッドは、ここに書くべきではない？誰かに聞く。
    // 最新のuserIdを取得する(テスト用)
    public String getLatestUserId() {
        Connection conn = null;
        DBInfo dbInfo = new DBInfo();
        String url = dbInfo.getUrl();
        String user = dbInfo.getUser();
        String dbPassword = dbInfo.getPassword();
        String userId;

        try {
            // JDBCドライバを読み込む
            Class.forName("com.mysql.jdbc.Driver");

            // データベースに接続
            conn = DriverManager.getConnection(url, user, dbPassword);

            // SELECT文を準備
            String sql = "SELECT id FROM accounts DESC LIMIT 1";
            PreparedStatement pSmt = conn.prepareStatement(sql);

            // SECLECT文を実行し、結果表を取得
            ResultSet resultSet = pSmt.executeQuery();

            if (!resultSet.next()) {
                return null;
            } else {
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

