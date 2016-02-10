package cbr;

import cbrrecommender.main.Recommender;
import datainterpretation.Symptoms;

public class GenerateQuery {
	
	
	public Recommender recom;
	
	
	public GenerateQuery(Double hoyde, Double vekt, Integer alder, Integer iq, Integer numCases){
		
	recom = new Recommender();	
	recom.loadengine();
	
	//InputAmalgam.setText("default function");
	
	String recomendation = recom.solveOuery(
			Symptoms.agentDum(iq), 
			Symptoms.agentOvervekt(hoyde, vekt),
			Symptoms.agentKortvokst(alder, hoyde),
			numCases);
	
	//System.out.print(recomendation);
	
	
	}
}
