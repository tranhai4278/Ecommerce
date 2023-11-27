/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Account;
import model.AccountDetail;
import model.Category;
import model.Genres;
import model.Language;
import model.Product;
import model.ProductDetail;
import model.Sale;

/**
 *
 * @author Nết
 */
public class DAO extends DBContext {

    public List<Product> getAllPro() {
        List<Product> list = new ArrayList<>();
        String sql = " SELECT p.*, pd.*, s.sale\n"
                + "FROM Product p , ProductDetail pd, Sale s\n"
                + "where p.id=pd.pid and pd.saleid=s.id";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Product p = new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getInt(7));
                p.setPd(new ProductDetail(rs.getString("sellDate"), rs.getInt("amount"), rs.getDouble("price")));
                p.setS(new Sale(rs.getInt("saleid"), rs.getInt("sale")));
                list.add(p);
            }
        } catch (SQLException e) {
        }
        return list;
    }

    public List<AccountDetail> getAllAcc() {
        List<AccountDetail> list = new ArrayList<>();
        String sql = " SELECT [id]\n"
                + "      ,[userName]\n"
                + "      ,[phoneNumber]\n"
                + "      ,[email]\n"
                + "      ,[address]\n"
                + "      ,[avatar]\n"
                + "      ,[gender]\n"
                + "  FROM [dbo].[AccountDetail]";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                AccountDetail p = new AccountDetail(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getBoolean(7));
            }
        } catch (SQLException e) {
        }
        return list;
    }

    public List<Product> getProD() {
        List<Product> list = new ArrayList<>();
        String sql = " SELECT p.*, pd.*, s.sale\n"
                + "FROM Product p , ProductDetail pd, Sale s\n"
                + "where p.id=pd.pid and pd.saleid=s.id \n"
                + "Order by p.name desc";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Product p = new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getInt(7));
                p.setPd(new ProductDetail(rs.getString("sellDate"), rs.getInt("amount"), rs.getDouble("price")));
                p.setS(new Sale(rs.getInt("saleid"), rs.getInt("sale")));
                list.add(p);
            }
        } catch (SQLException e) {
        }
        return list;
    }

    public List<Product> searchByCheck(int[] gid) {
        List<Product> list = new ArrayList<>();
        String sql = "SELECT p.*, pd.*, s.sale, g.genres\n"
                + "FROM Product p , ProductDetail pd, Sale s, ProductGenres pg , Genres g\n"
                + "where p.id=pd.pid and pd.saleid=s.id and p.id=pg.pid and g.id=pg.gid and 1=1";
        if (gid != null && gid[0] != 0) {
            sql += " and g.id in(";
            for (int i = 0; i < gid.length; i++) {
                sql += gid[i] + ",";
            }
            if (sql.endsWith(",")) {
                sql = sql.substring(0, sql.length() - 1);
            }
            sql += ")";
        }
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Product p = new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getInt(7));
                p.setPd(new ProductDetail(rs.getString("sellDate"), rs.getInt("amount"), rs.getDouble("price")));
                p.setS(new Sale(rs.getInt("saleid"), rs.getInt("sale")));
                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public List<Product> getProA() {
        List<Product> list = new ArrayList<>();
        String sql = " SELECT p.*, pd.*, s.sale\n"
                + "FROM Product p , ProductDetail pd, Sale s\n"
                + "where p.id=pd.pid and pd.saleid=s.id \n"
                + "Order by p.name asc";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Product p = new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getInt(7));
                p.setPd(new ProductDetail(rs.getString("sellDate"), rs.getInt("amount"), rs.getDouble("price")));
                p.setS(new Sale(rs.getInt("saleid"), rs.getInt("sale")));
                list.add(p);
            }
        } catch (SQLException e) {
        }
        return list;
    }

    public AccountDetail getAccDetail(int uid) {
        String sql = " SELECT [id]\n"
                + "      ,[userName]\n"
                + "      ,[phoneNumber]\n"
                + "      ,[email]\n"
                + "      ,[address]\n"
                + "      ,[avatar]\n"
                + "      ,[gender]\n"
                + "  FROM [dbo].[AccountDetail]"
                + " Where id= ? ";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, uid);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                return new AccountDetail(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getBoolean(7));

            }
        } catch (SQLException e) {
        }
        return null;
    }

    public void changeProfile(AccountDetail acc) {
        String sql = "   UPDATE [dbo].[AccountDetail]\n"
                + "   SET \n"
                + "      [userName] = ?\n"
                + "      ,[address] = ?\n"
                + "      ,[avatar] = ?\n"
                + "      ,[gender] = ?\n"
                + " WHERE id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, acc.getUserName());
            ps.setString(2, acc.getAddress());
            ps.setString(3, acc.getAvatar());
            ps.setBoolean(4, acc.isGender());
            ps.setInt(5, acc.getId());
            ps.executeUpdate();
        } catch (SQLException ex) {

        }
    }

    public void changePass(Account acc) {
        String sql = "   UPDATE [dbo].[Account]\n"
                + "SET \n"
                + "  [pass] = ?\n"
                + "  WHERE id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, acc.getPass());
            ps.setInt(2, acc.getId());
            ps.executeUpdate();
        } catch (SQLException ex) {

        }
    }

    public List<Product> getRelateP(String cid) {
        List<Product> list = new ArrayList<>();
        String sql = " SELECT p.*, pd.*, s.sale\n"
                + "FROM Product p , ProductDetail pd, Sale s\n"
                + "where p.id=pd.pid and pd.saleid=s.id and cid=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, cid);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Product p = new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getInt(7));
                p.setPd(new ProductDetail(rs.getString("sellDate"), rs.getInt("amount"), rs.getDouble("price")));
                p.setS(new Sale(rs.getInt("saleid"), rs.getInt("sale")));
                list.add(p);
            }
        } catch (SQLException e) {
        }
        return list;
    }

    public List<Product> getTop6() {
        List<Product> list = new ArrayList<>();
        String sql = " SELECT top 6 p.*, pd.*, s.sale\n"
                + "FROM Product p , ProductDetail pd, Sale s\n"
                + "where p.id=pd.pid and pd.saleid=s.id";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Product p = new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getInt(7));
                p.setPd(new ProductDetail(rs.getString("sellDate"), rs.getInt("amount"), rs.getDouble("price")));
                p.setS(new Sale(rs.getInt("saleid"), rs.getInt("sale")));
                list.add(p);
            }
        } catch (SQLException e) {
        }
        return list;
    }

    public List<Product> getNext6(int num) {
        List<Product> list = new ArrayList<>();
        String sql = " SELECT p.*, pd.*, sale\n"
                + "FROM\n"
                + "   Product p, ProductDetail pd, Sale s\n"
                + "Where \n"
                + "	p.id=pd.pid and pd.saleid=s.id\n"
                + "ORDER BY\n"
                + "    id\n"
                + "OFFSET ? ROWS \n"
                + "FETCH NEXT 6 ROWS ONLY;";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, num);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Product p = new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getInt(7));
                p.setPd(new ProductDetail(rs.getString("sellDate"), rs.getInt("amount"), rs.getDouble("price")));
                p.setS(new Sale(rs.getInt("saleid"), rs.getInt("sale")));
                list.add(p);
            }
        } catch (SQLException e) {
        }
        return list;
    }

    public List<Product> getProductbyCid(String cid) {
        List<Product> list = new ArrayList<>();
        String sql = "SELECT p.*, pd.*\n"
                + "FROM Product p , ProductDetail pd\n"
                + "where p.id=pd.pid and p.cid=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, cid);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Product p = new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getInt(7));
                p.setPd(new ProductDetail(rs.getString("sellDate"), rs.getInt("amount"), rs.getDouble("price")));
                list.add(p);
            }
        } catch (SQLException e) {
        }
        return list;
    }

    public List<Product> getProById(String cid) {
        List<Product> list = new ArrayList<>();
        String sql = "SELECT p.*, pd.*\n"
                + "FROM Product p , ProductDetail pd\n"
                + "where p.id=pd.pid and p.cid=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, cid);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Product p = new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getInt(7));
                p.setPd(new ProductDetail(rs.getString("sellDate"), rs.getInt("amount"), rs.getDouble("price")));
                list.add(p);
            }
        } catch (SQLException e) {
        }
        return list;
    }

    public void updateQuantity(String pid, int amount) {
        String sql = "UPDATE [dbo].[ProductDetail]\n"
                + "   SET [amount] = ?\n"
                + " WHERE pid = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, amount);
            ps.setString(2, pid);
            ps.executeQuery();
        } catch (SQLException e) {
        }
    }

    public Product getProductbyId(String id) {
        Product p = null;
        String sql = "SELECT p.*, pd.*, l.language, c.category, s.sale\n"
                + "    FROM Product p , ProductDetail pd, Language l, Category c, Sale s\n"
                + "        where p.cid = c.id and p.id=pd.pid and pd.lid=l.id and pd.saleid=s.id and p.id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                p = new Product(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("img"),
                        rs.getString("title"),
                        rs.getString("description"), rs.getInt("cid"), rs.getInt("sid"));
                p.setPd(new ProductDetail(rs.getString("sellDate"), rs.getInt("amount"), rs.getDouble("price")));
                p.setLang(new Language(rs.getInt("lid"), rs.getString("language")));
                p.setC(new Category(rs.getInt("cid"), rs.getString("category")));
                p.setS(new Sale(rs.getInt("saleid"), rs.getInt("sale")));
            }
        } catch (SQLException e) {
        }
        return p;
    }

    public List<Product> getNewProduct() {
        List<Product> list = new ArrayList<>();
        String sql = "SELECT top 7 p.*, pd.amount,pd.sellDate,pd.price\n"
                + "  FROM Product p , ProductDetail pd\n"
                + "  where p.id=pd.pid\n"
                + "  order by pd.sellDate desc";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Product p = new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5), rs.getInt(6), rs.getInt(7));
                p.setPd(new ProductDetail(rs.getString("sellDate"), rs.getInt("amount"), rs.getDouble("price")));
                list.add(p);
            }

        } catch (SQLException e) {
        }
        return list;
    }

    public List<Product> getTopSell() {
        List<Product> list = new ArrayList<>();
        String sql = "SELECT TOP (7) p.id, p.name, p.img, p.title, p.description, pd.price, COUNT (ol.pid) as [count]\n"
                + "From Product p, ProductDetail pd, OrderLine ol \n"
                + "where p.id=pd.pid and ol.pid=p.id \n"
                + "group by p.id, p.name, p.img, p.title, p.description, pd.price";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Product p = new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5), rs.getInt(6), rs.getInt(7));
                p.setPd(new ProductDetail(rs.getString("sellDate"), rs.getInt("amount"), rs.getDouble("price")));
                list.add(p);
            }

        } catch (SQLException e) {
        }
        return list;
    }

    public List<Genres> getAllGenres() {
        List<Genres> list = new ArrayList<>();
        String sql = " SELECT g.id, g.genres, COUNT(pg.gid) as count\n"
                + "FROM Genres g\n"
                + "LEFT JOIN ProductGenres pg ON g.id = pg.gid\n"
                + "GROUP BY g.id, g.genres; ";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                list.add(new Genres(rs.getInt(1), rs.getString(2), rs.getInt("count")));
            }
        } catch (SQLException e) {
        }
        return list;
    }

    public List<Genres> getGenresbyPid(String pid) {
        List<Genres> list = new ArrayList<>();
        String sql = " SELECT g.*\n"
                + "FROM Product p , ProductGenres pg, Genres g\n"
                + "where p.id=pg.pid and pg.gid=g.id and p.id=? ";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, pid);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                list.add(new Genres(rs.getInt("id"), rs.getString("genres")));
            }
        } catch (SQLException e) {
        }
        return list;
    }

    public List<Language> getAllLang() {
        List<Language> list = new ArrayList<>();
        String sql = " SELECT * FROM [dbo].[Language] ";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                list.add(new Language(rs.getInt(1), rs.getString(2)));
            }
        } catch (SQLException e) {
        }
        return list;
    }

    public List<Category> getCategory() {
        List<Category> list = new ArrayList<>();
        String sql = " SELECT *\n"
                + "  FROM [dbo].[Category]";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                list.add(new Category(rs.getInt(1),
                        rs.getString(2)));
            }

        } catch (SQLException e) {
        }
        return list;
    }

    public List<Product> getAllDetail() {
        List<Product> list = new ArrayList<>();
        String sql = "select DISTINCT  p.*,pd.*, l.language, s.sale,s.quantity,c.category\n"
                + "from Category c, Product p, ProductDetail pd, Language l, Product , Sale s\n"
                + "where c.id=p.cid and p.id= pd.pid and pd.lid = l.id and pd.saleid=s.id";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Product p = new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getInt(7));
                p.setPd(new ProductDetail(rs.getString("sellDate"), rs.getInt("amount"), rs.getDouble("price")));
                p.setLang(new Language(rs.getInt("lid"), rs.getString("language")));
                p.setC(new Category(rs.getInt("cid"), rs.getString("category")));
                p.setS(new Sale(rs.getInt("sid"), rs.getInt("sale")));

                list.add(p);
            }

        } catch (SQLException e) {
        }
        return list;
    }

    public List<Account> getAllUser() {
        List<Account> list = new ArrayList<>();
        String sql = " SELECT *"
                + "  FROM [dbo].[Account]";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                list.add(new Account(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5)));
            }
        } catch (SQLException e) {
        }
        return list;
    }

    public Account checkUser(String user, String pass) {
        String sql = " SELECT *\n"
                + "  FROM [dbo].[Account]\n"
                + "  Where [user]= ? and pass=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, user);
            st.setString(2, pass);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                return new Account(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5));
            }
        } catch (SQLException e) {

        }
        return null;

    }

    public boolean checkPass(int id, String pass) {

        String sql = " SELECT *\n"
                + "  FROM [dbo].[Account]\n"
                + "  Where id= ? and pass=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            st.setString(2, pass);
            ResultSet rs = st.executeQuery();
            return rs.next();
        } catch (SQLException e) {

        }
        return false;

    }

    public Account checkExist(String user) {
        String sql = " SELECT *\n"
                + "  FROM [dbo].[Account]\n"
                + "  Where [user]= ? ";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, user);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                return new Account(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5));
            }
        } catch (SQLException e) {

        }
        return null;

    }

    public void signUp(String user, String pass, String phone, String email) {
        String sql = "INSERT INTO [dbo].[Account]\n"
                + "     VALUES\n"
                + "           (?, ?, 0, 0)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, user);
            st.setString(2, pass);
            st.executeUpdate();

            String sql3 = "SELECT TOP 1 id\n"
                    + "FROM Account \n"
                    + "ORDER BY id DESC";
            PreparedStatement st3 = connection.prepareStatement(sql3);
            ResultSet rs = st3.executeQuery();
            if (rs.next()) {
                int uid = rs.getInt("id");
                String sql4 = "INSERT INTO [dbo].[AccountDetail]\n"
                        + "           ([id]\n"
                        + "           ,[phoneNumber]\n"
                        + "           ,[email])\n"
                        + "     VALUES\n"
                        + "           (?,?,?)";
                PreparedStatement st4 = connection.prepareStatement(sql4);
                st4.setInt(1, uid);
                st4.setString(2, phone);
                st4.setString(3, email);

                st4.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Product> getProductbySellid(int sid) {
        List<Product> list = new ArrayList<>();
        String sql = "SELECT p.*, pd.*, l.language, c.category, s.sale\n"
                + "FROM Product p , ProductDetail pd, Language l, Category c, Sale s\n"
                + "where p.cid = c.id and p.id=pd.pid and pd.lid=l.id and pd.saleid=s.id and sid=? ";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, sid);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Product p = new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getInt(7));
                p.setPd(new ProductDetail(rs.getString("sellDate"), rs.getInt("amount"), rs.getDouble("price")));
                p.setLang(new Language(rs.getInt("lid"), rs.getString("language")));
                p.setC(new Category(rs.getInt("cid"), rs.getString("category")));
                p.setS(new Sale(rs.getInt("saleid"), rs.getInt("sale")));
                list.add(p);
            }
        } catch (SQLException e) {

        }
        return list;

    }

    public List<Product> searchByNameandCid(String txt, String cid) {
        List<Product> list = new ArrayList<>();
        String sql = "SELECT p.*, pd.*, l.language, c.category, s.sale\n"
                + "FROM Product p , ProductDetail pd, Language l, Category c, Sale s\n"
                + " where p.cid = c.id and p.id=pd.pid and pd.lid=l.id and pd.saleid=s.id and [name] like N'%" + txt + "%' ";
        if (!cid.equals("0")) {
            sql += " and p.cid=" + cid;
        }
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Product p = new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getInt(7));
                p.setPd(new ProductDetail(rs.getString("sellDate"), rs.getInt("amount"), rs.getDouble("price")));
                p.setLang(new Language(rs.getInt("lid"), rs.getString("language")));
                p.setC(new Category(rs.getInt("cid"), rs.getString("category")));
                list.add(p);
            }
        } catch (SQLException e) {

        }
        return list;

    }

    public List<Product> searchByName(String txt) {
        List<Product> list = new ArrayList<>();
        String sql = "SELECT p.*, pd.*, l.language, c.category, s.sale\n"
                + "FROM Product p , ProductDetail pd, Language l, Category c, Sale s\n"
                + " where p.cid = c.id and p.id=pd.pid and pd.lid=l.id and pd.saleid=s.id and [name] like N'%" + txt + "%' ";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Product p = new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getInt(7));
                p.setPd(new ProductDetail(rs.getString("sellDate"), rs.getInt("amount"), rs.getDouble("price")));
                p.setLang(new Language(rs.getInt("lid"), rs.getString("language")));
                p.setC(new Category(rs.getInt("cid"), rs.getString("category")));
                list.add(p);
            }
        } catch (SQLException e) {

        }
        return list;

    }

    public void deleteProduct(int pid, int lid) {
        String sql = "DELETE FROM [dbo].[ProductDetail]\n"
                + "      WHERE pid=? and lid=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, pid);
            st.setInt(2, lid);
            st.executeUpdate();
            String sql2 = "select count(pid) as[count] \n"
                    + "from ProductDetail where pid=?";
            PreparedStatement st2 = connection.prepareStatement(sql2);
            st2.setInt(1, pid);
            ResultSet checkP = st2.executeQuery();
            if (checkP.next()) {
                if (checkP.getInt("count") == 0) {
                    String sql4 = "DELETE FROM [dbo].[ProductGenres]\n"
                            + "      WHERE pid=?";
                    PreparedStatement st4 = connection.prepareStatement(sql4);
                    st4.setInt(1, pid);
                    st4.executeUpdate();

                    String sql3 = "DELETE FROM [dbo].[Product]\n"
                            + "      WHERE id=?";
                    PreparedStatement st3 = connection.prepareStatement(sql3);
                    st3.setInt(1, pid);
                    st3.executeUpdate();

                }
            }
        } catch (SQLException e) {

        }
    }

    public void deleteGenres(String gid) {
        String sql = "DELETE FROM [dbo].[ProductGenres]\n"
                + "      WHERE gid=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, gid);
            st.executeUpdate();
            String sql2 = "DELETE FROM [dbo].[Genres]\n"
                    + "      WHERE id=?";
            PreparedStatement st2 = connection.prepareStatement(sql2);
            st2.setString(1, gid);
            st2.executeUpdate();
        } catch (SQLException e) {

        }

    }

    public Genres checkGenres(String genres) {
        String sql = " SELECT *\n"
                + "  FROM [dbo].[Genres]\n"
                + "  Where [genres]= ? ";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, genres);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                return new Genres(rs.getInt(1),
                        rs.getString(2));
            }
        } catch (SQLException e) {

        }
        return null;

    }

    public void addGenres(String name) {
        String sql = "INSERT INTO [dbo].[Genres]\n"
                + "           ([genres])\n"
                + "     VALUES\n"
                + "           (?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, name);
            st.executeUpdate();

        } catch (SQLException e) {

        }

    }

    public void addProduct(Product p,
            int lid, String saleid, String sellDate, String amount, String price) {
        String sql = "INSERT INTO [dbo].[Product]\n"
                + "           ([name]\n"
                + "           ,[img]\n"
                + "           ,[title]\n"
                + "           ,[description]\n"
                + "           ,[cid]\n"
                + "           ,[sid])\n"
                + "     VALUES\n"
                + "                                     (?,?,?,?,?,?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, p.getName());
            st.setString(2, p.getImg());
            st.setString(3, p.getTitle());
            st.setString(4, p.getDescription());
            st.setInt(5, p.getCid());
            st.setInt(6, p.getSid());
            st.executeUpdate();

            String sql3 = "select top 1 id\n"
                    + "from Product \n"
                    + "order by id desc";
            PreparedStatement st3 = connection.prepareStatement(sql3);
            ResultSet rs = st3.executeQuery();
            if (rs.next()) {
                int pid = rs.getInt("id");
                String sql4 = "INSERT INTO [dbo].[ProductDetail]\n"
                        + "           ([pid]\n"
                        + "           ,[lid]\n"
                        + "           ,[saleid]\n"
                        + "           ,[sellDate]\n"
                        + "           ,[amount]\n"
                        + "           ,[price])\n"
                        + "     VALUES\n"
                        + "                             (?,?,?,?,?,?)";
                PreparedStatement st4 = connection.prepareStatement(sql4);
                st4.setInt(1, pid);
                st4.setInt(2, lid);
                st4.setString(3, saleid);
                st4.setString(4, sellDate);
                st4.setString(5, amount);
                st4.setString(6, price);
                st4.executeUpdate();

                List<Genres> listG = p.getGenres();
                for (Genres i : listG) {
                    String sql2 = "INSERT INTO [dbo].[ProductGenres]\n"
                            + "           ([pid]\n"
                            + "           ,[gid])\n"
                            + "     VALUES\n"
                            + "           (?,?)";
                    PreparedStatement st2 = connection.prepareStatement(sql2);
                    st2.setInt(1, pid);
                    st2.setInt(2, i.getId());
                    st2.executeUpdate();
                }
            }
        } catch (SQLException e) {

        }
    }

    public void editProduct(Product p,
            int lid, String saleid, String amount, String price) {
        String sql = "UPDATE [dbo].[Product]\n"
                + "   SET [name] = ?\n"
                + "      ,[img] = ?\n"
                + "      ,[title] = ?\n"
                + "      ,[description] = ?\n"
                + "      ,[cid] = ?\n"
                + "      ,[sid] = ?\n"
                + " WHERE id=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, p.getName());
            st.setString(2, p.getImg());
            st.setString(3, p.getTitle());
            st.setString(4, p.getDescription());
            st.setInt(5, p.getCid());
            st.setInt(6, p.getSid());
            st.setInt(7, p.getId());
            st.executeUpdate();

            String sql4 = "UPDATE [dbo].[ProductDetail]\n"
                    + "   SET [lid] = ?\n"
                    + "      ,[saleid] = ?\n"
                    + "      ,[amount] = ?\n"
                    + "      ,[price] = ?\n"
                    + " WHERE pid=?";
            PreparedStatement st4 = connection.prepareStatement(sql4);
            st4.setInt(1, lid);
            st4.setString(2, saleid);
            st4.setString(3, amount);
            st4.setString(4, price);
            st4.setInt(5, p.getId());
            st4.executeUpdate();
            List<Genres> listG = p.getGenres();
            for (Genres i : listG) {
                String sql2 = "UPDATE [dbo].[ProductGenres]\n"
                        + "   SET [gid] = ?\n"
                        + " WHERE [pid] = ?";
                PreparedStatement st2 = connection.prepareStatement(sql2);
                st2.setInt(2, i.getId());
                st2.setInt(1, p.getId());
                st2.executeUpdate();
            }
        } catch (SQLException e) {

        }
    }

    public List<Sale> getSale() {
        List<Sale> list = new ArrayList<>();
        String sql = "SELECT [id]\n"
                + "      ,[sale]\n"
                + "  FROM [dbo].[Sale]";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                list.add(new Sale(rs.getInt(1), rs.getInt(2)));
            }
        } catch (SQLException e) {
        }
        return list;
    }

    public static void main(String[] args) {
        DAO dao = new DAO();
//        List<Product> p = dao.searchByNameandCid("hi", "3");
        AccountDetail a = dao.getAccDetail(1);
        System.out.println(a.getAddress());
//        for (Product product : p) {
//            System.out.println(product);
//        }
    }
}
