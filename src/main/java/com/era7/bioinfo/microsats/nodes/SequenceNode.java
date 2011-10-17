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
public class SequenceNode extends BasicEntity{

    public static final String NODE_TYPE = SequenceNode.class.getCanonicalName();
    public static final String SEQUENCE_ID_INDEX = "sequence_id_index";

    public static final String SEQUENCE_PROPERTY = "sequence";
    public static final String LENGTH_PROPERTY = "length";
    public static final String GENE_PROPERTY = "gene";
    public static final String ID_PROPERTY = "id";


    public SequenceNode(Node n){
        super(n);
    }

    public String getSequence(){    return String.valueOf(node.getProperty(SEQUENCE_PROPERTY));}
    public int getLength(){    return Integer.parseInt(String.valueOf(node.getProperty(LENGTH_PROPERTY)));}
    public String getGene(){    return String.valueOf(node.getProperty(GENE_PROPERTY)); }
    public String getId(){  return String.valueOf(node.getProperty(ID_PROPERTY));}


    public void setSequence(String value){  node.setProperty(SEQUENCE_PROPERTY, value);}
    public void setLength(int value){  node.setProperty(LENGTH_PROPERTY, String.valueOf(value));}
    public void setGene(String value){  node.setProperty(GENE_PROPERTY, value);}
    public void setId(String value){    node.setProperty(ID_PROPERTY, value);}


    @Override
    public int hashCode(){
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof SequenceNode){
            SequenceNode other = (SequenceNode) obj;
            return this.node.equals(other.node);
        }else{
            return false;
        }
    }

    @Override
    public String toString(){
        return "sequence = " + getSequence() + "\n" +
                "length = " + getLength() + "\n" + 
                "gene = " + getGene() + "\n" +
                "id = " + getId();
    }

}
