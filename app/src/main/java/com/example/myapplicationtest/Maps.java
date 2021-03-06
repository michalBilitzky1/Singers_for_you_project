package com.example.myapplicationtest;

import com.example.myapplicationtest.Enums.EnumsSingers;
import com.example.myapplicationtest.SingersLogic.Priority;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Maps {

    private static Maps single_instance = null;
    HashMap<String, Double> priority = new HashMap<>();
    List<String> otherGenre = new ArrayList<>();
    List<String>otherTopic = new ArrayList<>();
    List<String>otherGoal = new ArrayList<>();
    public static int middleLoudness=0;
    public static int middleTempo=0;

     public Maps() {

    }

    public Map<String, Double> getMapPrio() {

        return priority;
    }

    public List<String> getSecondGenre() {

        return otherGenre;
    }

    public List<String> getSecondTopic() {

        return otherTopic;
    }

    public List<String> getSecondGoal() {

        return otherGoal;
    }

    public static Maps getInstance() {
        if (single_instance == null)
            single_instance = new Maps();

        return single_instance;
    }

    public HashMap<String, Double> PutInPriority(String prioLoudness, String prioTempo) {
        switch (EnumsSingers.valueOf(prioLoudness)) {
            case High:
                priority.put(prioLoudness, (double) 0);
                if (prioTempo.equals(EnumsSingers.Medium.getEnums())) {
                    priority.put(prioTempo, (double) 25);
                }
                if (prioTempo.equals(EnumsSingers.Low.getEnums())) {
                    priority.put(prioTempo, (double) 50);
                }
                break;
            case Medium:
                priority.put(prioLoudness, (double) 5);
                if (prioTempo.equals(EnumsSingers.High.getEnums())) {
                    priority.put(prioTempo, (double) 0);
                }
                if (prioTempo.equals(EnumsSingers.Low.getEnums())) {
                    priority.put(prioTempo, (double) 50);
                }
                break;
            case Low:
                priority.put(prioLoudness, (double) 10);
                if (prioTempo.equals(EnumsSingers.High.getEnums())) {
                    priority.put(prioTempo, (double) 0);
                }
                if (prioTempo.equals(EnumsSingers.Medium.getEnums())) {
                    priority.put(prioTempo, (double) 25);
                    //probably something else
                }
                break;

        }
        return priority;

    }

    public double[] PutInloudness(String loudness) {
        double numLoud[] = new double[2];
        switch (EnumsSingers.valueOf(loudness)) {
            case Weak:
                numLoud[0] = -16;
                break;
            case Normal:
                numLoud[0] = -32;
                numLoud[1] = -16;
                break;
            case Strong:
                numLoud[0] = -32;
        }
        return numLoud;
    }


    public void middleLoudness(String loudness) {

        switch (EnumsSingers.valueOf(loudness)) {
            case Weak:
                middleLoudness = -8;
                break;
            case Normal:
                middleLoudness=-24;
                break;
            case Strong:
                middleLoudness = -45;
                break;
        }

    }

    public void middleTempo(String tempo) {

        switch (EnumsSingers.valueOf(tempo)) {
            case Slow:
                middleTempo = 42;
                break;
            case Medium:
                middleTempo=128;
                break;
            case Fast:
                middleTempo=300;
                break;
        }

    }

    public double[] PutInTempo(String tempo) {
        double numTempo[] = new double[2];
        switch (EnumsSingers.valueOf(tempo)) {
            case Slow:
                numTempo[0] = 85;
                break;
            case Medium:
                numTempo[0] = 85;
                numTempo[1] = 170;
                break;
            case Fast:
                numTempo[0] = 170;
        }
        return numTempo;
    }

    public double PutInPercents(String whichPrio){
        double whichPercent = 0;
        switch (EnumsSingers.valueOf(whichPrio)){
            case Low:
                whichPercent = 0.3;
                break;
            case Medium:
                whichPercent = 0.7;

        }
        return whichPercent;
    }

    public void getFromQuery(List<String>coupleGenre,String whichList){
     if(whichList.equals("genre")){
         otherGenre.addAll(coupleGenre);
     }
     else if (whichList.equals("topic")){
         otherTopic.addAll(coupleGenre);
     }
     else {
         otherGoal.addAll(coupleGenre);
     }

    }
}
