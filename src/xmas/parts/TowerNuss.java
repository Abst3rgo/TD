package xmas.parts;

public class TowerNuss extends Tower {
		
		private int damage;
		private int range;
		private String symbol;
		
		public TowerNuss( int y , int x ) {
			
			super(y, x);
			this.damage = 20;
			this.range = 10;
			this.symbol = "K";
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