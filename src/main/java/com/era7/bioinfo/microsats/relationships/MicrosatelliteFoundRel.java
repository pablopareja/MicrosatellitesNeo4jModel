/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
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

