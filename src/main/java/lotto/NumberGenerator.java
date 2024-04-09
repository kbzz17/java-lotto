package lotto;

import static lotto.Lotto.LOTTO_NUMBERS_LIMIT;
import static lotto.LottoNumber.MAXIMUM_NUMBER;
import static lotto.LottoNumber.MINIMUM_NUMBER;
import static lotto.LottoType.AUTO;
import static lotto.LottoType.MANUAL;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NumberGenerator {

    private static final int ZERO = 0;

    private static List<LottoNumber> shuffle;

    static {
        shuffle = inputInitLottoNumbers();
    }

    public static Lottos generateAutoNumbers(int count) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = ZERO; i < count; i++) {
            Collections.shuffle(shuffle);
            lottos.add(
                Lotto.of(AUTO, new ArrayList<>(shuffle.subList(ZERO, LOTTO_NUMBERS_LIMIT)))
            );
        }
        return Lottos.of(lottos);
    }

    private static List<LottoNumber> inputInitLottoNumbers() {
        List<LottoNumber> numbers = new ArrayList<>();
        for (int i = MINIMUM_NUMBER; i < MAXIMUM_NUMBER; i++) {
            numbers.add(new LottoNumber(i));
        }
        return numbers;
    }

    public static Lotto generateManualNumbers(String[] lotto) {
        return Lotto.of(MANUAL, lotto);
    }
}
