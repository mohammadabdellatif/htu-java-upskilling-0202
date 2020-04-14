package jo.edu.htu.upskiling;

public interface Operation<OPERAND> {

    OPERAND execute(OPERAND first,OPERAND second);
}
