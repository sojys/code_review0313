import java.util.ArrayList;
import java.util.Arrays;
interface SortPrinter {
    public void run(ArrayList<Integer> lst);
}

class BubbleSort implements SortPrinter {
    @Override
    public void run(ArrayList<Integer> lst) {
        for(int cycle = 0 ;cycle < lst.size(); cycle ++) {
            for(int i = 0 ; i < lst.size() - 1 - cycle; i ++) {
                if(lst.get(i) > lst.get(i + 1)){
                    //swap
                    int tmp = lst.get(i);
                    lst.set(i, lst.get(i + 1));
                    lst.set(i + 1, tmp);
                }
            }
        }
    }
}
class SelectionSort implements SortPrinter {
    @Override
    public void run(ArrayList<Integer> lst) {
        for(int i = 0 ; i < lst.size(); i++) {
            for(int j = i + 1 ; j < lst.size(); j ++) {
                if(lst.get(i) > lst.get(j)){
                    int tmp = lst.get(i);
                    lst.set(i, lst.get(j));
                    lst.set(j, tmp);
                }
            }
        }
    }
}
class Machine {
    SortPrinter Sort;

    ArrayList<Integer> inputList = new ArrayList<>();

    // insert 기능
    public void insert(ArrayList<Integer> lst){
        inputList = lst;
    }
    // selection 기능
    public void selection(SortPrinter sort){
        Sort = sort;
    }
    // run 기능
    public void run(){
        Sort.run(inputList);
    }
    // insert 기능
    public void show(){
        System.out.println(Arrays.toString(inputList.toArray()));
    }
}
public class homework {
    public static void main(String[] args) {
        ArrayList<Integer> lst = new ArrayList<>(Arrays.asList(3,3,3,2,1,1,2,3,2,1,2,3,1,2,3,2,1,5,5,2,1,7));
        Machine machine = new Machine();

        machine.selection(new BubbleSort());
        machine.insert(lst);
        machine.run();
        machine.show();
    }
}