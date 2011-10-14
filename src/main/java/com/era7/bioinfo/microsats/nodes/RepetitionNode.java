/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era7.bioinfo.microsats.nodes;

import com.era7.bioinfo.bioinfoneo4j.BasicEntity;
import org.neo4j.graphdb.Node;

/**
 *
 * @author Pablo Pareja Tobes <ppareja@era7.com>
 */
public class RepetitionNode extends BasicEntity{

    public static final String NODE_TYPE = RepetitionNode.class.getCanonicalName();
    public static final String REPETITION_STRING_INDEX = "repetition_string_index";

    public static final String STRING_PROPERTY = "string";


    public RepetitionNode(Node n){
        super(n);
    }

    public String getString(){    return String.valueOf(node.getProperty(STRING_PROPERTY));}


    public void setString(String value){  node.setProperty(STRING_PROPERTY, value);}


    @Override
    public int hashCode(){
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof RepetitionNode){
            RepetitionNode other = (RepetitionNode) obj;
            return this.node.equals(other.node);
        }else{
            return false;
        }
    }

    @Override
    public String toString(){
        return "string = " + getString();
    }

}
