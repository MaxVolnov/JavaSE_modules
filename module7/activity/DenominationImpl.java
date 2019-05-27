package sef.module7.activity;

import java.util.Objects;

/**
 * An implementation of the Denomination interface.  The equality test for between instances
 * of this class considers the name and the symbol
 *
 * @author John Doe
 */
public class DenominationImpl implements Denomination {

    String name;
    String description;
    String symbol;

    /**
     * Creates a new instance with the specified parameters
     *
     * @param name        the name of the denomination
     * @param description a description
     * @param symbol
     */
    public DenominationImpl(String name, String description, String symbol) {
        this.name = name;
        this.description = description;
        this.symbol = symbol;
    }

    /* (non-Javadoc)
     * @see sef.module6.activity.Denomination#getDescription()
     */
    public String getDescription() {
        return description;
    }

    /* (non-Javadoc)
     * @see sef.module6.activity.Denomination#getName()
     */
    public String getName() {
        return name;
    }

    /* (non-Javadoc)
     * @see sef.module6.activity.Denomination#getSymbol()
     */
    public String getSymbol() {
        return symbol;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DenominationImpl that = (DenominationImpl) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(symbol, that.symbol);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, symbol);
    }
}
