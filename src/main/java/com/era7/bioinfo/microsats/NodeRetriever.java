/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era7.bioinfo.microsats;

import com.era7.bioinfo.microsats.nodes.ProjectNode;
import com.era7.bioinfo.microsats.nodes.RepetitionLengthNode;
import com.era7.bioinfo.microsats.nodes.RepetitionNode;
import com.era7.bioinfo.microsats.nodes.SequenceNode;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.index.IndexHits;

/**
 *
 * @author Pablo Pareja Tobes <ppareja@era7.com>
 */
public class NodeRetriever {
    
    protected MicrosatellitesManager manager;
    
    
    public NodeRetriever(MicrosatellitesManager microsatManager){
        manager = microsatManager;
    }
        
    
    public ProjectNode getProjectByName(String version){
        
        IndexHits<Node> hits = manager.getProjectNameIndex().get(ProjectNode.PROJECT_NAME_INDEX, version);
        
        if(hits.hasNext()){
            return new ProjectNode(hits.getSingle());
        }else{
            return null;
        }
    }    
    
    public RepetitionNode getRepetitionByString(String string){
        
        IndexHits<Node> hits = manager.getRepetitionStringIndex().get(RepetitionNode.REPETITION_STRING_INDEX, string);
        
        if(hits.hasNext()){
            return new RepetitionNode(hits.getSingle());
        }else{
            return null;
        }
    }
    
    public SequenceNode getSequenceById(String seqId){
        
        IndexHits<Node> hits = manager.getSequenceIdIndex().get(SequenceNode.SEQUENCE_ID_INDEX, seqId);
        
        if(hits.hasNext()){
            return new SequenceNode(hits.getSingle());
        }else{
            return null;
        }
    }
    
    public RepetitionLengthNode getRepetitionLengthByValue(int value){
        
        IndexHits<Node> hits = manager.getRepetitionLengthValueIndex().get(RepetitionLengthNode.REPETITION_LENGTH_VALUE_INDEX, value);
        
        if(hits.hasNext()){
            return new RepetitionLengthNode(hits.getSingle());
        }else{
            return null;
        }
    }
    
    
}
