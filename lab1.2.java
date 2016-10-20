public static String In()//输入函数
	{
	    System.out.println("hahaha");
		Scanner input=new Scanner(System.in);
		String duoxiangshi=input.nextLine();//读入多项式，将字符串保存到字符串duoxiangshi中
		return duoxiangshi;
	}
	public static String Check (String str)//检验输入是否含有非法字符
	{
		String regx0="[^	a-zA-Z0-9\\+\\-\\*\\^\\. ]";
		Pattern p = Pattern.compile(regx0);
		Matcher m = p.matcher(str);
		boolean flag=m.find();//查找非法输入的字符，输入的字符不能包括除了合法数字字母以及运算符之外的任何字符
		if(flag)
		{
			System.out.println("非法输入！请重新输入：");
		}//如果检验到非法字符则输入异常
		else
		{
			str=str.replaceAll(" *", "");//处理空格，将所有空格都替换成空
			str=str.replaceAll("	*", "");//处理tab，将所有空格都替换成空
			System.out.println(str);

		}
		return str;
	}
