/*
 * Copyright (C) 2011  "Oh no sequences!"
 *
 *
 * This is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>
 */
package com.era7.bioinfo.microsats;

import com.era7.bioinfo.microsats.nodes.ProjectNode;
import com.era7.bioinfo.microsats.nodes.RepetitionLengthNode;
import com.era7.bioinfo.microsats.nodes.RepetitionNode;
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
    
    
    public void indexProjectByName(ProjectNode node,Transaction txn, boolean commitTxn){
        
        manager.getProjectNameIndex().add(node.getNode(), ProjectNode.PROJECT_NAME_INDEX, node.getName());
        if(commitTxn){
            txn.success();
            txn.finish();
        }        
    }
    
    public void indexSequenceById(SequenceNode node, Transaction txn, boolean commitTxn){
        
        manager.getSequenceIdIndex().add(node.getNode(), SequenceNode.SEQUENCE_ID_INDEX, node.getId());
        if(commitTxn){
            txn.success();
            txn.finish();
        }        
    }
    
    public void indexRepetitionLengthByValue(RepetitionLengthNode node, Transaction txn, boolean commitTxn){
        
        manager.getRepetitionLengthValueIndex().add(node.getNode(), RepetitionLengthNode.REPETITION_LENGTH_VALUE_INDEX, node.getValue());
        if(commitTxn){
            txn.success();
            txn.finish();
        }        
    }
    
    public void indexRepetitionByString(RepetitionNode node, Transaction txn, boolean commitTxn){
        
        manager.getRepetitionStringIndex().add(node.getNode(), RepetitionNode.REPETITION_STRING_INDEX, node.getString());
        if(commitTxn){
            txn.success();
            txn.finish();
        }        
    }
    
}
