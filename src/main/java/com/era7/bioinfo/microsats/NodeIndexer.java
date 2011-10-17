/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era7.bioinfo.microsats;

import com.era7.bioinfo.microsats.nodes.ProjectNode;
import com.era7.bioinfo.microsats.nodes.SequenceNode;
import org.neo4j.graphdb.Transaction;

/**
 *
 * @author Pablo Pareja Tobes <ppareja@era7.com>
 */
public class NodeIndexer {
    
    protected MicrosatellitesManager manager;
    
    
    public NodeIndexer(MicrosatellitesManager microsatManager){
        manager = microsatManager;
    }
    
    
    public void indexProjectByName(ProjectNode node,    
                                    Transaction txn,
                                    boolean commitTxn){
        
        manager.getProjectNameIndex().add(node.getNode(), ProjectNode.PROJECT_NAME_INDEX, node.getName());
        if(commitTxn){
            txn.success();
            txn.finish();
        }        
    }
    
    public void indexSequenceById(SequenceNode node,    
                                    Transaction txn,
                                    boolean commitTxn){
        
        manager.getSequenceIdIndex().add(node.getNode(), SequenceNode.SEQUENCE_ID_INDEX, node.getId());
        if(commitTxn){
            txn.success();
            txn.finish();
        }        
    }
    
}
