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
import java.util.Set;
import java.util.stream.Collectors;
import model.OrderLine;

/**
 *
 * @author Nết
 */
public class OrderLineDAO extends DBContext {

    public List<OrderLine> getByProductModelIds(Set<Integer> ids) {
        List<OrderLine> result = new ArrayList<>();
        StringBuilder sql = new StringBuilder("SELECT p.id  , p.name, p.img, pd.price\n"
                + "FROM Product p, ProductDetail pd\n"
                + "          where p.id=pd.pid and p.id in (");
        if (ids == null || ids.isEmpty()) {
            return result;
        }
        sql.append(ids.stream().map(id -> "?").collect(Collectors.joining("\n,")));
        sql.append(");");
        try {
            PreparedStatement ps = connection.prepareStatement(sql.toString());
            Integer[] idsArr = ids.toArray(new Integer[0]);
            for (int i = 0; i < idsArr.length; i++) {
                Integer id = idsArr[i];
                ps.setInt(i + 1, id);
            }
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                OrderLine orderDetail = new OrderLine();
                orderDetail.setPid(rs.getInt(1));
                orderDetail.setName(rs.getString(2));
                orderDetail.setImg(rs.getString(3));
                orderDetail.setPrice(rs.getInt(4));
                orderDetail.setAmount(0);
                result.add(orderDetail);
            }
        } catch (SQLException e) {
        }
        return result;
    }

    public void insertOrderDetail(int oid, String pid, String amount, String detailtotal) {
        String sql = "INSERT INTO [dbo].[OrderLine]\n"
                + "           ([oid]\n"
                + "           ,[pid]\n"
                + "           ,[amount]\n"
                + "           ,[detailtotal])\n"
                + "     VALUES\n"
                + "           (?,?,?,?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, oid);
            st.setString(2, pid);
            st.setString(3, amount);
            st.setString(4, detailtotal);

            st.executeUpdate();
        } catch (SQLException e) {
        }
    }
//
//    public List<OrderLine> getOrderLines(int id) {
//        List<OrderLine> list = new ArrayList<>();
//        String sql = "SELECT p.id, pm.image, p.thumbnail, p.name, pm.variant, pm.sale_price, od.quantity, od.detail_total\n"
//                + "  FROM [OrderLine] od join [ProductModel] pm on od.product_model_id=pm.id join Product p on pm.product_id = p.id\n"
//                + "  WHERE order_id=?";
//        try {
//            PreparedStatement st = connection.prepareStatement(sql);
//            st.setInt(1, id);
//            ResultSet rs = st.executeQuery();
//            while (rs.next()) {
//                OrderLine od = new OrderLine();
//                od.setProductId(rs.getInt("id"));
//                od.setImage(rs.getString("image"));
//                od.setThumbnail(rs.getString("thumbnail"));
//                od.setProductName(rs.getString("name"));
//                od.setVariantName(rs.getString("variant"));
//                od.setSalePrice(rs.getInt("sale_price"));
//                od.setQuantity(rs.getInt("quantity"));
//                od.setDetailTotal(rs.getInt("detail_total"));
//                list.add(od);
//            }
//        } catch (SQLException e) {
//            System.out.println(e);
//        }
//        return list;
//      }

//    }
}
