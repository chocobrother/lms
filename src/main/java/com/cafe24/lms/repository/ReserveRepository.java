package com.cafe24.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cafe24.lms.domain.Reserve;

@Repository
public interface ReserveRepository extends JpaRepository<Reserve, Long> {
	
	// @Modifying  //벌크성 update, delete Query
	// @Query( value="update User u set u.name=:name where u.no=:no", nativeQuery=false )
	// int update(@Param("name") String name, @Param("no") Long no);

//	@Modifying  //벌크성 update, delete Query
//	@Query( value="update User u set u.name=:#{#user.name }, u.gender=:#{#user.gender } where u.no=:#{#user.no }", nativeQuery=false )
//	int update(@Param("user") User user);

//	@Query(value = "select * from Item a ,Category c where a.cateno = c.no", nativeQuery = true)
//	List<Item> findAllItem();
	
	@Query(value = "select r.no from Reserve r where r.ITEM_ID = :no and r.USER_ID = :id", nativeQuery = true)
	Long findUsing(@Param("no") Long no, @Param("id")Long id );
	
	
	
}