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
	public boolean selectForObject(User object) {
		// TODO Auto-generated method stub
		//�z�LDataSource�n�@���s������(�㦳�}��)
				boolean r=false;
				try {
					Connection connection=dataSource.getConnection();
					//�]�w�d�߱ԭz(�ĥΰѼƼg�k�w��SQL Injection)
					String sql="select count(*) as counter from users where username=? and password=?";
					PreparedStatement st=connection.prepareStatement(sql);
					ResultSet rs=st.executeQuery();
					//�P�_�O�_������
					if(rs.next())
					{
						if(rs.getInt("counter")>0)
						{
							//�|��
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