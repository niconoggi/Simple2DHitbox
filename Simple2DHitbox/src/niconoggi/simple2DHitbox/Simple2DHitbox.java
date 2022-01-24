package niconoggi.simple2DHitbox;

/**
 * This class represents a rectangle allowing easy updates of its 
 * coordinate and dimension values. It also provides an option for checking
 * collision with other instances of this object using {@code collidesWithOther()}
 * <p>
 * The coordinate and dimension values are stored as integers.
 * @author niconoggi 
 */
public class Simple2DHitbox {
	
	private int x;
	private int y;
	private int width;
	private int height;
	
	/**
	 * the basic constructor. As the stored values are primitive integers,
	 * they will be implicitly set to 0
	 */
	public Simple2DHitbox() {}
	
	/**
	 * constructor that moves this hitbox to the specified position immediately.
	 * The dimensions will remain 0.
	 * @param x the x coordinate
	 * @param y the y coordinate
	 */
	public Simple2DHitbox(final int x, final int y) {
		move(x,y);
	}
	
	/**
	 * Constructor used to set the coordinates and dimensions on call.
	 * If only the coordinates should be set, use the constructor 
	 * {@code Simple2DHitbox(final int x, final int y)}
	 * <p>
	 * if only width and height should be set, proceed like this:
	 * <p>
	 * {@code Simple2DHitbox onlyDimensions = new Simple2DHitbox(0,0,width,height);}
	 * <p>
	 * Due to the nature of overloading methods, a separate constructor only setting the
	 * dimension values is not possible.
	 * @param x the x coordinate
	 * @param y the y coordinate
	 * @param width the x-axis dimension
	 * @param height the y-axis dimension
	 */
	public Simple2DHitbox(final int x, final int y, final int width, final int height) {
		this(x,y);
		changeDimensions(width, height);
	}
	
	/**
	 * sets the coordinates of this instance to the given
	 * parameters
	 * @param x the new x coordinate
	 * @param y the new y coordinate
	 */
	public void move(final int x, final int y) {
		setX(x);
		setY(y);
	}
	
	/**
	 * sets the dimension values based on the given
	 * parameters
	 * @param width the new width
	 * @param height the new height
	 */
	public void changeDimensions(final int width, final int height) {
		setWidth(width);
		setHeight(height);
	}
	
	/**
	 * sets all values of this instance based on the parameters
	 * <p>
	 * Sets the coordinates first
	 * @param x the new x coordinate
	 * @param y the new y coordinate
	 * @param width the new width
	 * @param height the new height
	 */
	public void updateMoveFirst(final int x, final int y, final int width, final int height) {
		move(x,y);
		changeDimensions(width, height);
	}
	
	/**
	 * sets all values of this instance based on the parameters
	 * <p>
	 * Sets the dimensions first
	 * @param x the new x coordinate
	 * @param y the new y coordinate
	 * @param width the new width
	 * @param height the new height
	 */
	public void updateChangeDimensionsFirst(final int x, final int y, final int width, final int height) {
		changeDimensions(width, height);
		move(x,y);
	}
	
	/**
	 * checks if this instance collides with another instance
	 * @param other the other instance of which the values are compared
	 * 			to the ones of this instance
	 * @return true, if the hitboxes seen as rectangles overlap. false otherwise
	 */
	public boolean collidesWithOther(final Simple2DHitbox other) {
		//collision on x-axis?
		if((x >= other.x && x <= other.x + other.width) ||
			(x + width >= other.x && x + width <= other.x + other.width)) {
			//collision on y-axis?
			if((y >= other.y && y <= other.y + other.height) ||
					(y + height >= other.y && y + height <= other.y + other.height)) {
				return true;
			}
		}
		return false;
	}
	
	public int getX() {
		return x;
	}
	
	public void setX(final int x) {
		this.x = x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setY(final int y) {
		this.y = y;
	}
	
	public int getWidth() {
		return width;
	}
	
	public void setWidth(final int width) {
		this.width = width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public void setHeight(final int height) {
		this.height = height;
	}
	
	@Override
	public boolean equals(final Object obj) {
		if(!(obj instanceof Simple2DHitbox)) {
			return false;
		}
		
		final Simple2DHitbox other = (Simple2DHitbox) obj;
		
		return x == other.x && y == other.y && width == other.width && height == other.height;
	}
	
	@Override
	public int hashCode() {
		return x + y + width + height;
	}
	
	@Override
	public String toString() {
		final StringBuilder builder = new StringBuilder();
		builder.append("x = ").append(x);
		builder.append(", y = ").append(y);
		builder.append(", width = ").append(width);
		builder.append(", height = ").append(height);
		return builder.toString();
	}
}


