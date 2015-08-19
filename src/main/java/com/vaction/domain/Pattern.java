/**
 * 
 */
package com.vaction.domain;

import java.util.Set;

import org.neo4j.graphdb.Direction;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.neo4j.annotation.Fetch;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;
import org.springframework.data.neo4j.support.index.IndexType;

/**
 * @author balanp
 *
 */
@NodeEntity
//@TypeAlias("Pattern")
public class Pattern {
	@GraphId
	private Long id;
	
	//@Indexed(unique = true)
	private String value;
	
//	@Fetch
//	@RelatedTo(type="MAPPED_TO", direction=Direction.OUTGOING)
//	private Set<Action> actions;
//	
//	@Fetch
//	@RelatedTo(type="OPEN_CONTEXT", direction=Direction.OUTGOING)
//	private Context context;
	
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}

//	/**
//	 * @return the context
//	 */
//	public Context getContext() {
//		return context;
//	}
//
//	/**
//	 * @param context the context to set
//	 */
//	public void setContext(Context context) {
//		this.context = context;
//	}
//
//	/**
//	 * @return the actions
//	 */
//	public Set<Action> getActions() {
//		return actions;
//	}
//
//	/**
//	 * @param actions the actions to set
//	 */
//	public void setActions(Set<Action> actions) {
//		this.actions = actions;
//	}
}
