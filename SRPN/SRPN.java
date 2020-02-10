import java.util.Scanner;
import java.util.Stack;

public class SRPN {

	private static Scanner scan = new Scanner(System.in);
	private static Stack<Integer> numStack = new Stack<Integer>();
	private static void RPNcalc() throws Exception {
		// setting an initial value for the string.
		String str = "";
		// while(true) keeps the while loop running.
		while(true){
			// input is added to the string.
			str = scan.next();
			//catching any exceptions by using a try block followed by a catch block.
			try {
				// returns integer object holding value of character in the string and sets it to equal intstr
				int intstr = Integer.valueOf(str);
				// stack contains only integer objects
				numStack.push(intstr);
				// presents stack overflow when the number of elements in the stack is more than 23
				if (numStack.size() > 23){
					System.out.println("Stack overflow.");
				}
			}
			catch (Exception e){

				// compares the input in the string to the operator.	
				if(str.equals("+") ){
					// prints out Stack Underflow when there aren't enough integers to evaluate
					if (numStack.size() < 2){
						System.out.println("Stack underflow.");
					}

					// lNum is the integer on the left hand side of the operator and rNum is on the right.
					int rNum = numStack.pop();
					int lNum = numStack.pop();
					// This stops the integer value from wrapping around once it goes above the maximum value
					if ((rNum > 0 && lNum >Integer.MAX_VALUE - rNum)||(lNum > 0 && rNum >Integer.MAX_VALUE - lNum)){
						int result =  Integer.MAX_VALUE;
						numStack.push(result);
					}
					// the integers on the stack that come from the input are removed and the result of them is pushed
					// on to the stack 
					else {
						int result = lNum + rNum;
						numStack.push(result);
					}
				}

				else if (str.equals("/")) {
					if (numStack.size() < 2){
						System.out.println("Stack underflow.");
					}
					int rNum = numStack.pop();
					int lNum = numStack.pop();
					// Caps the value of the result to its maximum and minimum values.
					if (lNum == Integer.MIN_VALUE && rNum == -1){
						int result = Integer.MAX_VALUE;
						System.out.print(result);
					}
					else if(rNum == 0){
						System.out.println("Divide by 0.");
					}
					int result = lNum / rNum;
					numStack.push(result);
				}

				else if (str.equals("*")) {
					if (numStack.size() < 2){
						System.out.println("Stack underflow.");
					}
					int rNum = numStack.pop();
					int lNum = numStack.pop();
					// Caps value of result at maximum and minimum
					if( rNum*lNum > Integer.MAX_VALUE ){
						int result = Integer.MAX_VALUE;
						numStack.push(result);
					}
					else if ( rNum*lNum < Integer.MIN_VALUE){
						int result = Integer.MIN_VALUE;
						numStack.push(result);
					}
					else {
						int result = lNum * rNum;
						numStack.push(result);
					}
				}

				else if (str.equals("-")) {
					if (numStack.size() < 2){
						System.out.println("Stack underflow.");
					}
					int rNum = numStack.pop();
					int lNum = numStack.pop();
					// Stops the value of the integer from wrapping around when it goes below the minimum value.
					if ((rNum > 0 && lNum <Integer.MIN_VALUE + rNum)||(lNum > 0 && rNum <Integer.MIN_VALUE + lNum)){
						int result = lNum;
						numStack.push(result);
					}
					else{
						int result = lNum - rNum;
						numStack.push(result);
					}
				}

				else if (str.equals("^")){
					if (numStack.size() < 2){
						System.out.println("Stack underflow.");
					}
					int rNum = numStack.pop();
					int lNum = numStack.pop();
					if (rNum < 0){
						System.out.println("Negative power.");
					}
					if ((int)Math.pow(lNum, rNum) > Integer.MAX_VALUE){
						int result = Integer.MAX_VALUE;
						numStack.push(result);
					}
					int result = (int)Math.pow(lNum, rNum);
					numStack.push(result);
				}

				else if (str.equals("%")){
					if (numStack.size() < 2){
						System.out.println("Stack underflow.");
					}
					int rNum = numStack.pop();
					int lNum = numStack.pop();
					int result = lNum % rNum;
					numStack.push(result);
				}

				else if (str.equals("=")) {
					if (numStack.size() < 1){
						System.out.println("Stack underflow.");
					}
					else {
						System.out.println(numStack.peek());
					}
				}

				// displays all of the integers in the stack
				else if (str.equals("d")) {
					if (!numStack.empty()) {
						for (int i = 0; i < numStack.size(); i++) {
							System.out.println(numStack.get(i));
						}
					}
				}

				// pressing 'r' increments the position in Array below.
				else if (str.equals("r")){
					arraypoint ++;
					numStack.push(Array[arraypoint]);
				}

				else if (str.equals("#")){
					str.equalsIgnoreCase(scan.nextLine());
				}

				//Unrecognised operator or operand "operator/operand".
				else if(!str.equals("+")|| !str.equals("-") ||!str.equals("*")||!str.equals("/")||!str.equals("%")||!str.equals("^")||!str.equals("d")||!str.equals("r") ||!str.equals("#")||!str.equals("1")||!str.equals("2")||!str.equals("3")||!str.equals("4")||!str.equals("5")||!str.equals("6")||!str.equals("7")||!str.equals("8")||!str.equals("9")||!str.equals("0")){
					System.out.println("Unrecognised operator or operand \""+str+"\".");
				}
			}	
		}
	}

	//pressing 'r' pushes the numbers from the following array into the stack one by one starting from the first number.
	static int arraypoint = -1;
	static int[] Array = { 
			1804289383, 846930886, 1681692777, 1714636915, 1957747793,
			424238335, 719885386, 1649760492, 596516649, 1189641421,
			1025202362, 1350490027, 783368690, 1102520059, 2044897763,
			1967513926, 1365180540, 1540383426, 304089172, 1303455736,
			35005211, 521595368, 294702567, 1726956429, 336465782, 861021530,
			278722862, 233665123, 2145174067, 468703135, 1101513929, 1801979802,
			1315634022, 635723058, 1369133069, 1125898167, 1059961393, 2089018456,
			628175011, 1656478042, 1131176229, 1653377373, 859484421, 1914544919,
			608413784, 756898537, 1734575198, 1973594324, 149798315, 2038664370,
			1129566413, 184803526, 412776091, 1424268980, 1911759956, 749241873,
			137806862, 42999170, 982906996, 135497281, 511702305, 2084420925,
			1937477084, 1827336327, 572660336, 1159126505, 805750846, 1632621729,
			1100661313, 1433925857, 1141616124, 84353895, 939819582, 2001100545,
			1998898814, 1548233367, 610515434, 1585990364, 1374344043, 760313750,
			477171087, 356426808, 945117276, 1889947178, 1780695788, 709393584,
			491705403, 1918502651, 752392754, 1474612399, 2053999932, 1264095060,
			1411549676, 1843993368, 943947739, 1984210012, 855636226, 1749698586,
			1469348094, 1956297539
	};

	public static void main(String[] args) throws Exception {
		try{
			RPNcalc();
		}
		catch (Exception e) { 
			RPNcalc();
		}
		throw new Exception();
	}
}


