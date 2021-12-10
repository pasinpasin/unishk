package com.unishk.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


import com.unishk.entity.Fakulteti;

public interface FakultetiRepository extends CrudRepository<Fakulteti, Integer> {

	@Query("select new com.unishk.entity.Fakulteti(f.id, f.emertimi) from Fakulteti f")
	public List<Fakulteti> getFakultete();
	
	

}
