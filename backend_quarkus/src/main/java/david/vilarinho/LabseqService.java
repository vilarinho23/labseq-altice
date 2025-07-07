package david.vilarinho;

import jakarta.enterprise.context.ApplicationScoped;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@ApplicationScoped
public class LabseqService {

    // Local cache for already calculated numbers
    private final Map<Integer, BigInteger> cache = new ConcurrentHashMap<>();
    private volatile int maxComputed = 3;

    public LabseqService() {
        cache.put(0, BigInteger.ZERO);
        cache.put(1, BigInteger.ONE);
        cache.put(2, BigInteger.ZERO);
        cache.put(3, BigInteger.ONE);
    }

    public String calculate(int n) {
        if (n < 0) throw new IllegalArgumentException("Index must be non-negative");

        for (int i = maxComputed + 1; i <= n; i++) {
            cache.computeIfAbsent(i, key -> cache.get(key - 4).add(cache.get(key - 3)));
        }
        maxComputed = Math.max(maxComputed, n);

        return convert(cache.get(n));
    }


    private String convert(BigInteger value) {
        int maxBits = 100;
        if (value.bitLength() > maxBits) {
            return String.format("%.6e", new BigDecimal(value));
        } else {
            return value.toString();
        }
    }

}
