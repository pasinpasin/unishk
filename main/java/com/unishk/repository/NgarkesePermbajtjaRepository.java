package com.unishk.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.unishk.entity.NgarkesePermbajtja;


public interface NgarkesePermbajtjaRepository extends CrudRepository<NgarkesePermbajtja, Integer> {
	
	@Query("SELECT n FROM Ngarkesepermbajtja n WHERE n.ngarkese_id = :id")
    public NgarkesePermbajtja findNgarkesePermbajtjaById(@Param("id") Integer id);


}
