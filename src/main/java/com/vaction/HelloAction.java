/**
 * 
 */
package com.vaction;

//import java.util.List;
//import java.util.Map;
//import java.util.Map.Entry;
//
//import org.neo4j.graphdb.GraphDatabaseService;
//import org.neo4j.graphdb.Node;
//import org.neo4j.graphdb.Relationship;
//import org.neo4j.graphdb.Result;
//import org.neo4j.graphdb.Transaction;
//import org.neo4j.graphdb.factory.GraphDatabaseFactory;
//import org.springframework.util.StringUtils;

/**
 * @author balanp
 *
 */
public class HelloAction {
//	private static final String DB_PATH = "C:/Users/balanp.ANALYTICS/main/vAction/database";
//	private GraphDatabaseService db;
//	private String regex;
//
//	/**
//	 * @param args
//	 */
////	public static void main(String[] args) {
////		HelloAction app = new HelloAction();
////		app.startDB();
////		app.getRegex(args);
////		app.searchAction();
////		app.shutdownDB();
////	}
//
//	private void searchAction() {
//		if (regex != null) {
//			try (Transaction tx = db.beginTx()) {
//				Result res = db.execute("MATCH (pt:pattern)-[rel]-(to_node) WHERE '" + regex + "' =~ (pt.value+'(.*)') RETURN labels(pt) as type, pt, rel, labels(to_node) as type2, to_node;");				
//				System.out.println(res.resultAsString());
//				
////				List<String> l = res.columns();
////				System.out.println(res.toString());
//				
//				while (res.hasNext()) {
//			         Map<String, Object> row = res.next();
//			         for (String key : res.columns()) {
//			        	 Node node = (Node) row.get(key);
//			             System.out.printf("%s = %s%n", key, node);
//			             System.out.println();
//
//			             if(node != null) {
//				             System.out.printf("value:", node.getProperty("value"));
//			             }
//			         }
//				}
//				
//			}
//		}
//	}
//
//	private void getRegex(String[] args) {
//		regex = StringUtils.arrayToDelimitedString(args, " ");
//		regex = "what about swiss frank";
////		regex = "what is the exchange rate for rouble";
//	}
//
//	private void shutdownDB() {
//		db.shutdown();
//	}
//	
//	private void startDB() {
//		db = new GraphDatabaseFactory().newEmbeddedDatabase(DB_PATH);
//		registerShutdownHook(db);
//	}
//
//	private static void registerShutdownHook( final GraphDatabaseService graphDb ) {
//	    // Registers a shutdown hook for the Neo4j instance so that it
//	    // shuts down nicely when the VM exits (even if you "Ctrl-C" the
//	    // running application).
//	    Runtime.getRuntime().addShutdownHook( new Thread() {
//	        @Override
//	        public void run() {
//	            graphDb.shutdown();
//	        }
//	    } );
//	}
//
//	/**
//	 * @return the regex
//	 */
//	public String getRegex() {
//		return regex;
//	}
//
//	/**
//	 * @param regex the regex to set
//	 */
//	public void setRegex(String regex) {
//		this.regex = regex;
//	}
}
