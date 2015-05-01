package dao;

import model.DBInfo;
import model.Post;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by RyomaArai on 15/04/02.
 */
public class EachBookDAO {
    public List<Post> findByIsbn(String isbn_str, String postCount) {
        Connection conn = null;
        List<Post> eachBookPostsList = new ArrayList<Post>();
        DBInfo dbInfo = new DBInfo();
        String url = dbInfo.getUrl();
        String user = dbInfo.getUser();
        String password = dbInfo.getPassword();

        try {
            // JDBCドライバを読み込む
            Class.forName("com.mysql.jdbc.Driver");

            // データベースに接続
            conn = DriverManager.getConnection(url, user, password);

            // LIMITの値を作成する
            int limit_int = Integer.parseInt(postCount) + 20;
            String limit_str = String.valueOf(limit_int);

            // SELECT文を準備
            String sql = "Select phrase from posts WHERE isbn=" + isbn_str + " ORDER BY post_date DESC LIMIT " + limit_str;
            PreparedStatement pSmt = conn.prepareStatement(sql);

            // SECLECT文を実行し、結果表を取得
            ResultSet resultSet = pSmt.executeQuery();

            if (resultSet != null) {
                while (resultSet.next()) {
                    String phrase = resultSet.getString("phrase");
                    Post post = new Post(phrase);
                    eachBookPostsList.add(post);
                }
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

        return eachBookPostsList;
    }
}
