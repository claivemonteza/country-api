package com.application.service;

import java.util.List;

public interface IService<T>{

	public T save(T t);
	public T edit(T t);
	public void delete(Long id);
	public T get(Long t);
	public List<T> list();
}
