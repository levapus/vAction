/**
 * 
 */
package com.vaction.repository;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.repository.CrudRepository;

import com.vaction.domain.Pattern;


/**
 * @author balanp
 *
 */
public interface PatternRepository extends GraphRepository<Pattern>{
	
	@Query("MATCH (pt:Pattern) WHERE {0} =~ (pt.value+'(\\\\s.*)') RETURN pt")
	Pattern findPattern(String voiceCmd);
}
