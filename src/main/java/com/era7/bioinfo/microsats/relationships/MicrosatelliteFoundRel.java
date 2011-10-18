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
package com.era7.bioinfo.microsats.relationships;

import com.era7.bioinfo.bioinfoneo4j.BasicRelationship;
import org.neo4j.graphdb.Relationship;

/**
 *
 * @author Pablo Pareja Tobes <ppareja@era7.com>
 */
public class MicrosatelliteFoundRel extends BasicRelationship{

    public static final String NAME = "MICROSATELLITE_FOUND";
    
    public static final String START_POSITION_PROPERTY = "start_position";
    public static final String NUMBER_OF_REPETITIONS_PROPERTY = "number_of_repetitions";
    public static final String LENGTH_PROPERTY = "length";

    public MicrosatelliteFoundRel(Relationship rel){
        super(rel);
    }
    
    public int getLength(){    return Integer.parseInt(String.valueOf(relationship.getProperty(LENGTH_PROPERTY)));}
    public int getNumberOfRepetitions(){    return Integer.parseInt(String.valueOf(relationship.getProperty(NUMBER_OF_REPETITIONS_PROPERTY)));}
    public int getStartPosition(){    return Integer.parseInt(String.valueOf(relationship.getProperty(START_POSITION_PROPERTY)));}

    public void setLength(int value){  relationship.setProperty(LENGTH_PROPERTY, String.valueOf(value));}
    public void setNumberOfRepetitions(int value){  relationship.setProperty(NUMBER_OF_REPETITIONS_PROPERTY, String.valueOf(value));}
    public void setStartPosition(int value){  relationship.setProperty(START_POSITION_PROPERTY, String.valueOf(value));}
    
    
    @Override
    public String name() {
        return NAME;
    }
    
    @Override
    public String toString(){
        return "Start position = " + getStartPosition() + "\n"
                + "Number of repetitions = " + getNumberOfRepetitions() + "\n"
                + "Length = " + getLength();
    }

}

