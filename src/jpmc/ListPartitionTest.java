package jpmc;

import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class ListPartitionTest {

    int partitionSize=3;

    @BeforeAll
    public List<Integer> getInputLessThanPartition() {
        List<Integer> inputList= new ArrayList<>();
        inputList.add(10);
        inputList.add(16);
        return inputList;
    }
    @BeforeAll
    public List<Integer> getInputEqualToPartition() {
        List<Integer> inputList= new ArrayList<>();
        inputList.add(10);
        inputList.add(16);
        inputList.add(5);
        return inputList;
    }
    @BeforeAll
    public List<Integer> getInputMoreThanPartition() {
        List<Integer> inputList= new ArrayList<>();
        inputList.add(10);
        inputList.add(16);
        inputList.add(5);
        inputList.add(0);
        inputList.add(2);
        inputList.add(5);
        inputList.add(15);
        return inputList;
    }
    @BeforeAll
    public List<Integer> getInputsorterdList() {
        List<Integer> inputList= new ArrayList<>();
        inputList.add(0);
        inputList.add(2);
        inputList.add(5);
        inputList.add(5);
        inputList.add(10);
        inputList.add(15);
        inputList.add(16);
        return inputList;
    }
    @BeforeAll
    public List<Integer> getFirstOutputList() {
        List<Integer> outputList= new ArrayList<>();
        outputList.add(16);
        outputList.add(2);
        outputList.add(0);
        outputList.add(18);
        return outputList;
    }
    @BeforeAll
    public List<Integer> getSecondOutputList() {
        List<Integer> outputList= new ArrayList<>();
        outputList.add(15);
        outputList.add(5);
        outputList.add(20);
        return outputList;
    }
    @BeforeAll
    public List<Integer> getThirdOutputList() {
        List<Integer> outputList= new ArrayList<>();
        outputList.add(10);
        outputList.add(5);
        outputList.add(15);
        return outputList;
    }
    @Test(expected = Exception.class)
    public void inputLessThanPartition() {
        getInputLessThanPartition().get(partitionSize);
    }

    @Test
    public void inputEqualToPartition() {
        assertEquals(partitionSize,getInputEqualToPartition().size());
    }
    @Test
    public void sortListTest() {
        List<Integer> inputList=getInputMoreThanPartition();
        Collections.sort(inputList);
        assertEquals(inputList,getInputsorterdList());
    }

    @Test
    public void outputListsSizeTest() {
        assertEquals((getInputMoreThanPartition().size()+partitionSize),
                (getFirstOutputList().size()+getSecondOutputList().size()+getThirdOutputList().size()));
    }
    @Test
    public void firstListSumTest() {
        List<Integer> firstOutput=getFirstOutputList();
        int sum=0;
        for(int i=0;i<firstOutput.size()-1;i++){
            sum+=firstOutput.get(i);
        }
        int lastElement=firstOutput.get(firstOutput.size()-1);
        assertEquals(sum, lastElement);
    }
    @Test
    public void secondListSumTest() {
        List<Integer> secondOutput=getSecondOutputList();
        int sum=0;
        for(int i=0;i<secondOutput.size()-1;i++){
            sum+=secondOutput.get(i);
        }
        int lastElement=secondOutput.get(secondOutput.size()-1);
        assertEquals(sum, lastElement);
    }
    @Test
    public void thirdListSumTest() {
        List<Integer> thirdOutput=getThirdOutputList();
        int sum=0;
        for(int i=0;i<thirdOutput.size()-1;i++){
            sum+=thirdOutput.get(i);
        }
        int lastElement=thirdOutput.get(thirdOutput.size()-1);
        assertEquals(sum, lastElement);
    }
}
