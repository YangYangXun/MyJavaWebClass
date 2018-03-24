package com.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

public class UsersDao implements IDao<User>{

	private DataSource dataSource;
	
	@Override
	public boolean selectForObject(User user) {
		// TODO Auto-generated method stub
		//透過DataSource要一條連接物件(具有開啟)
				boolean r=false;
				try {
					Connection connection=dataSource.getConnection();
					//設定查詢敘述(採用參數寫法預防SQL Injection)
					String sql="select count(*) as counter from users where username=? and password=?";
					PreparedStatement st=connection.prepareStatement(sql);
					//設定參數值
					st.setString(1,user.getUserName() );
					st.setString(2, user.getPassword());
					ResultSet rs=st.executeQuery();
					//判斷是否有紀錄
					if(rs.next())
					{
						if(rs.getInt("counter")>0)
						{
							//會員
							r=true;
						}
					}
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return r;
	}

	@Override
	public User selectForSingleObject(Object key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> selectForList(Object key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setDataSource(DataSource dataSource) {
		// TODO Auto-generated method stub
		this.dataSource = dataSource;
	}

}
