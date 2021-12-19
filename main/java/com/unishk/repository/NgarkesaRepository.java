package com.unishk.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.unishk.entity.Ngarkesa;
import com.unishk.entity.NgarkesePermbajtja;


public interface NgarkesaRepository extends CrudRepository<Ngarkesa, Integer> {
	
	 @Query("SELECT n FROM Ngarkesa n WHERE n.vitiakademik = :vit")
	    public NgarkesePermbajtja findNgarkesaByViti(@Param("vit") String vit);

}
