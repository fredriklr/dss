package datainterpretation;

public class Symptoms {

	public static int agentDum(Integer iq) {
		int dum = 0;

		if (iq <= 100) {
			dum = 2;
		}
		// System.out.println(iq + " " + dum);
		return dum;
	}

	public static int agentOvervekt(Double hoyde, Double vekt) {
		int hvRatio = 0;

		if ((hoyde / vekt) <= 2.25) {
			hvRatio = 2;
		}
		// System.out.println(hoyde/vekt + " " + hvRatio);
		return hvRatio;
	}

	public static int agentKortvokst(Integer alder, Double hoyde) {
		int kortvokst = 0;

		if ((alder >= 14) && (hoyde <= 150.0)) {
			kortvokst = 2;
		}
		// System.out.println(alder + " " + hoyde + " " + kortvokst);
		return kortvokst;
	}

}
