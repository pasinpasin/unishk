package com.unishk.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;



import com.unishk.entity.Fakulteti;

public interface FakultetiRepository extends CrudRepository<Fakulteti, Integer> {

	@Query("select new com.unishk.entity.Fakulteti(f.id, f.emertimi) from Fakulteti f order by f.emertimi asc")
	public List<Fakulteti> getFakultete();
	
	@Query("select f from Fakulteti f where f.emertimi like %?1%")
	public List<Fakulteti> findAll(String keyword);
	
	
	
	

}
