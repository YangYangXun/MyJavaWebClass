package com.model;

import java.util.List;

import javax.sql.DataSource;

//建立泛型DAO
public interface IDao<T> {
	//查詢是否有這一筆紀錄
	public boolean selectForObject(T object);
	//查詢單筆紀錄
	public T selectForSingleObject(Object key);
	//查詢一堆紀錄
	public List<T> selectForList(Object key);
	//注入資料來源
	public void setDataSource(DataSource dataSource);

}
