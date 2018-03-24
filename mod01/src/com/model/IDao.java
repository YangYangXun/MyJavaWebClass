package com.model;

import java.util.List;

import javax.sql.DataSource;

//�إߪx��DAO
public interface IDao<T> {
	//�d�߬O�_���o�@������
	public boolean selectForObject(T object);
	//�d�߳浧����
	public T selectForSingleObject(Object key);
	//�d�ߤ@�����
	public List<T> selectForList(Object key);
	//�`�J��ƨӷ�
	public void setDataSource(DataSource dataSource);

}
