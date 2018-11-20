package com.epam;

public class ConversionProblem {

	float ConversionToInches(int centimeter) 
    { 
        float inches = 0.3937f * centimeter;   
        return inches;
    } 

	float ConversionToFeets(int centimeter) 
    {  
        float feet = 0.0328f * centimeter;  
        return feet;
    } 
}
