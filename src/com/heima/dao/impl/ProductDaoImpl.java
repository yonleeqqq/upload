package com.heima.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.heima.bean.Product;
import com.heima.dao.ProductDao;
import com.heima.utils.JDBCUtils;

public class ProductDaoImpl implements ProductDao {

	public void save(Product product) {
		// get connect
		Connection conn = JDBCUtils.getConnection();
		// prepare sql
		String sql = " INSERT INTO `product`   " + " VALUES (NULL,         "
				+ "	?,?,?,?,?,?);          ";
		// get prepareStatement
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			// set param
			ps.setString(1, product.getName());
			ps.setDouble(2, product.getPrice());
			ps.setInt(3, product.getPnum());
			ps.setString(4, product.getDescription());
			ps.setString(5, product.getType());
			ps.setString(6, product.getImgurl());
			// execute sql
			int rowCount = ps.executeUpdate();
			if (rowCount != 1) {
				throw new RuntimeException("插入商品失败！");
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("插入商品失败！");
		} finally {
			// close connect
			JDBCUtils.close(conn, ps, null);
		}

	}

	public List<Product> getAllProduct() {
		List<Product> list = new ArrayList<Product>();
		// get conn
		Connection conn = JDBCUtils.getConnection();
		// prepare sql
		String sql = "select * from product";
		// get PreparedStatement
		PreparedStatement ps = null;
		ResultSet rs =null;
		try {
			ps = conn.prepareStatement(sql);
			// set params
			// execute query
			rs= ps.executeQuery();
			while(rs.next()){
				Product p = new Product();
				p.setName(rs.getString("name"));
				p.setPrice(rs.getDouble("price"));
				p.setPnum(rs.getInt("pnum"));
				p.setType(rs.getString("type"));
				p.setDescription(rs.getString("description"));
				p.setImgurl(rs.getString("imgurl"));
				p.setId(rs.getInt("id"));
				list.add(p);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查询商品数据失败");
		}finally{
			// close conn
			JDBCUtils.close(conn, ps, rs);
		}
	}

	public Product getProductById(int id) {
		//get Conn
		Connection conn = JDBCUtils.getConnection();
		//prepare sql
		String sql = "select * from product where id = ?";
		//get preparedStatement
		PreparedStatement ps=null;
		ResultSet rs = null;
		try {
			ps= conn.prepareStatement(sql);
			//set params
			ps.setInt(1, id);
			//execute query
			rs=ps.executeQuery();
			if(rs.next()){
				Product p = new Product();
				p.setName(rs.getString("name"));
				p.setPrice(rs.getDouble("price"));
				p.setPnum(rs.getInt("pnum"));
				p.setType(rs.getString("type"));
				p.setDescription(rs.getString("description"));
				p.setImgurl(rs.getString("imgurl"));
				p.setId(rs.getInt("id"));
				return p;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtils.close(conn, ps, rs);
		}
		
		//close conn
		return null;
	}

	public void update(Product product) {
		boolean flag = product.getImgurl()!=null;
		//get conn
		Connection conn = JDBCUtils.getConnection();
		//prepare sql
			String sql = 	" UPDATE `product`                    "+
							" SET                    "+
							"   `name` = ?,                  "+
							"   `price` = ?,	              "+
							"   `pnum` = ?,                  "+
							"   `description` = ?,    "+
							"   `type` = ?                  ";
			if(flag){
				sql+="  , `imgurl` = ?               "+
						" WHERE `id` = ?;                  ";
			}else{
				sql+=" WHERE `id` = ?;                  ";
			}
							
		//get preparedStatement
		PreparedStatement ps=null;
		try {
			ps= conn.prepareStatement(sql);
			//set params
			ps.setString(1, product.getName());
			ps.setDouble(2,product.getPrice());
			ps.setInt(3, product.getPnum());
			ps.setString(4,product.getDescription());
			ps.setString(5,product.getType());
			if(flag){
				ps.setString(6,product.getImgurl());
				ps.setInt(7,product.getId());
			}else{
				ps.setInt(6,product.getId());
			}
			//executeUpdate
			int count = ps.executeUpdate();
			if(count!=1){
				throw new RuntimeException("数据修改失败");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("数据修改失败");
		}finally{
			//close conn
			JDBCUtils.close(conn,ps,null);
		}	
	}

}
