package com.unishk.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.unishk.entity.PlanPermbajtja;

public interface PlanPermbajtjaRepository extends CrudRepository<PlanPermbajtja, Integer> {
    
    
    
    @Query("SELECT p FROM PlanPermbajtja p WHERE p.viti = :vit")
    public PlanPermbajtja findPlanPermbajtjaByViti(@Param("vit") String vit);
    
  // @Query("SELECT sum(p.kredite + 0.0) FROM PlanPermbajtja p wherep.viti= group by p.viti")
    //public String TotaliKredite(@Param("vit") String vit, @Param("plan_id") int plan_id);
 

}
