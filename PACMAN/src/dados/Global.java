package dados;

public interface Global {
	public static final char MAPA1[][] = { 
			{ 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x' }, // 00
			{ 'x', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'x', 'x', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'x' }, // 01
			{ 'x', 'o', 'x', 'x', 'x', 'x', 'o', 'x', 'x', 'x', 'x', 'x', 'o', 'x', 'x', 'o', 'x', 'x', 'x', 'x', 'x', 'o', 'x', 'x', 'x', 'x', 'o', 'x' }, // 02
			{ 'x', '-', 'x', 'x', 'x', 'x', 'o', 'x', 'x', 'x', 'x', 'x', 'o', 'x', 'x', 'o', 'x', 'x', 'x', 'x', 'x', 'o', 'x', 'x', 'x', 'x', '-', 'x' }, // 03
			{ 'x', 'o', 'x', 'x', 'x', 'x', 'o', 'x', 'x', 'x', 'x', 'x', 'o', 'x', 'x', 'o', 'x', 'x', 'x', 'x', 'x', 'o', 'x', 'x', 'x', 'x', 'o', 'x' }, // 04
			{ 'x', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'x' }, // 05
			{ 'x', 'o', 'x', 'x', 'x', 'x', 'o', 'x', 'x', 'o', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'o', 'x', 'x', 'o', 'x', 'x', 'x', 'x', 'o', 'x' }, // 06
			{ 'x', 'o', 'x', 'x', 'x', 'x', 'o', 'x', 'x', 'o', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'o', 'x', 'x', 'o', 'x', 'x', 'x', 'x', 'o', 'x' }, // 07
			{ 'x', 'o', 'o', 'o', 'o', 'o', 'o', 'x', 'x', 'o', 'o', 'o', 'o', 'x', 'x', 'o', 'o', 'o', 'o', 'x', 'x', 'o', 'o', 'o', 'o', 'o', 'o', 'x' }, // 08
			{ 'x', 'x', 'x', 'x', 'x', 'x', 'o', 'x', 'x', 'x', 'x', 'x', 'o', 'x', 'x', 'o', 'x', 'x', 'x', 'x', 'x', 'o', 'x', 'x', 'x', 'x', 'x', 'x' }, // 09
			{ 'x', 'x', 'x', 'x', 'x', 'x', 'o', 'x', 'x', 'x', 'x', 'x', 'o', 'x', 'x', 'o', 'x', 'x', 'x', 'x', 'x', 'o', 'x', 'x', 'x', 'x', 'x', 'x' }, // 10
			{ 'x', 'x', 'x', 'x', 'x', 'x', 'o', 'x', 'x', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'x', 'x', 'o', 'x', 'x', 'x', 'x', 'x', 'x' }, // 11
			{ 'x', 'x', 'x', 'x', 'x', 'x', 'o', 'x', 'x', 'o', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'o', 'x', 'x', 'o', 'x', 'x', 'x', 'x', 'x', 'x' }, // 12
			{ 'x', 'x', 'x', 'x', 'x', 'x', 'o', 'x', 'x', 'o', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'o', 'x', 'x', 'o', 'x', 'x', 'x', 'x', 'x', 'x' }, // 13
			{ 'e', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'e' }, // 14
			{ 'x', 'x', 'x', 'x', 'x', 'x', 'o', 'x', 'x', 'o', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'o', 'x', 'x', 'o', 'x', 'x', 'x', 'x', 'x', 'x' }, // 15
			{ 'x', 'x', 'x', 'x', 'x', 'x', 'o', 'x', 'x', 'o', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'o', 'x', 'x', 'o', 'x', 'x', 'x', 'x', 'x', 'x' }, // 16
			{ 'x', 'x', 'x', 'x', 'x', 'x', 'o', 'x', 'x', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'x', 'x', 'o', 'x', 'x', 'x', 'x', 'x', 'x' }, // 17
			{ 'x', 'x', 'x', 'x', 'x', 'x', 'o', 'x', 'x', 'o', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'o', 'x', 'x', 'o', 'x', 'x', 'x', 'x', 'x', 'x' }, // 18
			{ 'x', 'x', 'x', 'x', 'x', 'x', 'o', 'x', 'x', 'o', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'o', 'x', 'x', 'o', 'x', 'x', 'x', 'x', 'x', 'x' }, // 19
			{ 'x', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'x', 'x', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'x' }, // 20
			{ 'x', 'o', 'x', 'x', 'x', 'x', 'o', 'x', 'x', 'x', 'x', 'x', 'o', 'x', 'x', 'o', 'x', 'x', 'x', 'x', 'x', 'o', 'x', 'x', 'x', 'x', 'o', 'x' }, // 21
			{ 'x', 'o', 'x', 'x', 'x', 'x', 'o', 'x', 'x', 'x', 'x', 'x', 'o', 'x', 'x', 'o', 'x', 'x', 'x', 'x', 'x', 'o', 'x', 'x', 'x', 'x', 'o', 'x' }, // 22
			{ 'x', '-', 'o', 'o', 'x', 'x', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'P', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'x', 'x', 'o', 'o', '-', 'x' }, // 23
			{ 'x', 'x', 'x', 'o', 'x', 'x', 'o', 'x', 'x', 'o', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'o', 'x', 'x', 'o', 'x', 'x', 'o', 'x', 'x', 'x' }, // 24
			{ 'x', 'x', 'x', 'o', 'x', 'x', 'o', 'x', 'x', 'o', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'o', 'x', 'x', 'o', 'x', 'x', 'o', 'x', 'x', 'x' }, // 25
			{ 'x', 'o', 'o', 'o', 'o', 'o', 'o', 'x', 'x', 'o', 'o', 'o', 'o', 'x', 'x', 'o', 'o', 'o', 'o', 'x', 'x', 'o', 'o', 'o', 'o', 'o', 'o', 'x' }, // 26
			{ 'x', 'o', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'o', 'x', 'x', 'o', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'o', 'x' }, // 27
			{ 'x', 'o', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'o', 'x', 'x', 'o', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'o', 'x' }, // 28
			{ 'x', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'x' }, // 29
			{ 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x' }  // 30;
		};

}
