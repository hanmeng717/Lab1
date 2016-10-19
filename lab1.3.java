change@3
public static void Change (String str)//用于处理字符串中的系数，将多项式系数变成易于操作的数据结构

	{
		ArrayList<String> xishuf  =  new ArrayList<String>();
		String regx1="\\+|\\-";//按照+或者减号
		String[] arryinshi=str.split(regx1);//将整个多项式分解成多个因式
		for(String s:arryinshi)//对每个因式进行操作
		{
			xishuf.clear();
			boolean flag=true;
			//String regx2="([0-9]+\\.[0-9]+\\^?[1-9]*[0-9]*)|([1-9][0-9]*\\^?[1-9]*[0-9]*)";//找出系数
			String regx2="[1-9]+[0-9]*\\.?[0-9]*\\^?[1-9]*[0-9]*";//找出系数
			Pattern p=Pattern.compile(regx2);
			Matcher m=p.matcher(s);//取出每个因式中的数字项（即系数），另：如果系数中有次方比如2^3,则先不计算单独留出
			int index0=-1;
			while (m.find())
			{
				//index0++;
				index0=s.indexOf(m.group(),index0+1);
				if (index0>=1)
				{
					if(s.charAt(index0-1)!='^' & s.charAt(index0-1)!='.')
					{
						xishuf.add(m.group());
					}
				}
				else
				{
					xishuf.add(m.group());
				}
			}
			for(String s1:xishuf)//找出乘方形式的系数,并计算结果
			{
				String regx3="([0-9]+\\.[0-9]+\\^[1-9]*[0-9]*)|([1-9][0-9]*\\^[1-9]*[0-9]*)";
				Pattern pattern = Pattern.compile(regx3);
				Matcher matcher = pattern.matcher(s1);
				boolean b= matcher.matches();
				if(b)
				{
					flag=false;
				}
				if(!flag)//此时s1是a^b的形式
				{
					double t1=0;
					double t2=0;
					int index1;
					String regx4="\\^";
					String[] arrtemp=s1.split(regx4);
					t1=Double.parseDouble(arrtemp[0]);//将底数和指数分别存入t1和t2
					t2=Double.parseDouble(arrtemp[1]);
					t1=Math.pow(t1,t2);//计算乘方的值
					index1=xishuf.indexOf(s1);
					xishuf.set(index1, String.valueOf(t1));//用计算结果替换掉原来的a^b形式
				}
			}
			double num=1.0;
			for(String s2:xishuf)
			{
				num=num*Double.parseDouble(s2);
			}
			xishu.add(num);
		}
		//System.out.print(xishu);
		xishunew=xishu;
		//System.out.print('\n');
	}