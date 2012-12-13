package xmas.parts.impl;

public class TowerNuss extends Tower {
		
		private int damage;
		private String symbol;
		private static int range = 1;
		
		public TowerNuss( int y , int x ) {
			super(y, x, range);
			this.damage = 5;
			this.symbol = "K|";
		}
		
		public int getDamage() {
			return damage;
		}
		
		public String getSymbol() {
			return this.symbol;
		}
		
}