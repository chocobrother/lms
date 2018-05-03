package com.cafe24.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cafe24.lms.domain.Rent;

@Repository
public interface RentRepository extends JpaRepository<Rent, Long> {
	
	// @Modifying  //벌크성 update, delete Query
	// @Query( value="update User u set u.name=:name where u.no=:no", nativeQuery=false )
	// int update(@Param("name") String name, @Param("no") Long no);

//	@Modifying  //벌크성 update, delete Query
//	@Query( value="update User u set u.name=:#{#user.name }, u.gender=:#{#user.gender } where u.no=:#{#user.no }", nativeQuery=false )
//	int update(@Param("user") User user);

//	@Query(value = "select * from Item a ,Category c where a.cateno = c.no", nativeQuery = true)
//	List<Item> findAllItem();
	
	@Query(value = "select * from Rent r where r.ITEM_ID = :item_id",nativeQuery = true)
	Rent findwant(@Param("item_id") Long item_id);
	
	@Query(value = "select r.no from Rent r where r.ITEM_ID = :no and r.USER_ID = :id", nativeQuery = true)
	Long findUsing(@Param("no") Long no, @Param("id")Long id );
	
	
}