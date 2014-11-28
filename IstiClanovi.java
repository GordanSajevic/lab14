public class IstiClanovi {

/**
	 * Funkcija kreira jednu matricu sa yadanom visinom i širinom
	 * @param vis
	 * @param sir
	 * @return matrica
	 */
	
	public static int[][] kreirajMatricu (int vis, int sir)
	{
		int[][] matrica = new int[vis][sir];
		for (int i=0; i<vis; i++)
		{
			for (int j=0; j<sir; j++)
			{
				System.out.println("Unesite član (" + i + "," + j + "): ");
				matrica[i][j] = TextIO.getInt();
			}
		}
		return matrica;
	}
	
	/**
	 * Funkcija ispisuje zadanu matricu
	 * @param matrica
	 */
	
	public static void ispisiMatricu(int[][] matrica)
	{
		for (int i=0; i<matrica.length; i++)
		{
			for (int j=0; j<matrica[i].length; j++)
			{
				System.out.print(matrica[i][j] + "  ");
			}
			System.out.println();
		}
	}
	
	/**
	 * Funkcija provjerava da li su svi članovi zadanog reda isti
	 * @param matrica
	 * @param broj
	 * @return boolean
	 */
	
	private static boolean sviIstiRed(int[][] matrica, int broj) {
		boolean isti = true;
		for (int i=0; i<matrica.length-1; i++)
		{
			if (matrica[broj][i] != matrica[broj][matrica.length-1-i])
				{
					isti = false;
				}
		}
		return isti;
		
	}
	
	/**
	 * Funkcija provjerava da li su svi članovu suprotne dijagonale isti
	 * @param matrica
	 * @param broj
	 * @return boolean
	 */
	
	private static boolean sviIstiKontraDijagonala(int[][] matrica, int broj) {
		boolean isti = true;
		int[] niz = new int [matrica.length];
		int brojac=0;
		for (int i=0; i<matrica.length; i++)
		{
			for (int j=0; j<matrica[i].length; j++)
			{
				if (i + j == matrica.length)
				{
					niz[brojac] += matrica[i][j];
					brojac++;
				}
			}
		}
		for (int i=0; i<niz.length; i++)
		{
			if (niz[i] != niz[niz.length-1-i])
			{
				isti = false;
			}
		}
		return isti;
	}

	/**
	 * Funkcija provjerava da li su svi članovi dijegonale isti
	 * @param matrica
	 * @return boolean
	 */
	
	private static boolean sviIstiDijagonala(int[][] matrica) {
		boolean isti = true;
		int[] niz = new int [matrica.length];
		int brojac=0;
		for (int i=0; i<matrica.length; i++)
		{
			for (int j=0; j<matrica[i].length; j++)
			{
				if (i == j)
				{
					niz[brojac] += matrica[i][j];
					brojac++;
				}
			}
		}
		for (int i=0; i<niz.length; i++)
		{
			if (niz[i] != niz[niz.length-1-i])
			{
				isti = false;
			}
		}
		return isti;
	}

	/**
	 * Funkcija provjerava da li su svi članovi zadane kolone isti
	 * @param matrica
	 * @param broj
	 * @return boolean
	 */
	
	private static boolean sviIstiKolona(int[][] matrica, int broj) {
		boolean isti = true;
		for (int i=0; i<matrica[broj].length; i++)
		{
			if (matrica[i][broj] != matrica[matrica.length-1-i][broj])
			{
				isti = false;
			}
		}
		return isti;
	}
	
	public static void main(String[] args) {
		System.out.println("Unesite visinu matrice: ");
		int visina = TextIO.getInt();
		System.out.println("Unesite visinu matrice: ");
		int sirina = TextIO.getInt();
		System.out.println("Unesite broj: ");
		int broj = TextIO.getInt();
		int[][] matrica = kreirajMatricu(visina, sirina);
		System.out.println();
		ispisiMatricu(matrica);
		System.out.println("Svi članovi reda su: " + sviIstiRed(matrica, broj));
		System.out.println("Svi članovi kolone su: " + sviIstiKolona(matrica, broj));
		System.out.println("Svi članovi dijagonale su: " + sviIstiDijagonala(matrica));
		System.out.println("Svi članovi kontra dijagonale su: " + sviIstiKontraDijagonala(matrica, broj)); 
	}
}
