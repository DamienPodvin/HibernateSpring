package fr.formation.inti.dao;

import java.util.List;

import fr.formation.inti.entities.User;

public interface IUserDao {
	
public List<User> getAll();
	
	public void persist(User e );
	
	public Integer save(User e);
	
	public void update(User e);
	
	public void delete(User e);
	
	public void deleteByID(Integer id);
	
	public User findById(Integer id);
	
	public void close();

}
