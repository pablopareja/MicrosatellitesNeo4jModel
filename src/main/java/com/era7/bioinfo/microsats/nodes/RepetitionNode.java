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
