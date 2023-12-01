package Dao;

import java.util.ArrayList;

/* các phương thức truy vấn csdl */

public interface Dao_interface<T> {
 public int insert(T t);
 
 public int update(T t);
 
 public int delete(T t);
 
 public ArrayList<T> selectAll();
 
 public T selectByID(T t);
 
 public ArrayList<T> selectByCondition(String condition);
}
