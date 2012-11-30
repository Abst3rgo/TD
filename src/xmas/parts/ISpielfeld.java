package xmas.parts;

public interface ISpielfeld {

	int getX();

	int getY();

	String tostring();

	boolean setTower(String symbol, int y, int x);

	String[][] getfieldArray();

	String getEmpty();

	void setFieldEmpty(int y, int x);

	void updateMob(String symbol, int y, int x, int oldY, int oldX);

	int getStartY();

	int getStartX();

}
