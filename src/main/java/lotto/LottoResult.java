package lotto;

import java.util.Map;

public class LottoResult {

    private static final double ROUND_STANDARD = 100.0;

    private final Map<LottoRank, Integer> result;

    public LottoResult(Map<LottoRank, Integer> result) {
        this.result = result;
    }

    public double calculateReturnRate(int payed) {
        double sum = 0;
        for (LottoRank rank : result.keySet()) {
            sum += rank.getPrize() * result.get(rank);

        }
        return Math.floor(sum / payed * ROUND_STANDARD) / ROUND_STANDARD;
    }

    public int countRank(LottoRank rank) {
        return result.getOrDefault(rank, 0);
    }

    public Map<LottoRank, Integer> getResult() {
        return result;
    }

    @Override
    public String toString() {
        return "LottoResult{" +
            "result=" + result +
            '}';
    }
}
