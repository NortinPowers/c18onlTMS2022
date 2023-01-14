package by.tms.service;

import by.tms.model.Toy;
import lombok.AllArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ToString
@AllArgsConstructor
public class ToyService implements ToyServiceAware {
    private Map<String, Toy> toyHashMap;

    public Map<String, Toy> getToyHashMap() {
        if (toyHashMap == null) {
            toyHashMap = new HashMap<>();
        }
        return toyHashMap;
    }

    public ToyService() {
        init();
    }

    @Override
    public List<String> getToyNames() {
        return new ArrayList<>(toyHashMap.keySet());
    }

    @Override
    public List<Toy> getToys() {
        return new ArrayList<>(toyHashMap.values());
    }

    @Override
    public String getToyInfo() {
        StringBuilder info = new StringBuilder();
        info.append("Toys:\n");
        for (Map.Entry<String, Toy> entry : toyHashMap.entrySet()) {
            info.append(entry.getKey()).append(" - ").append(entry.getValue()).append("\n");
        }
        return info.toString();
    }

    private void init() {
        toyHashMap = new HashMap<>();
        toyHashMap.put("Masha", new Toy("Doll"));
        toyHashMap.put("Veselka", new Toy("Pinwheel"));
        toyHashMap.put("Rainbow", new Toy("Spring"));
    }
}