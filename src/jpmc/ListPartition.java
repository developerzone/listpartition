package jpmc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListPartition {
    public static void main(String args[]) throws Exception {
        List<Integer> inputList= new ArrayList<>();
        int partitionSize=3;
        for(String arg:args){
            //Add the numbers to inputList
            inputList.add(Integer.parseInt(arg));
        }
        validateAndPartitionList(inputList, partitionSize);
    }
    public static void validateAndPartitionList(List<Integer> inputList,int partitionSize)  throws Exception {
        if(inputList.size() < partitionSize){
            throw new Exception("Input array must contain at least 3 numbers");
        }else{
            //Sort the list
            Collections.sort(inputList);
            partitionList(inputList);
        }
    }
    public static void partitionList(List<Integer> inputList){
        List<Integer> firstOutputList= new ArrayList<>();
        List<Integer> secondOutputList= new ArrayList<>();
        List<Integer> thirdOutputList= new ArrayList<>();
        int index=inputList.size()-1;
        int loopCounter=0; //loopCounter to check if we are looping for odd or even time

        /**
         * Start from the end of the sorted list and loop 3 in a batch to put the numbers in 3 lists
         * keep 3 variables for finding the sum of each of list elements
         */
        int firstOutputListSum=0;
        int secondOutputListSum=0;
        int thirdOutputListSum=0;
        while(index >=0){
            loopCounter++;
            if(loopCounter%2 ==0){
                //For each even loop, the 1st element will be stored in third list and 3rd element will be stored in firstlist
                thirdOutputList.add(inputList.get(index));
                thirdOutputListSum+=inputList.get(index);
                if(index-2 >= 0){
                    firstOutputList.add(inputList.get(index-2));
                    firstOutputListSum+=inputList.get(index-2);
                }
            }else{
                //For each odd loop, the 1st element will be stored in first list and 3rd element will be stored in thirdlist
                firstOutputList.add(inputList.get(index));
                firstOutputListSum+=inputList.get(index);
                if(index-2 >= 0){
                    thirdOutputList.add(inputList.get(index-2));
                    thirdOutputListSum+=inputList.get(index-2);
                }
            }
            //For each loop the 2nd element will be stored in secondlist
            if(index-1 >= 0){
                secondOutputList.add(inputList.get(index-1));
                secondOutputListSum+=inputList.get(index-1);
            }
            index-=3;
        }
        //Add the sum of elements to the end of the list
        firstOutputList.add(firstOutputListSum);
        secondOutputList.add(secondOutputListSum);
        thirdOutputList.add(thirdOutputListSum);
        System.out.println("*************First output list with sum*********");
        System.out.println(firstOutputList);
        System.out.println("*************Second output list with sum*********");
        System.out.println(secondOutputList);
        System.out.println("*************Third output list with sum*********");
        System.out.println(thirdOutputList);
    }
}
