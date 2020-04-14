package jo.edu.htu.map.practice;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.ArrayList;
import java.util.stream.Stream;

public class CountersProvider implements ArgumentsProvider {

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
        ArrayList<Arguments> parameters = new ArrayList<>();
        // the list of parameters to be passed to the test method
        parameters.add(Arguments.of(new ArrayBasedCounter(), "Arrays based"));
        parameters.add(Arguments.of(new BayansCounter(), "Bayans solution"));
        parameters.add(Arguments.of(new MapBasedCounter(), "Map based"));
//        parameters.add(Arguments.of(new MohammadStrategy(), "Mohammad's solution"));
        return parameters.stream();
    }
}
