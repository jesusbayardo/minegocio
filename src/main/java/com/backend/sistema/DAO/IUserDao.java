package com.backend.sistema.DAO;


import java.sql.Timestamp;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;



import com.backend.sistema.models.TblUser;





public interface IUserDao extends JpaRepository<TblUser, Integer>{

	
	
	
	
	
	@Query("select u from TblUser u where u.userLogin=?1")
	public TblUser findByUser(String username);
	
	
	
	
	
	
	


	
	
	
	
	
	
	
	
	
	
	

	@Query(value = "SELECT * FROM tbl_users where id_rol=2 order by user_create ASC"
			,nativeQuery = true)
	public Page< TblUser>  getAllUsers(Pageable pageable);
	
	
	@Query(value = "SELECT COUNT(u) FROM tbl_users u",nativeQuery = true)
	public int countUsuarios();
	
	
	
	
	
	
	@Query(value = "SELECT * FROM tbl_users where id_rol=2 and create_at>=?1 order by user_create ASC"
			,nativeQuery = true)
	public Page< TblUser>  getUserBYdate(Pageable pageable, Timestamp fecha);
	
	
	
	
}
