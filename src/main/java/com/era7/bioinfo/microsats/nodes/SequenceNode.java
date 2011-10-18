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
