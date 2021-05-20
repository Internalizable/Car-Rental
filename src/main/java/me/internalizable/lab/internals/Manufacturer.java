package me.internalizable.lab.internals;

import lombok.Getter;
import lombok.Setter;
import me.internalizable.lab.utils.StaticUtils;

import java.util.List;
import java.util.Objects;

@Getter @Setter
public class Manufacturer {

    private String name;
    private List<String> address;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Manufacturer man = (Manufacturer) o;
        return man.getName().equals(name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Manufacturer Name: " + name + "\nManufacturer Address: " + StaticUtils.transformToFormattedString(address);
    }
}
