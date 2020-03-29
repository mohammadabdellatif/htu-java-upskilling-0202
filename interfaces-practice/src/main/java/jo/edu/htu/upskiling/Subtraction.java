package jo.edu.htu.upskiling;

class Subtraction implements Operation<Integer> {

    @Override
    public Integer execute(Integer first, Integer second) {
        return first - second;
    }
}
