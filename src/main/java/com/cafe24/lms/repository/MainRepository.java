package com.cafe24.lms.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cafe24.inheritance.domain.Item;


public interface MainRepository extends JpaRepository<Item, Long> {
	
	// @Modifying  //벌크성 update, delete Query
	// @Query( value="update User u set u.name=:name where u.no=:no", nativeQuery=false )
	// int update(@Param("name") String name, @Param("no") Long no);

//	@Modifying  //벌크성 update, delete Query
//	@Query( value="update User u set u.name=:#{#user.name }, u.gender=:#{#user.gender } where u.no=:#{#user.no }", nativeQuery=false )
//	int update(@Param("user") User user);

//	@Query(value = "select * from Item a ,Category c where a.cateno = c.no", nativeQuery = true)
//	List<Item> findAllItem();	

	@Modifying  //벌크성 update, delete Query
	@Query( value="update Item i set i.state=:#{#item.state } where i.id=:#{#item.id }", nativeQuery=false )
	int update(@Param("item") Item item);
	
	@Query(value = "select i.state from Item i where i.ITEM_ID = :item_id",nativeQuery = true)
	String findwant(@Param("item_id") Long item_id);
	
//	@Query("select it from Item it where it.ITEM_ID > :startNo")
//	Page<Item> findAllByStartNo(@Param("startNo") int startNo, Pageable pageable);
	
	
}