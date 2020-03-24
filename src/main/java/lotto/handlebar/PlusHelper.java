package lotto.handlebar;

import com.github.jknack.handlebars.Helper;
import com.github.jknack.handlebars.Options;

import java.io.IOException;

public class PlusHelper implements Helper<Integer> {
    @Override
    public Object apply(Integer context, Options options) throws IOException {
        return context + 1;
    }
}
