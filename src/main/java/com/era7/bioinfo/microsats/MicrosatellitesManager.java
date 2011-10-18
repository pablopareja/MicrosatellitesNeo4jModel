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

import com.era7.bioinfo.bioinfoneo4j.Neo4jManager;
import com.era7.bioinfo.microsats.nodes.ProjectNode;
import com.era7.bioinfo.microsats.nodes.RepetitionLengthNode;
import com.era7.bioinfo.microsats.nodes.RepetitionNode;
import com.era7.bioinfo.microsats.nodes.SequenceNode;
import java.util.HashMap;
import java.util.Map;
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
