/**
 * 
 */
package com.vaction;

import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.neo4j.graphdb.DynamicLabel;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Transaction;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;
import org.neo4j.graphdb.schema.IndexCreator;
import org.neo4j.graphdb.schema.IndexDefinition;
import org.neo4j.graphdb.schema.Schema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.config.Neo4jConfiguration;
import org.springframework.data.neo4j.conversion.Result;
import org.springframework.data.neo4j.core.GraphDatabase;
import org.springframework.data.neo4j.support.Neo4jTemplate;
import org.springframework.data.neo4j.support.typerepresentation.TypeRepresentationStrategyFactory;

import com.vaction.domain.Action;
import com.vaction.domain.Pattern;
import com.vaction.repository.PatternRepository;

/**
 * @author balanp
 *
 */
@SpringBootApplication
public class Application implements CommandLineRunner {
	
	@Configuration
	@EnableNeo4jRepositories(basePackages="com.vaction.repository")
	static class ApplicationConfig extends Neo4jConfiguration {
//		private static final String DB_PATH = "C:/Users/balanp.ANALYTICS/main/vAction/database";
		private static final String DB_PATH = "C:/Users/balanp.ANALYTICS/main/vAction/db2";

		public ApplicationConfig() {
			setBasePackage("com.vaction.domain");
		}
		
		@Bean
		GraphDatabaseService graphDatabaseService() {
			return new GraphDatabaseFactory().newEmbeddedDatabase(DB_PATH);
		}
		
//		 @Override
//		    public TypeRepresentationStrategyFactory typeRepresentationStrategyFactory() {
//		        return new TypeRepresentationStrategyFactory(
//		                    graphDatabase(),
//		                    TypeRepresentationStrategyFactory.Strategy.Indexed);
//		    }
	}
	
	@Autowired
	PatternRepository patternRepository;
	
	@Autowired
	GraphDatabase graphDb;
	
	@Autowired
	Neo4jTemplate template;
	
	@Autowired
	GraphDatabaseService graphDbService;
	
	@Override
	public void run(String... args) throws Exception {
		Transaction tx = graphDb.beginTx();
		try {
			
//			Schema schema = graphDbService.schema();
//			IndexDefinition indexDefinition = schema.indexFor(DynamicLabel.label("Pattern")).on("__type__").create();	
//			schema.awaitIndexOnline( indexDefinition, 100, TimeUnit.SECONDS);
			
//			String voiceCmd = StringUtils.arrayToDelimitedString(args, " ");
//			String voiceCmd = "what about swiss frank";
			String voiceCmd = "open skype nah. repede am dzis!";
//			String voiceCmd = "what is the exchange rate for rouble";
			
//			Pattern aaa = new Pattern();
//			aaa.setValue("TEST PATTERN");
//			patternRepository.save(aaa);
			
//			aaa = new Pattern();
//			aaa.setValue("open skype");
//			patternRepository.save(aaa);
			
			Result<Pattern> result2 = patternRepository.findAll();
			for (Pattern pt : result2) {
				System.out.println(pt.toString() + ": " + pt.getId() + ", " + pt.getValue());
			}
			
			Long patternsCnt = patternRepository.count();
			System.out.println("Patterns found: " + patternsCnt);
			
			Long actionCnt = template.count(Action.class);
			System.out.println("Actions found: " + actionCnt);

			Pattern foundPattern = patternRepository.findPattern(voiceCmd);
			if (foundPattern != null) {
				System.out.println("Repo has found: " + foundPattern +  ": " + foundPattern.getId() + ", " + foundPattern.getValue());
			}

			Result<Pattern> result = patternRepository.query("MATCH (pt:Pattern) WHERE '" + voiceCmd + "' =~ (pt.value+'(\\\\s.*)') RETURN pt", null);
			Iterator<Pattern> it = result.iterator();
			System.out.println("Found: " + result.toString());
			while (it.hasNext()) {
				Pattern nextPt = it.next();
				System.out.println(nextPt.toString() + ": " + nextPt.getId() + ", " + nextPt.getValue());
			}

			System.out.println("graphDatabaseService: " + graphDbService.toString());
			org.neo4j.graphdb.Result res = graphDbService.execute("MATCH (pt:Pattern)-[rel]-(to_node) WHERE '" + voiceCmd + "' =~ (pt.value+'(\\\\s.*)') RETURN labels(pt) as type, pt, rel, labels(to_node) as type2, to_node");				
			System.out.println(res.resultAsString());
			
			tx.success();
		} finally {
			tx.close();
		}
	}
	
	/**
	 * Start application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
}
