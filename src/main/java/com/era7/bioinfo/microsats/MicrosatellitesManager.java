/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era7.bioinfo.microsats;

import com.era7.bioinfo.bioinfoneo4j.Neo4jManager;
import com.era7.bioinfo.microsats.nodes.ProjectNode;
import com.era7.bioinfo.microsats.nodes.RepetitionLengthNode;
import com.era7.bioinfo.microsats.nodes.RepetitionNode;
import com.era7.bioinfo.microsats.nodes.SequenceNode;
import java.util.HashMap;
import java.util.Map;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.index.Index;


/**
 *
 * @author Pablo Pareja Tobes <ppareja@era7.com>
 */
public class MicrosatellitesManager extends Neo4jManager{
        
    private static String PROVIDER_ST = "provider";
    private static String EXACT_ST = "exact";
    private static String LUCENE_ST = "lucene";
    private static String TYPE_ST = "type";
    
    
    //-----------------node indexes-----------------------
    private Index<Node> repetitionLengthValueIndex = null;
    private Index<Node> repetitionStringIndex = null;
    private Index<Node> projectNameIndex = null;
    private Index<Node> sequenceIdIndex = null;
    
    public MicrosatellitesManager(String dbFolder){
        
        super(dbFolder, true);
                
        Map<String,String> indexProps = new HashMap<String, String>();
        indexProps.put(PROVIDER_ST, LUCENE_ST);
        indexProps.put(TYPE_ST, EXACT_ST);
                
        //----------node indexes-----------
        repetitionLengthValueIndex = graphService.index().forNodes(RepetitionLengthNode.REPETITION_LENGTH_VALUE_INDEX, indexProps);
        repetitionStringIndex = graphService.index().forNodes(RepetitionNode.REPETITION_STRING_INDEX, indexProps);      
        projectNameIndex = graphService.index().forNodes(ProjectNode.PROJECT_NAME_INDEX,indexProps);
        sequenceIdIndex = graphService.index().forNodes(SequenceNode.SEQUENCE_ID_INDEX,indexProps);
        
    }
    
    public Index<Node> getRepetitionLengthValueIndex(){        
        return repetitionLengthValueIndex;
    }    
    public Index<Node> getRepetitionStringIndex(){        
        return repetitionStringIndex;
    }
    public Index<Node> getProjectNameIndex(){        
        return projectNameIndex;
    }
    public Index<Node> getSequenceIdIndex(){        
        return sequenceIdIndex;
    }
    
}
