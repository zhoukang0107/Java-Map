package com.study.regex;
/*
 * 正则表达式：符合一定规则的表达式
 *    作用：用于专门操作字符串的
 *    特点：用一些特点的符来表示一些代码操作，这样就简化了书写
 *    所以学习正则表达式就是在学习一些特殊符号的使用
 *    好处：简化对字符串的复杂操作
 *    弊端：符号定义越多，正则越长，阅读性越差
 * 具体操作功能：
 * 1、匹配：String matches方法  用规则匹配整个字符串 只有有一处不符合，就匹配结束
 * 
 * 2、切割：String split方法   
 * 
 * 3、替换：String replaceAll方法 
 * 
 */
public class Regex_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//checkQQ();
		//Test();
		//cheakPhone();
		//splittTest();
		repleaceAllTest();
	}
	
	//把一个字符串中符合规则的部分替换成另一个字符串
	private static void repleaceAllTest() {
		// TODO Auto-generated method stub
		String str = "";
		String reg = "";
		String newStr = "";
		
		//将字符串中的数字替换成"#"
		/*str = "ver1123243ty9898dsdsf4232vsxde09898999lskdji";
		reg = "\\d{5,}"; //连续5个或5个以上的数字替换成"#"
		newStr = "#";*/
		
		//将叠词替换成"&"
		/*str = "aabccdeefggggghkkkkkkkf";
		reg = "(.)\\1+";
		newStr = "&";*/
		
		//将叠词替换成单个字母     待替换字符中使用组中数据（$n）    用$获取组的概念(与组不在一个字符串中时使用组)
		str = "aabccdeefggggghkkkkkkkf";
		reg = "(.)\\1+";
		newStr = "$1";
		
		
		str = str.replaceAll(reg, newStr);
		sop(str);
	}

	private static void splittTest() {
		// TODO Auto-generated method stub
		//" "空格切割
		//String str = "zhangsan   lisi   wangwu";
		//String reg = " +";  //按照多个空格来切割
		
		//"."切割
		/*String str = "zhangsan.lisi.wangwu";
		//String reg = ".";  //"."属于正则表达式中的特殊符合   需要将"."转义 为"\\." ("\."为正则表达式中的任意字符，故"."转义需要"\\") 
		String reg = "\\.";*/
		
		//"\\"切割
		/*String str = "c:\\abc\\a.txt";
		String reg = "\\\\";*/
		
		//为了让规则的结果被重用，可以将规则封装成一个组，用小括号完成，组的出现都有编号，从1开始，想要使用已有的组可以通过\n（n就是组的编号）的方式获取 
		//举例：((())()):共有4组(看左括号)，第一个左括号就是第一组，第二个左括号就是第二组，以此类推
		//"(.)\1"叠词切割   组(.)  第一位定义为：(.)第一组    第二位使用第一组的数据：\\1(使用第一组\1) 
		//String str = "abbcddeffghhk";
		//String reg = "(.)\\1";
		
		//"(.)\1"叠词切割   组(.)  第一位定义为：(.)第一组    第二位使用第一组的数据：\\1(使用第一组\1) 
		/*String str = "abbbcdddefffghhk";
		String reg = "(.)\\1+";*/
		
		//"(.)\1"叠词切割   组(.)  第一位定义为：(.)第一组    第二位使用第一组的数据：\\1(使用第一组\1) 
		String str = "abbbcdddefffghhk";
		String reg = "(.)\\1+";
				
		String[] arr = str.split(reg);
		sop(arr.length);
		for (String s:arr){
			sop(s);
		}
	}

	private static void Test() {
		// TODO Auto-generated method stub
		//字符类
		String reg = "[bcd]"; //规则：被作用的字符串中的第一个字符只能是b或者c或者d其中的一个,而且这个字符串只能有一个字符
		sop("a".matches(reg));//将规则reg作用到字符串str上，
		sop("b".matches(reg));
		sop("ab".matches(reg));
		
		String reg2 = "[bcd][a-z]";//规则：被作用的字符串只能有两个字符，第一个是b或者c或者d,第二个可以是a到z之间的任意字符
		sop("bd".matches(reg2));
		sop("b9".matches(reg2));
		sop("brr".matches(reg2));
		
		String reg3 = "[^bcd]";//规则：被作用的字符串第一个字符不能是b、c、d字符
		sop("a".matches(reg3));
		sop("ab".matches(reg3));
		sop("ff".matches(reg3));
		
		String reg4 = "[a-zA-Z]";//规则：被作用的字符串第一个字符可以是a到z或者A-Z中任意字符
		String reg5 = "[a-d[n-p]]";//规则：被作用的字符串第一个字符可以是a到d或者n-p:[a-dn-p](并集)
		String reg6 = "[a-z&&[def]]";//规则：被作用的字符串第一个字符可以是d、e或者f(交集)
		String reg7 = "[a-z&&[^bc]]";//规则：被作用的字符串第一个字符可以是a到z中除了b和c:[ad-z](减去)
		String reg8 = "[a-z&&[n-p]]";//规则：被作用的字符串第一个字符可以是a到z中除了n-p:[a-mq-z](减去)
		
		//预定义字符
		String reg10 = ".";   //规则:"."所在字符可以是任意字符
		String reg11 = "\\d";   //规则:"\d"代表数字[0-9]
		String reg12 = "\\D";   //规则:"\D"所在字符能不能是0-9
		String reg13 = "\\s";   //规则:"\s"所在字符空白字符[\t\n\x0B\f\r]  //\x0B
		String reg14 = "\\S";   //规则:"\S"所在字符非空白字符[^\s]
		String reg15 = "\\v";   //规则:"\v"所在字符单词字符[a-zA-Z_0-9]
		String reg16 = "\\V";   //规则:"\V"所在字符非单词字符[^\v]
		
		//Greedy 数量词
		/*
		X?	X，一次或一次也没有
		X*	X，零次或多次
		X+	X，一次或多次
		X{n}	X，恰好 n 次
		X{n,}	X，至少 n 次
		X{n,m}	X，至少 n 次，但是不超过 m 次
		*/
	}

	private static void sop(Object obj) {
		// TODO Auto-generated method stub
		System.out.println(obj);
	}
	
	/*
	 * 对QQ号码进行校验
	 * 要求：5~15  0不能开头，只能是数字
	 * 
	 */
	public static void checkQQ(){
		String qq = "123556676767";
		String regex = "[1-9][0-9]{4,14}";  //第一位1到9，第二位0到9，第二位可以出现4到14次  "[1-9]\\d{4-14}"
		System.out.println(qq.matches(regex));
	}

	/*
	 * 匹配：
	 * 手机号段只有：13xxxx,15xxx,18xxx
	 */
	private static void cheakPhone() {
		// TODO Auto-generated method stub
		String tel = "";
		String telreg = "1[358]\\d{9}";
		sop(tel.matches(telreg));
	}

}
