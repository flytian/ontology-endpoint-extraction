package es.uma.khaos.ontology_endpoint.main;

import java.io.File;

import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyStorageException;

import es.uma.khaos.ontology_endpoint.explorer.Explorer;
import es.uma.khaos.ontology_endpoint.ontology.OntologyData;
import es.uma.khaos.ontology_endpoint.ontology.OntologyUtils;

public class BiomodelsMain {
	
	public static void main(String[] args) throws OWLOntologyCreationException, OWLOntologyStorageException {
		
		long timeStart, timeEnd;
		timeStart = System.currentTimeMillis();
		
		String endpoint = "http://www.ebi.ac.uk/rdf/services/biomodels/sparql";
		Explorer explorer = new Explorer(endpoint);
		
		OntologyData ontology = explorer.execute();
		OntologyUtils.buildOwlFile(ontology, new File("biomodels.owl"));
		
		timeEnd = System.currentTimeMillis();
		System.out.println("the task has taken "+ ( timeEnd - timeStart ) +" milliseconds");
		
	}

}
