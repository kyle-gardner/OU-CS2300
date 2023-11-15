package test;

public class Converter {
	String input;
	Operation op;

	public enum Operation {
		KG_LBS,
		MI_KM,
		G_OZ,
		MM_IN,
		INVALID,
	};

	public static String convert(String input, Operation op) {
		Float inputNum = Float.parseFloat(input);
		Float outputNum;

		switch (op) {
			case KG_LBS:
				outputNum = inputNum * 2.2046226F;
				break;
			case MI_KM:
				outputNum = inputNum * 1.60934F;
				break;
			case G_OZ:
				outputNum = inputNum / 28.35F;
				break;
			case MM_IN:
				outputNum = inputNum / 25.4F;
				break;
			case INVALID:
				return "select a unit :3";
			default:
				outputNum = -1F;
				break;
		}
		return String.valueOf(outputNum);
	}
}
