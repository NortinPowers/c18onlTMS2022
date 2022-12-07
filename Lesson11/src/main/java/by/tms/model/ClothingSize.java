package by.tms.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ClothingSize {
    XXS(32) {
        @Override
        public String getDescription() {
            return "Child size";
        }
    },
    XS(34),
    S(36),
    M(38),
    L(40);

    private final int euroSize;

    public String getDescription() {
        return "Adult size";
    }
}
