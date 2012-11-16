package xmas.parts;

public class TowerNuss extends Tower {
		
		private int damage;
		private int range;
		private String symbol;
		
		public TowerNuss( int reihe , int stelle ) {
			
			super(reihe, stelle);
			this.damage = 30;
			this.range = 10;
			this.symbol = " N";
		}
		
		public int getRange() {
			return range;
		}
		
		public int getDamage() {
			return damage;
		}
		
		public String getSymbol() {
			return this.symbol;
		}
		
}