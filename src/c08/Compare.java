package c08;
// Interface for sorting callback:


public interface Compare {
	boolean lessThan(Object lhs, Object rhs);
	boolean lessThanEqual(Object lhs, Object rhs);
}
