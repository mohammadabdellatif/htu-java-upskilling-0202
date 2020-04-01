
package jo.edu.htu.upskiling;

public class IntegerOperationsFactory implements OperationsFactory<Integer> {
    // TODO you should implement this class
    int first, second ;



    @Override
    public Operation<Integer> summation(){
        Operation operation=  new Operation( ) {



            @Override
            public Integer execute( Object first, Object second ) {
                return (Integer)first+(Integer)second;
            }};

        return operation;
    }


    @Override
    public Operation<Integer> subtraction() {
       Operation subtractionOp = (first, second) ->  (Integer )first-(Integer )second;
    return subtractionOp;
    }
    @Override
    public Operation<Integer> multiplication() {
        Operation multiplicationOp = (first, second) -> (Integer )first*(Integer )second;
        return multiplicationOp;
    }

    @Override
    public Operation<Integer> division() {

        Operation divisionOp = (first, second) ->  (Integer )first/(Integer )second;
        return divisionOp;

}}
