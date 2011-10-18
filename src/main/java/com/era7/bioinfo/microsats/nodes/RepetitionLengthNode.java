/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era7.bioinfo.microsats.nodes;

import com.era7.bioinfo.bioinfoneo4j.BasicEntity;
import com.era7.bioinfo.microsats.relationships.RepetitionLengthRel;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.neo4j.graphdb.Direction;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;

/**
 *
 * @author Pablo Pareja Tobes <ppareja@era7.com>
 */
public class RepetitionLengthNode extends BasicEntity{

    public static final String NODE_TYPE = RepetitionLengthNode.class.getCanonicalName();
    public static final String REPETITION_LENGTH_VALUE_INDEX = "repetition_length_value_index";

    public static final String VALUE_PROPERTY = "value";


    public RepetitionLengthNode(Node n){
        super(n);
    }

    public int getValue(){    return Integer.parseInt(String.valueOf(node.getProperty(VALUE_PROPERTY)));}


    public void setValue(int value){  node.setProperty(VALUE_PROPERTY, String.valueOf(value));}

    
    public List<RepetitionNode> getRepetitions(){
        LinkedList<RepetitionNode> list = new LinkedList<RepetitionNode>();
        Iterator<Relationship> iterator = node.getRelationships(new RepetitionLengthRel(null), Direction.INCOMING).iterator();
        while(iterator.hasNext()){
            list.add(new RepetitionNode(iterator.next().getStartNode()));
        }
        return list;
    }

    @Override
    public int hashCode(){
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof RepetitionLengthNode){
            RepetitionLengthNode other = (RepetitionLengthNode) obj;
            return this.node.equals(other.node);
        }else{
            return false;
        }
    }

    @Override
    public String toString(){
        return "name = " + getValue();
    }

}
