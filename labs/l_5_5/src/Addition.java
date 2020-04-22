
public class Addition implements Expression {

    private final Expression left;
    private final Expression right;

    /**
     * 
     * @param left
     * @param right
     */
    public Addition(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    
    /**
	 * @return the right
	 */
	public Expression getRight() {
		return right;
	}


	/**
	 * @return the left
	 */
	public Expression getLeft() {
		return left;
	}


	/** 
     * evalutate sum of expression left & expression right
     * @return int
     */
    @Override
    public double evaluate() {
        return this.getLeft().evaluate() + this.getRight().evaluate();
    }

    
    /** 
     * @return String
     */
    @Override
    public String toString() {
        return String.format(" (%s + %s) ", this.getLeft(), this.getRight());
    }

}