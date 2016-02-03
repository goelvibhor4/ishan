package com.hibernate.dto;

import java.util.Vector;

public class Pearson {

	public double GetCorrelation(Vector<Double> xVect, Vector<Double> yVect) {
     int ct=0;
     double meanX = 0.0, meanY = 0.0;
     System.out.println("\nxVect.size "+xVect.size());
    for(int i = 0; i < xVect.size(); i++)
    {    System.out.println("\nxVect.elementAt(i) "+xVect.elementAt(i));
        if(xVect.elementAt(i) ==-2.0 || yVect.elementAt(i) ==-2.0){
            ct=ct+1;
        }
        else{ 
            meanX += xVect.elementAt(i);
            meanY += yVect.elementAt(i);
        }
    }
    
    meanX /= (xVect.size()-ct);
    meanY /= (yVect.size()-ct);
    //System.out.println("-----------------");
    //System.out.println("meanX , meanY"+meanX +","+ meanY);
    
    double sumXY = 0.0, sumX2 = 0.0, sumY2 = 0.0;
    for(int i = 0; i < xVect.size(); i++)
    { 
       if(xVect.elementAt(i) !=-1.0 && yVect.elementAt(i) !=-1.0)
        {  // System.out.println("xVect.elementAt(i) , yVect.elementAt(i) "+xVect.elementAt(i)+" ,"+ yVect.elementAt(i) );
            sumXY += ((xVect.elementAt(i) - meanX) * (yVect.elementAt(i) - meanY));
            sumX2 += Math.pow(xVect.elementAt(i) - meanX, 2.0);
            sumY2 += Math.pow(yVect.elementAt(i) - meanY, 2.0);
           //System.out.println("\n>> sumX2 , sumY2"+sumX2 +" , "+ sumY2);
        }
    }
    
    //System.out.println("pearson :"+(sumXY / (Math.sqrt(sumX2) * Math.sqrt(sumY2))));
    return (sumXY / (Math.sqrt(sumX2) * Math.sqrt(sumY2)));
  }
}
