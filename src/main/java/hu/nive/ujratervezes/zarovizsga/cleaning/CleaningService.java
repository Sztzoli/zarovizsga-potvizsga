package hu.nive.ujratervezes.zarovizsga.cleaning;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CleaningService {

    private List<Cleanable> cleanables = new ArrayList<>();

    public List<Cleanable> getCleanables() {
        return new ArrayList<>(cleanables);
    }

    public void add(Cleanable cleanable) {
        cleanables.add(cleanable);
    }


    public int cleanAll() {
        int result = cleanables.stream()
                .flatMapToInt(x -> IntStream.of(x.clean()))
                .sum();
        cleanables.clear();
        return result;
    }

    public int cleanOnlyOffices() {
        int result = cleanables.stream()
                .filter(x -> x instanceof Office)
                .flatMapToInt((x -> IntStream.of(x.clean())))
                .sum();
        cleanables = cleanables.stream()
                .filter(x -> x instanceof House)
                .collect(Collectors.toList());
        return result;

    }

    public List<Cleanable> findByAddressPart(String part) {
        return cleanables.stream()
                .filter(x -> x.getAddress().contains(part))
                .collect(Collectors.toList());
    }

    public String getAddresses() {
        StringBuilder sb = new StringBuilder();
        cleanables.forEach(x -> sb.append(x.getAddress()).append(", "));
        sb.delete(sb.length()-2,sb.length());
        return sb.toString();
    }
}
