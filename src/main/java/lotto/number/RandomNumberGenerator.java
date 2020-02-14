package lotto.number;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.util.LottoStatics.*;

public class RandomNumberGenerator implements NumberGenerator {
    private static final List<Integer> NUMBER_POOL;

    static {
        NUMBER_POOL = IntStream.rangeClosed(START_OF_LOTTO_NUMBER, LIMIT_OF_LOTTO_NUMBER)
                .boxed()
                .collect(Collectors.toList());
    }

    @Override
    public List<Integer> generate() {
        List<Integer> newNumbers = new ArrayList<>(NUMBER_POOL);

        Collections.shuffle(newNumbers);

        return newNumbers.subList(0, NUMBER_OF_LOTTO_NUMBER);
    }
}
