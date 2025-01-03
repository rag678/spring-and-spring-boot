package com.in28minutes.rest.webservices.restfulwebservices.business;

public class SomeBusinessImpl {

    private DataService dataService;

    public SomeBusinessImpl(DataService dataService) {
        this.dataService = dataService;
    }

    public int findTheGreatestFromAllData(){
        int[] data = dataService.retrieveAllData();
        int greatest = Integer.MIN_VALUE;
        for(int val : data){
            if(val > greatest) greatest = val;
        }
        return greatest;
    }
}

